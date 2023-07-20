package org.example.Services;

import org.example.Domain.Review;
import org.example.Repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getReviewByMovieId(int id) {
        return reviewRepository.findByMovieId(id);
    }

    @Override
    public List<Review> getReviewByReviewer(String reviewer) {
        return reviewRepository.findReviewByReviewer(reviewer);
    }
}

