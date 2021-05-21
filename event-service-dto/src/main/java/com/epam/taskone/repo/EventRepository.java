package com.epam.taskone.repo;

import com.epam.taskone.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

  List<Event> findAllByTitle(String title);
}
