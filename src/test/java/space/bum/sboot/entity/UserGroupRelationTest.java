package space.bum.sboot.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.persistence.EntityManagerFactory;

@SpringBootTest
class UserGroupRelationTest {

  @Autowired
  private EntityManagerFactory emf;
  private SessionFactory sf;
  private Session session;
  
  @BeforeEach
  void setUp() throws Exception {
    sf = emf.unwrap(SessionFactory.class);
    session = sf.openSession();
    session.beginTransaction();

    User user1 = new User("user1");
    User user2 = new User("user2");
    User user3 = new User("user3");

    MyGroup group1 = new MyGroup("group1");
    MyGroup group2 = new MyGroup("group2");

    session.persist(group1);
    session.persist(group2);

    session.persist(user1);
    session.persist(user2);
    session.persist(user3);

    saveRelation(user1, group1, UserGroupRole.MODERATOR);
    saveRelation(user2, group1, UserGroupRole.MODERATOR);
    saveRelation(user3, group1, UserGroupRole.MEMBER);

    saveRelation(user1, group2, UserGroupRole.MEMBER);
    saveRelation(user2, group2, UserGroupRole.MODERATOR);
  }

  private void saveRelation(User user, MyGroup group, UserGroupRole role) {
    UserGroupRelation relation = new UserGroupRelation(user.getId(),
        group.getId(), role);

    session.persist(relation);
    session.flush();
    session.refresh(user);
    session.refresh(group);
  }
  
  @Test
  public void whenFetchGroupsInWhichUser1Is_thenResultLengthIs2_thenOk() {
    User user1 = session.find(User.class, 1L);
    List<MyGroup> groups = user1.getGroups();
    assertEquals(2, groups.size());
  }
}
