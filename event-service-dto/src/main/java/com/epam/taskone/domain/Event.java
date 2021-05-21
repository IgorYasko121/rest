package com.epam.taskone.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Event {

  @Id
  @GeneratedValue()
  private Long id;
  private String title;
  private String place;
  private String speaker;
  private EventType eventType;
  private LocalDateTime dateTime;

  public enum EventType {
    ONLINE, OFFLINE
  }

}
