package test.siemenstestapp.siemens;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private int roomNumber;
    private int type;
    private double price;
    private boolean isAvailable;
}
