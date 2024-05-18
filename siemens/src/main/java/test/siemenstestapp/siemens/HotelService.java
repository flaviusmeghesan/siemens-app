package test.siemenstestapp.siemens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> allMovies(){
        return hotelRepository.findAll();
    }
    public Optional<Hotel> singleHotel(int id){
        return hotelRepository.findHotelById(id);
    }

    public double getLatitudeMeters(double latitude){
        double phi = Math.toRadians(latitude);
        return 111132.92 - 559.82 * Math.cos(2 * phi) + 1.175 * Math.cos(4 * phi) - 0.0023 * Math.cos(6 * phi);
    }

    public double getLongitudeMeters(double longitude){
        double phi = Math.toRadians(longitude);
        return 111412.84 * Math.cos(phi) - 93.5 * Math.cos(3 * phi) + 0.118 * Math.cos(5 * phi);
    }

    public double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1)) / 1000;
    }

    public Optional<List<Hotel>> hotelsByRange(double range, double userLat, double userLon) {
        double userLatM = getLatitudeMeters(userLat);
        double userLonM = getLongitudeMeters(userLon);

        List<Hotel> allHotels = hotelRepository.findAll();
        List<Hotel> hotelsInRange = allHotels.stream()
                .filter(hotel -> getDistance(userLatM, userLonM, getLatitudeMeters(hotel.getLatitude()), getLongitudeMeters(hotel.getLongitude())) <= range)
                .collect(Collectors.toList());

        return Optional.of(hotelsInRange);
    }

}
