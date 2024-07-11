package space.bum.sboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = Article.TABLE_NAME)
@NoArgsConstructor
@Data
public class Article {
  private static final String TABLE_NAME = "ARTICLES";
  @Id
  private Long articleId;
}
