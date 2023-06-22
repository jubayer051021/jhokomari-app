package com.jhokomari.reviewapp.repository;

import com.jhokomari.reviewapp.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity,Long> {
    ReviewEntity findByUserName(String userName);

    List<ReviewEntity> findAllByBookId(Long bookId);

    ReviewEntity findByBookId(Long bookId);

    ReviewEntity findByUserNameAndBookId(String name,Long bookId);
}
