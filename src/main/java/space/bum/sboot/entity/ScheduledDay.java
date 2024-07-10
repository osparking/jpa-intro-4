package space.bum.sboot.entity;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
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
@NoArgsConstructor
@Data
public class ScheduledDay {

  @Id
  @GeneratedValue
  private Long id;
  private Long employeeId;
  private String dayOfWeek;
  
  public ScheduledDay(Long id, Long employeeId,
      Integer hourIn, Integer hourOut, String dayofWeek) {
    this.id = id;
    this.employeeId = employeeId;
    this.dayOfWeek = dayofWeek;
  }  
}