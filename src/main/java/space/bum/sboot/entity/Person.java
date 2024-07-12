package space.bum.sboot.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class Person {
  @Id
  private long personId;
  private String name;

}
