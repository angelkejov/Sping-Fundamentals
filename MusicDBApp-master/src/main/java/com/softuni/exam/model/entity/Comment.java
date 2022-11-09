package com.softuni.exam.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment extends Base{

    @Column(columnDefinition = "TEXT")
    private String comment;

    @ManyToOne
    private User authorOfComment;

    public Comment() {

    }

    public Comment(String comment, User authorOfComment) {
        this.comment = comment;
        this.authorOfComment = authorOfComment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getAuthorOfComment() {
        return authorOfComment;
    }

    public void setAuthorOfComment(User authorOfComment) {
        this.authorOfComment = authorOfComment;
    }
}
