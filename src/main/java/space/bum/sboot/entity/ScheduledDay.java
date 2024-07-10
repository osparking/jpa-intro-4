package space.bum.sboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SCHEDULE_DAYS")
public class ScheduledDay {

    @Id
    @GeneratedValue
    private Long id;
    private Long employeeId;
    private String dayOfWeek;
}