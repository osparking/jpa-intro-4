package space.bum.sboot.entity;

import jakarta.persistence.ColumnResult;
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
    @ColumnResult(name = "employeeId") })
@NamedNativeQuery(name = "FridayEmployees", 
  query = "SELECT employeeId FROM schedule_days WHERE dayOfWeek = 'FRIDAY'", 
  resultSetMapping = "FridayEmployeeResult")
@NoArgsConstructor
@Data
public class ScheduledDay {

  @Id
  @GeneratedValue
  private Long id;
  private Long employeeId;
  private String dayOfWeek;
}