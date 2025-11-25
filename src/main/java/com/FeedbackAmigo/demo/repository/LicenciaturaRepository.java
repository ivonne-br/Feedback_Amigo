package com.FeedbackAmigo.demo.repository;

import com.FeedbackAmigo.demo.entity.Licenciatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenciaturaRepository extends JpaRepository<Licenciatura, Long> {
}
