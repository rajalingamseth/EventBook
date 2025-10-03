package com.example.demo.Repositories;

import com.example.demo.Models.Events;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Events, Integer> {

}
