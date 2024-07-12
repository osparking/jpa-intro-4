package space.bum.sboot.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@SpringBootTest
class MyProductTest {

  @Autowired
  private Session session;

  @Autowired
  private EntityManager em;

  @Test
  @Transactional
  public void givenSubclasses_whenQuerySingleTableSuperclass_thenOk() {
    Book book = new Book(1, "1984", "조지 오웰");
    session.persist(book);

    Pen pen = new Pen(2, "my pen", "blue");
    session.persist(pen);

    TypedQuery<MyProduct> query = em.createQuery(
        "select p from products p", MyProduct.class);
    var result = query.getResultList();

    assertEquals(2, result.size());
  }

  @Test
  @Transactional
  public void givenSubclasses_whenQueryMappedSuperclass_thenOk() {
      MyEmployee emp = new MyEmployee(1, "제이비", "범이비누");
      session.persist(emp);
      TypedQuery<Person> query = em.createQuery(
          "from space.bum.sboot.entity.Person", Person.class);
      var result = query.getResultList();
      assertEquals(1, result.size());
  }
}
