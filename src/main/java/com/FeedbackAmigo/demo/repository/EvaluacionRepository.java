package com.FeedbackAmigo.demo.repository;

import com.FeedbackAmigo.demo.entity.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluacionRepository  extends JpaRepository<Evaluacion, Long> {

}
