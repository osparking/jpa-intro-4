package space.bum.sboot.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("1")
@Data
@NoArgsConstructor
public class Book extends MyProduct {
  private String author;

  public Book(int productId, String name, String author) {
    super(productId, name);
    this.author = author;
  }
}
