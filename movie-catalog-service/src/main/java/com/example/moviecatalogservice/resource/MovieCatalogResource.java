package com.example.moviecatalogservice.resource;

import com.example.moviecatalogservice.model.CatalogItem;
import com.example.moviecatalogservice.model.Movie;
import com.example.moviecatalogservice.model.Rating;
import com.example.moviecatalogservice.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    //@Autowired
    //private WebClient.Builder webClientBuilder;

    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalogItem(@PathVariable("userId") String userId){
        UserRating userRating = restTemplate.getForObject("http://localhost:8085/ratings/" + userId,UserRating.class);
        List<Rating> ratings = Arrays.asList(
                new Rating("1235",4),
                new Rating("6789",3)
        );
        return ratings.stream().map(rating -> {
            Movie movie= restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(),Movie.class);
           /* Movie movie=webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/movies/"+ rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();*/
            return new CatalogItem(movie.getName(), "Test", rating.getRating());
                })
                .collect(Collectors.toList());
    }
}
