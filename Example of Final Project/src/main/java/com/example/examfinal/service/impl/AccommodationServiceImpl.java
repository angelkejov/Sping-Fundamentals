package com.example.examfinal.service.impl;

import com.example.examfinal.model.entity.Accommodation;
import com.example.examfinal.model.entity.enums.TypeAccommodationEnum;
import com.example.examfinal.model.view.AccommodationDetailsView;
import com.example.examfinal.model.view.AccomodationViewModel;
import com.example.examfinal.repository.AccommodationRepository;
import com.example.examfinal.repository.CityRepository;
import com.example.examfinal.service.AccommodationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccommodationServiceImpl implements AccommodationService {
    private final AccommodationRepository accommodationRepository;
    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository, CityRepository cityRepository, ModelMapper modelMapper) {
        this.accommodationRepository = accommodationRepository;
        this.cityRepository = cityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AccomodationViewModel> getAllAccommodation() {
        return accommodationRepository.findAll().stream().map(this::map).collect(Collectors.toList());

    }

    @Override
    public void initializeAccommodation() {
        if (accommodationRepository.count() == 0) {
            Accommodation accommodation = new Accommodation();
            accommodation.setName("Grand Hotel");
            accommodation.setAddress("Ivan Vazov");
            accommodation.setDescription("Dominating the heart of the city Grand Hotel Sofia is a deluxe five-star hotel that has been home for international business travelers, high-profile events and cosmopolitan society since 2004. Art-lovers and food connoisseurs alike will appreciate the hotel gallery and its fine-dining Shades of Red restaurant.");
            accommodation.setPrice(700.88);
            accommodation.setRating(9.6);
            accommodation.setNumberOfRooms(100);
            accommodation.setType(TypeAccommodationEnum.HOTEL);
            accommodation.setWi_fi(true);
            accommodation.setImageUrl("https://media-cdn.tripadvisor.com/media/photo-p/19/cc/43/d3/kristianivanov.jpg");
            accommodation.setCity(cityRepository.findByName("Sofia").orElse(null));
            accommodation.setCreated(Instant.now());
            accommodation.setModified(Instant.now());
            accommodation.setId(1L);


            Accommodation accommodation1 = new Accommodation();
            accommodation1.setName("Marinela");
            accommodation1.setAddress("Lozenets");
            accommodation1.setDescription("Five Star Marinela Hotel Sofia has been designed by the renowned Japanese architect Kisho Kurokawa, the author of a number of world landmarks. The hotel is located on an area of \u200B\u200B30,000 square meters, there are 442 rooms and suites, including the largest Presidential Suite in Bulgaria. The Hotel Marinela can satisfy the most discerning tastes and needs.");
            accommodation1.setPrice(300.98);
            accommodation1.setRating(5.0);
            accommodation1.setNumberOfRooms(100);
            accommodation1.setType(TypeAccommodationEnum.HOTEL);
            accommodation1.setWi_fi(true);
            accommodation1.setImageUrl("https://cf.bstatic.com/xdata/images/hotel/max1024x768/55410911.jpg?k=ad5803c7455ac784787f9443a91a95577e5ff6c3cbea7b28305453c22e8fc609&o=&hp=1");
            accommodation1.setCity(cityRepository.findByName("Sofia").orElse(null));
            accommodation1.setId(2L);

            accommodationRepository.saveAll(List.of(accommodation, accommodation1));

        }
    }



    private AccomodationViewModel map(Accommodation accommodation) {
        AccomodationViewModel accomodationViewModel =
                this.modelMapper.map(accommodation, AccomodationViewModel.class);

        return accomodationViewModel;
    }
    @Transactional
    @Override
    public AccommodationDetailsView findById(Long id) {
        AccommodationDetailsView accommodationDetailsView = this.accommodationRepository.findById(id).map(this::restaurantDetailsView).get();
        return accommodationDetailsView;
    }


    private AccommodationDetailsView restaurantDetailsView(Accommodation accommodation) {
        AccommodationDetailsView accommodationDetailsView = this.modelMapper.map(accommodation, AccommodationDetailsView.class);

        return accommodationDetailsView;
    }
}
