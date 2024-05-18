package test.siemenstestapp.siemens;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "hotels")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    private ObjectId _id;
    private String id;
    private String name;
    private double latitude;
    private double longitude;
    private List<Room> rooms;
    @DocumentReference
    private List<Review> reviewIds;
}
