package space.bum.sboot.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity(name = "r_user_group")
public class UserGroupRelation implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "user_id", insertable = false, updatable = false)
  private Long userId;

  @Id
  @Column(name = "group_id", insertable = false, updatable = false)
  private Long groupId;
  
  @Enumerated(EnumType.STRING)
  private UserGroupRole role;
}