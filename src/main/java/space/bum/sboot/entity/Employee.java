package space.bum.sboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
  @Id
  private Long id;
  private String name;
}
