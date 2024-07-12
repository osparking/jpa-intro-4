package space.bum.sboot.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity

@DiscriminatorValue("2")
public class Pen extends MyProduct {
  private String color;
}
