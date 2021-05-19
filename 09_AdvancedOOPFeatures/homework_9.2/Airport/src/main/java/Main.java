import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        Calendar timeFlight = new GregorianCalendar();
        Calendar time = new GregorianCalendar();

        List <Flight> allFlights = airport.getTerminals().stream()
                .flatMap(t -> t.getFlights().stream())
                .collect(Collectors.toList());

        time.add(Calendar.HOUR,2);
        List <Flight> flightsDepartureNextTwoHours = allFlights.stream()
                .filter(f -> f.getType().equals(Flight.Type.DEPARTURE))
                .filter(f -> {
                            timeFlight.setTime(f.getDate());
                            return timeFlight.before(time);
                            })
                .collect(Collectors.toList());

        return flightsDepartureNextTwoHours;
    }

}