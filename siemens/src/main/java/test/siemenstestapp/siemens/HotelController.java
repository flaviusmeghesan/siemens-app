package test.siemenstestapp.siemens;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/hotels")
public class HotelController {
    @Autowired
    public HotelService hotelService;
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        return new ResponseEntity<List<Hotel>>(hotelService.allMovies(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Hotel>> getSingleHotel(@PathVariable("id") int id){
        return new ResponseEntity<Optional<Hotel>>(hotelService.singleHotel(id), HttpStatus.OK);
    }

    @GetMapping("/range")
    public ResponseEntity<Optional<List<Hotel>>> getHotelsByRange(
            @RequestParam double range,
            @RequestParam double userLat,
            @RequestParam double userLon) {
        return new ResponseEntity<>(hotelService.hotelsByRange(range, userLat, userLon), HttpStatus.OK);
    }
}
