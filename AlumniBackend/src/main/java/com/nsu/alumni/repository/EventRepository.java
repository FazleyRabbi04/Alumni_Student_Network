package com.nsu.alumni.repository;

import com.nsu.alumni.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {}
