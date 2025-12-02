package com.FeedbackAmigo.demo.repository;

import com.FeedbackAmigo.demo.entity.UEAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UEARepository extends JpaRepository<UEAEntity, Long> {
}
