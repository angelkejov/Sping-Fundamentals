package com.example.examfinal.service.impl;

import com.example.examfinal.model.entity.PlaceEntity;
import com.example.examfinal.model.entity.enums.NameType;
import com.example.examfinal.model.entity.enums.RatingEnum;
import com.example.examfinal.model.view.PlaceDetailsViewModel;
import com.example.examfinal.model.view.PlaceViewModel;
import com.example.examfinal.repository.CityRepository;
import com.example.examfinal.repository.PlaceRepository;
import com.example.examfinal.repository.UserRepository;
import com.example.examfinal.service.PlaceService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepository placeRepository;
    private final CityRepository cityRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public PlaceServiceImpl(PlaceRepository placeRepository, CityRepository cityRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.placeRepository = placeRepository;
        this.cityRepository = cityRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public List<PlaceViewModel> getAllPlace() {
        return placeRepository.
                findAll().
                stream().
                map(this::map).
                collect(Collectors.toList());
    }

    @Override
    public void initializePlace() {
        if (placeRepository.count() == 0) {

            PlaceEntity emona = new PlaceEntity();
            emona.setName("Emona");
            emona.setDescription("Emona is a village and seaside resort in southeast Bulgaria, situated in the Nesebar Municipality of the Burgas Province. The beach Irakli is 5 km from Emona. Emona lies close to Cape Emine. There are ruins of the ancient fortress nearby.");
            emona.setImageUrl("https://upload.wikimedia.org/wikipedia/commons/f/fa/Emona-Evgord.jpg");
            emona.setRating(RatingEnum.VERY_GOOD);
            emona.setType(NameType.NATURAL_SIGHTS);
            emona.setCity(cityRepository.findByName("Varna").orElse(null));

            PlaceEntity ndk = new PlaceEntity();
            ndk.setName("NDK");
            ndk.setDescription("The National Palace of Culture, located in Sofia, the capital of Bulgaria, is the largest, multifunctional conference and exhibition centre in south-eastern Europe. It was opened in 1981 in celebration of Bulgaria's 1300th anniversary.");
            ndk.setImageUrl("https://www.novinite.com/media/images/2017-01/photo_verybig_178274.jpg");
            ndk.setRating(RatingEnum.VERY_GOOD);
            ndk.setType(NameType.CULTURE_AND_ART);
            ndk.setCity(cityRepository.findByName("Sofia").orElse(null));

            placeRepository.saveAll(List.of(emona, ndk));
        }
    }
    @Override
    public void deletePlace(Long id) {
        placeRepository.deleteById(id);
    }

    @Transactional
    @Override
    public PlaceDetailsViewModel findById(Long id) {
        PlaceDetailsViewModel placeDetailsViewModel = this.placeRepository.findById(id).map(this::mapDetailsView).get();
        return placeDetailsViewModel;
    }


    private PlaceViewModel map(PlaceEntity placeEntity) {
        PlaceViewModel placeViewModel = this.modelMapper.map(placeEntity, PlaceViewModel.class);
        return placeViewModel;
    }

    private PlaceDetailsViewModel mapDetailsView(PlaceEntity place) {
        PlaceDetailsViewModel placeDetailsViewModel = this.modelMapper.map(place, PlaceDetailsViewModel.class);

        return placeDetailsViewModel;
    }
}
