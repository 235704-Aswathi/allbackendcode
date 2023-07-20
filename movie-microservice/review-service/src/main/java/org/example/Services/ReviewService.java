package org.example.Services;

import org.example.Domain.Review;

import java.util.List;

public interface ReviewService {

    Review createReview(Review review);

    List<Review> getReviewByMovieId(int id);

    List<Review> getReviewByReviewer(String reviewer);
}

