package dev.sounak.movies.controller;

import dev.sounak.movies.entity.Review;
import dev.sounak.movies.repository.ReviewRepository;
import dev.sounak.movies.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        Review createdReview = reviewService.createReview(payload.get("imdbId"), payload.get("reviewBody"));
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }
}
