package space.bum.sboot.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.persistence.EntityManager;

@SpringBootTest
class ScheduledDayTest {
  @Autowired
  private EntityManager em;

  @Test
  public void whenNamedQuery_thenColumnResult() {
    @SuppressWarnings("unchecked")
    List<Long> employeeIds = (List<Long>) em.createNamedQuery("FridayEmployees")
        .getResultList();
    assertEquals(1, employeeIds.size());
  }
  
  @Test
  public void whenNamedQuery_thenConstructorResult() {
    List<ScheduledDay> scheduleDays = Collections.checkedList(
        em.createNamedQuery("Schedules", ScheduledDay.class).getResultList(),
        ScheduledDay.class);
    assertEquals(1, scheduleDays.size());
    assertTrue(scheduleDays.stream()
        .allMatch(c -> c.getEmployeeId().longValue() == 100L));
  }

}
