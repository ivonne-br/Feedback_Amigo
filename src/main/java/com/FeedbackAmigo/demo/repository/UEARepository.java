package com.FeedbackAmigo.demo.repository;

import com.FeedbackAmigo.demo.entity.UEAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UEARepository extends JpaRepository<UEAEntity, Long> {
   List<UEAEntity> findByNombreContainingIgnoreCase(String nombre);
   Optional<UEAEntity> findByNombreIgnoreCase(String nombre);
}
