package space.bum.sboot.entity;

import jakarta.persistence.Entity;

@Entity
public class Book extends MyProduct {
  private String author;
}
