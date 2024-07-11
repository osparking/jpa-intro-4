package space.bum.sboot.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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

  //@formatter:off
  @ManyToMany
  @JoinTable(name = "r_user_group", 
    joinColumns = @JoinColumn(name = "user_id"), 
    inverseJoinColumns = @JoinColumn(name = "group_id"))
  private List<Group> groups = new ArrayList<>();

  public User(String name) {
    super();
    this.name = name;
  }
}
