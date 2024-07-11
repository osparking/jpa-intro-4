package space.bum.sboot.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity(name = "users")
public class User {

  @Id
  @GeneratedValue
  private Long id;
  private String name;

  @ManyToMany
  private List<Group> groups = new ArrayList<>();
}
