package com.epam.taskone;

import com.epam.taskone.domain.Event;
import com.epam.taskone.repo.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EventServiceImpl implements EventService{

  private final EventRepository eventRepository;

  @Override
  public Event createEvent(Event event) {
    return eventRepository.save(event);
  }

  @Override
  public Event updateEvent(Long eventId, Event newEvent) {
    return eventRepository.findById(eventId)
        .map(event ->{
          event.setPlace(newEvent.getPlace());
          event.setTitle(newEvent.getTitle());
          event.setSpeaker(newEvent.getSpeaker());
          event.setDateTime(newEvent.getDateTime());
          event.setEventType(newEvent.getEventType());
          return eventRepository.save(event);
        }).orElseGet(() -> {
          newEvent.setId(eventId);
          return eventRepository.save(newEvent);
        });
  }

  @Override
  public Event getEvent(Long id) {
    return eventRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Event with id: " + id + " doesn't exist"));
  }

  @Override
  public void deleteEvent(Long id) {
    eventRepository.deleteById(id);
  }

  @Override
  public List<Event> getAllEvents() {
    return eventRepository.findAll();
  }

  @Override
  public List<Event> getAllEventsByTitle(String title) {
    return eventRepository.findAllByTitle(title);
  }
}
