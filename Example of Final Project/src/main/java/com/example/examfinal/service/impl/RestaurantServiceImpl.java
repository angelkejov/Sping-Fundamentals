package com.example.examfinal.service.impl;


import com.example.examfinal.model.entity.CityEntity;
import com.example.examfinal.model.entity.Restaurant;
import com.example.examfinal.model.entity.UserEntity;
import com.example.examfinal.model.entity.UserRoleEntity;
import com.example.examfinal.model.entity.enums.PriceEnum;
import com.example.examfinal.model.entity.enums.RestaurantType;
import com.example.examfinal.model.entity.enums.UserRoleEnum;
import com.example.examfinal.model.view.RestaurantDetailsView;
import com.example.examfinal.model.view.RestaurantViewModel;
import com.example.examfinal.repository.CityRepository;
import com.example.examfinal.repository.RestaurantRepository;
import com.example.examfinal.repository.UserRepository;
import com.example.examfinal.service.RestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, CityRepository cityRepository, ModelMapper modelMapper, UserRepository userRepository) {
        this.restaurantRepository = restaurantRepository;
        this.cityRepository = cityRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<RestaurantViewModel> getAllRestaurants() {
        return restaurantRepository.findAll().stream().map(this::map).collect(Collectors.toList());
    }

    @Override
    public void initializeRestaurants() {
        if (restaurantRepository.count() == 0) {
            Restaurant restaurant = new Restaurant();

            restaurant.setName("Niagara");
            restaurant.setAddress("Krasno selo");
            restaurant.setRestaurantType(RestaurantType.BULGARIAN);
            restaurant.setPriceRange(PriceEnum.EXPENSIVE);
            restaurant.setMenu("Risotto with chicken\n" +
                    "broccoli, corn and parmesan (300gr.)\n" +
                    "9,99 lv.\n" +
                    "Adds the product to the basket\n" +
                    "Crispy pork fillet on onion\n" +
                    "jam and mashed potatoes with truffles\n" +
                    "20,99 lv.\n" +
                    "Adds the product to the basket\n" +
                    "Viennese pork schnitzel\n" +
                    "with french fries and butter / 350g\n" +
                    "17,99 lv.");
            restaurant.setRating("Very GOOD");
            restaurant.setImg("https://rezzo.bg/files/images/22168/fit_431_304.jpg");
            restaurant.setCity(cityRepository.findByName("Sofia").orElse(null));

            Restaurant restaurant1 = new Restaurant();

            restaurant1.setName("Kaktus");
            restaurant1.setAddress("Lozenec");
            restaurant1.setRestaurantType(RestaurantType.BULGARIAN);
            restaurant1.setPriceRange(PriceEnum.EXPENSIVE);
            restaurant1.setRating("GOOD");
            restaurant1.setMenu("\n" +
                    "ОВЧАРСКА САЛАТА300 гр.9.98лв - домати, краставици, лук, чушки, гъби, яйце, сирене, шунка, маслини, магданоз\n" +
                    "ТРИО РАЗЯДКИ300 гр.9.98лв - с патладжан, чушки и трохи от сирене; млечно-пикантна; разядка с пресен лук и трохи от сирене, поднесени с топли кростини\n" +
                    "САЛАТА ОТ РОЗОВИ ДОМАТИ, МАРИНОВАНА ЧУШКА И БИВОЛСКО СИРЕНЕ300 гр.12.98лвподнесена с маслини Таджаска и пресен босилек\n" +
                    "САЛАТА ЦЕЗАР300 гр.13.98лвпилешки филенца поднесени върху канапе от айсберг, хрупкави крутони, пармезан, поширано яйце, чипс от бекон и класически Цезар сос\n" +
                    "САЛАТА КОЗЕ СИРЕНЕ С ЧЕРЕШОВА РЕДУКЦИЯ300 гр.13.98лвзапечено козе сирене поднесено с фризе, салата лоло росо и цикория, овкусена с черешова редукция и нар\n" +
                    "САЛАТА С БУРАТА, ПРОШУТО И РОЗОВИ ДОМАТИ300 гр.14.98лвсирене бурата поднесено върху канапе от розови домати с прошуто, кедрови ядки и босилек, овкусена със зехтин\n" +
                    "САЛАТА ОТ СОТИРАНИ ТИГРОВИ СКАРИДИ ПО ПРОВАНСАЛСКИ300 гр.");
            restaurant1.setImg("https://zavedenia.com/zimages/sofia/big/600/6006ccbfe7ac4f7ba464db9e00ed5b1b2941.jpg");
            restaurant1.setCity(cityRepository.findByName("Sofia").orElse(null));

            restaurantRepository.saveAll(List.of(restaurant, restaurant1));
        }
    }

    @Transactional
    @Override
    public RestaurantDetailsView findById(Long id) {
        RestaurantDetailsView restaurantDetailsView = this.restaurantRepository.findById(id).map(this::restaurantDetailsView).get();
        return restaurantDetailsView;
    }




    private RestaurantDetailsView restaurantDetailsView(Restaurant restaurant) {
        RestaurantDetailsView restaurantDetailsView = this.modelMapper.map(restaurant, RestaurantDetailsView.class);

        return restaurantDetailsView;
    }

    private RestaurantViewModel map(Restaurant restaurant) {

        return this.modelMapper.map(restaurant, RestaurantViewModel.class);
    }

}
