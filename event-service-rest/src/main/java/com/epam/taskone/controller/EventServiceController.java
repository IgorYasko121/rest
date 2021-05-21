package com.epam.taskone.controller;

import com.epam.taskone.EventService;
import com.epam.taskone.domain.Event;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/events")
@RestController
public class EventServiceController {

  private final EventService eventService;

  @GetMapping
  @ApiOperation("Lookup All Events")
  public List<Event> getAllEvents(){
    return eventService.getAllEvents();
  }

  @GetMapping("/{eventId}")
  @ApiOperation("Lookup Event by id")
  public Event getEventById(@PathVariable Long eventId){
    return eventService.getEvent(eventId);
  }

  @GetMapping("/search/findByTitle")
  @ApiOperation("Lookup All Events by tittle")
  public List<Event> getAllEventsByTitle(@RequestParam String title){
    return eventService.getAllEventsByTitle(title);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @ApiOperation("Create Event")
  public void createEvent(Event event){
    eventService.createEvent(event);
  }

  @PutMapping("/{eventId}")
  @ApiOperation("Update Event")
  public void updateEvent(@RequestBody Event newEvent, @PathVariable Long eventId){
    eventService.updateEvent(eventId, newEvent);
  }

  @DeleteMapping("/{eventId}")
  @ApiOperation("Delete Event")
  public void deleteEventById(@PathVariable Long eventId){
    eventService.deleteEvent(eventId);
  }

}
