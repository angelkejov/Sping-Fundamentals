package com.example.examfinal.web;

import com.example.examfinal.model.binding.NewCommentBindingModel;
import com.example.examfinal.model.service.CommentServiceModel;
import com.example.examfinal.model.validator.ApiError;
import com.example.examfinal.model.view.CommentViewModel;
import com.example.examfinal.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.security.Principal;
import java.util.List;

@RestController
public class CommentRestController {

    private final CommentService commentService;
    private final ModelMapper modelMapper;

    public CommentRestController(CommentService commentService,
                                 ModelMapper modelMapper) {
        this.commentService = commentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/api/{placedId}/comments")
    public ResponseEntity<List<CommentViewModel>> getComments(
            @PathVariable Long placeId,
            Principal principal
    ) {
        return ResponseEntity.ok(
                commentService.getComments(placeId));
    }

    @PostMapping("/api/{placeId}/comments")
    public ResponseEntity<CommentViewModel> newComment(
            @AuthenticationPrincipal UserDetails principal,
            @PathVariable Long placeId,
            @RequestBody @Valid NewCommentBindingModel newCommentBindingModel
    ) {
        CommentServiceModel serviceModel =
                modelMapper.map(newCommentBindingModel, CommentServiceModel.class);
        serviceModel.setCreator(principal.getUsername());
        serviceModel.setPlaceId(placeId);

        CommentViewModel newComment =
                commentService.createComment(serviceModel);

        URI locationOfNewComment =
                URI.create(String.format("/api/%s/comments/%s", placeId, newComment.getCommentId()));

        return ResponseEntity.
                created(locationOfNewComment).
                body(newComment);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> onValidationFailure(MethodArgumentNotValidException exc) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        exc.getFieldErrors().forEach(fe ->
                apiError.addFieldWithError(fe.getField()));

        return ResponseEntity.badRequest().body(apiError);
    }


}
