package space.bum.sboot.entity;

import org.hibernate.annotations.DiscriminatorFormula;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="products")
@DiscriminatorFormula("case when author is not null then 1 else 2 end")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor
@Data
public class MyProduct {
  @Id
  private long productId;
  private String name;
}
