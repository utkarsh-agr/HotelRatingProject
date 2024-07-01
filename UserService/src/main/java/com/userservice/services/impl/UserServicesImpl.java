package com.userservice.services.impl;

import com.userservice.entities.User;
import com.userservice.exceptions.ResourceNotFoundException;
import com.userservice.externalServices.ApiGatewayService;
import com.userservice.payloads.Hotel;
import com.userservice.payloads.Rating.Rating;
import com.userservice.repositories.UserRepository;
import com.userservice.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ApiGatewayService apiGatewayService;

    //private Logger logger= LoggerFactory.getLogger(UserServicesImpl.class);

    @Override
    public User saveUser(User user) {
        user.setId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users=userRepository.findAll();
        return users.stream().peek(user-> user.setRatings(getRatingsAndHotelOfUser(user))).toList();
//        for (User user : users)
//            user.setRatings(getRatingsAndHotelOfUser(user));
//        return users;

    }

    @Override
    public User getUserById(String userId) {
        User user=this.userRepository.findById(userId).orElseThrow(ResourceNotFoundException::new);


        //Rating[] ratingsOfUser=restTemplate.getForObject("http://RATING-SERVICE/ratings/user/"+userId, Rating[].class);
        //assert ratingsOfUser != null;
        //List<Rating> ratings= Arrays.stream(ratingsOfUser).toList();
        //logger.info("{} ",ratings);

        List<Rating> ratings=getRatingsAndHotelOfUser(user);
        user.setRatings(ratings);

        return user;
    }

    private List<Rating> getRatingsAndHotelOfUser(User user) {
        List<Rating> ratings= apiGatewayService.getRatingsOfUser(user.getId());
        if(ratings==null) ratings=new ArrayList<>();
        if(!ratings.isEmpty()){
            return ratings.stream().map(rating -> {
                Hotel hotel=apiGatewayService.getHotel(rating.getHotelId());
                //Hotel hotel=restTemplate.getForObject("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
                //hotel=null;
                rating.setHotel(hotel);
                return rating;
            }).toList();
        }
        return ratings;
    }
}
