import com.skillbox.airport.*;

public class Main {
    public static void main(String[] args) {

        Airport port = Airport.getInstance();

        System.out.println("List of Aircrafts : " + port.getAllAircrafts());
        System.out.println("Number aircrafts - " + port.getAllAircrafts().size());

    }
}
