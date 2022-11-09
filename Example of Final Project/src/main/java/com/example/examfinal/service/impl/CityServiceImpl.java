package com.example.examfinal.service.impl;


import com.example.examfinal.model.binding.CityAddBindModel;
import com.example.examfinal.model.entity.CityEntity;
import com.example.examfinal.model.entity.UserEntity;
import com.example.examfinal.model.entity.UserRoleEntity;
import com.example.examfinal.model.entity.enums.AreaOfBg;
import com.example.examfinal.model.entity.enums.CapitalOrNot;
import com.example.examfinal.model.entity.enums.UserRoleEnum;
import com.example.examfinal.model.service.CityAddServiceModel;
import com.example.examfinal.model.service.CityUpdateServiceModel;
import com.example.examfinal.model.view.CityDetailsView;
import com.example.examfinal.model.view.CityView;
import com.example.examfinal.repository.CityRepository;
import com.example.examfinal.repository.PlaceRepository;
import com.example.examfinal.repository.UserRepository;
import com.example.examfinal.service.CityService;
import com.example.examfinal.service.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;
    private final PlaceRepository placeRepository;
    private final UserRepository userRepository;

    public CityServiceImpl(CityRepository cityRepository, ModelMapper modelMapper, PlaceRepository placeRepository, UserRepository userRepository) {
        this.cityRepository = cityRepository;
        this.modelMapper = modelMapper;
        this.placeRepository = placeRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void initializeCities() {
        if (cityRepository.count() == 0) {
            CityEntity city = new CityEntity();

            city.setCapitalOrNot(CapitalOrNot.CAPITAL);
            city.setName("Sofia");
            city.setImageUrl("https://www.aviontourism.com/images/1200-628-Crop/c979445e-9ed5-43e8-ae04-e6149fb8eb31");
            city.setYear(1950);
            city.setMayor("Yordanka Asenova Fandakova");
            city.setAreaOfBg(AreaOfBg.SOUTH);
            city.setDescription("Sofia is the 14th largest city in the European Union. It is surrounded by mountainsides, such as Vitosha by the southern side, Lyulin by the western side, and the Balkan Mountains by the north, which makes it the third highest European capital after Andorra la Vella and Madrid. ");
            city.setUser(userRepository.findByUsername("admin").orElse(null));

            CityEntity city1 = new CityEntity();
            city1.setCapitalOrNot(CapitalOrNot.CITY);
            city1.setName("Varna");
            city1.setImageUrl("https://dynamic-media-cdn.tripadvisor.com/media/photo-o/15/4d/45/a5/varna.jpg?w=700&h=500&s=1");
            city1.setYear(1940);
            city1.setMayor("Ivan Portnih");
            city1.setAreaOfBg(AreaOfBg.EAST);
            city1.setDescription("Varna is a port city and seaside resort on Bulgaria's Black Sea, next to the coastal resorts of Golden Sands, St. Konstantin and Albena. It's famous for the \"Gold of Varna,\" 6,000-year-old Thracian jewelry discovered in a necropolis, which is displayed inside the Archaeological Museum, along with Greek, Roman and Ottoman antiquities. ");
            city1.setUser(userRepository.findByUsername("admin").orElse(null));

            cityRepository.saveAll(List.of(city, city1));
        }
    }


    @Override
    public List<CityView> getAllCities() {
        return cityRepository.
                findAll().
                stream().
                map(this::map).
                collect(Collectors.toList());
    }

    @Override
    public CityDetailsView findById(Long id) {
        CityDetailsView cityDetailsView = this.cityRepository.findById(id).map(this::mapDetailsView).get();
        return cityDetailsView;
    }

    @Override
    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public boolean isOwner(String userName, Long id) {
        Optional<CityEntity> cityOpt = cityRepository.
                findById(id);
        Optional<UserEntity> caller = userRepository.
                findByUsername(userName);

        if (cityOpt.isEmpty() || caller.isEmpty()) {
            return false;
        } else {
            CityEntity cityEntity = cityOpt.get();

            return isAdmin(caller.get()) ||
                    cityEntity.getUser().getUsername().equals(userName);
        }
    }

    private boolean isAdmin(UserEntity user) {
        return user.
                getRoles().
                stream().
                map(UserRoleEntity::getRole).
                anyMatch(r -> r == UserRoleEnum.ADMIN);
    }

    @Override
    public void updateCity(CityUpdateServiceModel cityUpdate) {
        CityEntity city =
                cityRepository.findById(cityUpdate.getId()).orElseThrow(() ->
                        new ObjectNotFoundException("Offer with id " + cityUpdate.getId()
                                + " not found!"));

        city.setName(cityUpdate.getName());
        city.setDescription(cityUpdate.getDescription());
        city.setMayor(cityUpdate.getMayor());
        city.setImageUrl(cityUpdate.getImageUrl());
        city.setYear(cityUpdate.getYear());
        city.setAreaOfBg(cityUpdate.getAreaOfBg());
        city.setCapitalOrNot(cityUpdate.getCapitalOrNot());

        cityRepository.save(city);
    }

    @Override
    public CityAddServiceModel addCity(CityAddBindModel cityAddBindModel, String ownerId) {
        UserEntity userEntity = userRepository.findByUsername(ownerId).orElseThrow();
        CityAddServiceModel cityAddServiceModel = modelMapper.map(cityAddBindModel,
                CityAddServiceModel.class);
        CityEntity newCity = modelMapper.map(cityAddBindModel, CityEntity.class);
        newCity.setCreated(Instant.now());
        newCity.setUser(userEntity);


        CityEntity savedCity = cityRepository.save(newCity);
        return modelMapper.map(savedCity, CityAddServiceModel.class);
    }


    private CityView map(CityEntity cityEntity) {
        CityView cityView = this.modelMapper.map(cityEntity, CityView.class);

        return cityView;
    }

    private CityDetailsView mapDetailsView(CityEntity city) {
        CityDetailsView cityDetailsView = this.modelMapper.map(city, CityDetailsView.class);
        return cityDetailsView;
    }
}
