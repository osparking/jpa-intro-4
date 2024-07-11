package space.bum.sboot.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
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

    Group group1 = new Group("group1");
    Group group2 = new Group("group2");

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

  private void saveRelation(User user, Group group, UserGroupRole role) {
    UserGroupRelation relation = new UserGroupRelation(user.getId(),
        group.getId(), role);

    session.persist(relation);
    session.flush();
    session.refresh(user);
    session.refresh(group);
  }
}
