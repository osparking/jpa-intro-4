package space.bum.sboot.entity;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SCHEDULE_DAYS")
@SqlResultSetMapping(name = "FridayEmployeeResult", columns = {
    @ColumnResult(name = "employee_Id") })

@NamedNativeQuery(name = "FridayEmployees", 
  query = "SELECT employee_Id FROM schedule_days WHERE day_Of_Week = 'FRIDAY'", 
  resultSetMapping = "FridayEmployeeResult")
@SqlResultSetMapping(name = "ScheduleResult", classes = {
    @ConstructorResult(targetClass = space.bum.sboot.entity.ScheduledDay.class, 
        columns = {
          @ColumnResult(name = "id", type = Long.class),
          @ColumnResult(name = "employee_Id", type = Long.class),
          @ColumnResult(name = "day_Of_Week") }) })
@NamedNativeQuery(name = "Schedules",
  query = "SELECT * FROM schedule_days WHERE employee_Id = 100",
  resultSetMapping = "ScheduleResult")
@SqlResultSetMapping(name = "EmployeeResult", entities = {
    @EntityResult(entityClass = space.bum.sboot.entity.Employee.class, 
        fields = {
            @FieldResult(name = "id", column = "employeeNumber"),
            @FieldResult(name = "name", column = "name") }) })
@NoArgsConstructor
@Data
public class ScheduledDay {

  @Id
  @GeneratedValue
  private Long id;
  private Long employeeId;
  private String dayOfWeek;
  
  public ScheduledDay(Long id, Long employeeId, String dayofWeek) {
    this.id = id;
    this.employeeId = employeeId;
    this.dayOfWeek = dayofWeek;
  }  
}