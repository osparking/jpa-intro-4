package space.bum.sboot.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class MyEmployee extends Person {
  public MyEmployee(int personId, String name, String company) {
    super(personId, name);
    this.company = company;
  }

  private String company;
}