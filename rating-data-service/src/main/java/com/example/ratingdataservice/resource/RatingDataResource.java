package com.example.ratingdataservice.resource;

import com.example.ratingdataservice.model.Rating;
import com.example.ratingdataservice.model.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingDataResource {

    @RequestMapping("/{movieId}")
    public Rating getMovieRating(@PathVariable("movieId") String movieId) {

        return new Rating(movieId, 4);
    }


    @RequestMapping("/user/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating("1235",4),
                new Rating("6789",3)
        );
        UserRating userRating = new UserRating();
        userRating.setRatings(ratings);
        return userRating;
    }

}
