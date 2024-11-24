package com.ssafy.edu.review.model.Service;

import com.ssafy.edu.review.model.dao.ReviewDao;
import com.ssafy.edu.review.model.dto.Review;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReviewServiceImpl implements ReviewService {
    
    private final ReviewDao reviewDao;
    
    public ReviewServiceImpl(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }
    
    @Override
    public List<Review> reviewList() {
        return reviewDao.reviewList();
    }
    
    @Override
    public int addReview(Review review) {
        return reviewDao.addReview(review);
    }
    
    @Override
    public int updateReview(Review review) {
        return reviewDao.updateReview(review);
    }
    
    @Override
    public int deleteReview(int reviewId) {
        return reviewDao.deleteReview(reviewId);
    }
    
    @Override
    public Review reviewDetail(int reviewId) {
        return reviewDao.reviewDetail(reviewId);
    }
    
    @Override
    public List<Review> searchByTitle(Map<String, Object> params) {
        return reviewDao.searchByTitle(params);
    }
    
    @Override
    public int getTitleSearchCount(Map<String, Object> params) {
        return reviewDao.getTitleSearchCount(params);
    }
    
    @Override
    public List<Review> searchByWriter(Map<String, Object> params) {
        return reviewDao.searchByWriter(params);
    }
    
    @Override
    public int getWriterSearchCount(Map<String, Object> params) {
        return reviewDao.getWriterSearchCount(params);
    }
    
    @Override
    public List<Review> getReviewsByPlace(Map<String, Object> params) {
        return reviewDao.getReviewsByPlace(params);
    }
    
    @Override
    public int getPlaceReviewCount(int placeId) {
        return reviewDao.getPlaceReviewCount(placeId);
    }
}
