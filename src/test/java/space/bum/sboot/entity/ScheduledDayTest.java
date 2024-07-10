package space.bum.sboot.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

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

  @Test
  public void whenNamedQuery_thenSingleEntityResult() {
    @SuppressWarnings("unchecked")
    List<Employee> employees = Collections.checkedList(
        em.createNamedQuery("Employees").getResultList(), Employee.class);
    assertEquals(1, employees.size());
    assertTrue(
        employees.stream().allMatch(c -> c.getClass() == Employee.class));
  }
  
  @Test
  public void whenNamedQuery_thenMultipleEntityResult() {
    StringBuffer sqlSB = new StringBuffer("SELECT e.id as idEmployee, ");
    sqlSB.append(" e.name, d.id as daysId, d.employee_Id, d.day_Of_Week");
    sqlSB.append(" FROM employee e, schedule_days d");
    sqlSB.append(" WHERE e.id = d.employee_Id");
    Query query = em.createNativeQuery(sqlSB.toString(),
        "EmployeeScheduleResults");

    @SuppressWarnings("unchecked")
    List<Object[]> results = query.getResultList();
    assertEquals(1, results.size());
    assertTrue(results.get(0).length == 2);

    Employee emp = (Employee) results.get(0)[0];
    ScheduledDay day = (ScheduledDay) results.get(0)[1];

    assertTrue(day.getEmployeeId() == emp.getId());
  }  
}
