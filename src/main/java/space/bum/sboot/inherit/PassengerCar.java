package space.bum.sboot.inherit;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PassengerCar extends Vehicle {
  private int passengerNumber;
}
