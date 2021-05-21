package com.epam.taskone;

import com.epam.taskone.domain.Event;

import java.util.List;

public interface EventService {

  Event createEvent(Event event);

  Event updateEvent(Long eventId, Event event);

  Event getEvent(Long id);

  void deleteEvent(Long id);

  List<Event> getAllEvents();

  List<Event> getAllEventsByTitle(String title);

}
