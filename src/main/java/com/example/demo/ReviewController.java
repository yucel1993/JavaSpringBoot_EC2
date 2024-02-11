package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService service;
    @Autowired
    private MovieService movieService;
    @GetMapping("/{imdbId}/reviews")
    public ResponseEntity<List<Review>> getMovieReviews(@PathVariable String imdbId) {

        return new ResponseEntity<List<Review>>(movieService.findMovieByImdbId(imdbId).get().getReviews(), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {

        return new ResponseEntity<Review>(service.createReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.OK);
    }
}