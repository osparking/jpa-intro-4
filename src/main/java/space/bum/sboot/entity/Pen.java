package space.bum.sboot.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("2")
@Data
@NoArgsConstructor
public class Pen extends MyProduct {
  private String color;
  
  public Pen(int productId, String name, String color) {
    super(productId, name);
    this.color = color;
  }
}
