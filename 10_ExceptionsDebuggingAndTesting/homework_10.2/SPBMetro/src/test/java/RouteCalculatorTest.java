import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    StationIndex stationIndex = new StationIndex();
    RouteCalculator routeCalculator = new RouteCalculator(stationIndex);

    @Override
    protected void setUp() throws Exception {
        Line lineFirst = new Line(1, "Первая");
        Line lineSecond = new Line(2, "Вторая");
        Line lineThird = new Line(3, "Третья");

        Station station1 = new Station("station1", lineFirst);
        Station station2 = new Station("station2", lineFirst);
        Station station3 = new Station("station3", lineFirst);
        Station station4 = new Station("station4", lineFirst);
        Station station5 = new Station("station5", lineSecond);
        Station station6 = new Station("station6", lineSecond);
        Station station7 = new Station("station7", lineSecond);
        Station station8 = new Station("station8", lineSecond);
        Station station9 = new Station("station9", lineSecond);
        Station station10 = new Station("station10", lineThird);
        Station station11 = new Station("station11", lineThird);
        Station station12 = new Station("station12", lineThird);
        Station station13 = new Station("station13", lineThird);

        lineFirst.addStation(station1);
        lineFirst.addStation(station2);
        lineFirst.addStation(station3);
        lineFirst.addStation(station4);
        lineSecond.addStation(station5);
        lineSecond.addStation(station6);
        lineSecond.addStation(station7);
        lineSecond.addStation(station8);
        lineSecond.addStation(station9);
        lineThird.addStation(station10);
        lineThird.addStation(station11);
        lineThird.addStation(station12);
        lineThird.addStation(station13);

        stationIndex.addLine(lineFirst);
        stationIndex.addLine(lineSecond);
        stationIndex.addLine(lineThird);

        stationIndex.addStation(station1);
        stationIndex.addStation(station2);
        stationIndex.addStation(station3);
        stationIndex.addStation(station4);
        stationIndex.addStation(station5);
        stationIndex.addStation(station6);
        stationIndex.addStation(station7);
        stationIndex.addStation(station8);
        stationIndex.addStation(station9);
        stationIndex.addStation(station10);
        stationIndex.addStation(station11);
        stationIndex.addStation(station12);
        stationIndex.addStation(station13);

        ArrayList<Station> transitionBetweenStations = new ArrayList<>();
        transitionBetweenStations.add(station2);
        transitionBetweenStations.add(station6);
        stationIndex.addConnection(transitionBetweenStations);
        transitionBetweenStations.clear();
        transitionBetweenStations.add(station8);
        transitionBetweenStations.add(station11);
        stationIndex.addConnection(transitionBetweenStations);

    }
    public void testGetShortestRoute(){
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("station1"),
                stationIndex.getStation("station7"));
        List<Station> expected = new ArrayList<>(
                Arrays.asList(stationIndex.getStation("station1"), stationIndex.getStation("station2"),
                        stationIndex.getStation("station6"), stationIndex.getStation("station7"))
        );

        assertEquals(expected, actual);

    }

    public void testGetRouteOnTheLine(){
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("station1"),
                                                                stationIndex.getStation("station4"));
        List<Station> expected = new ArrayList<>(
                Arrays.asList(stationIndex.getStation("station1"), stationIndex.getStation("station2"),
                        stationIndex.getStation("station3"), stationIndex.getStation("station4"))
                );

        assertEquals(expected, actual);
    }

    public void testGetRouteWithOneConnection(){
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("station1"),
                stationIndex.getStation("station7"));
        List<Station> expected = new ArrayList<>(
                Arrays.asList(stationIndex.getStation("station1"), stationIndex.getStation("station2"),
                        stationIndex.getStation("station6"), stationIndex.getStation("station7"))
        );

        assertEquals(expected, actual);

    }

    public void testGetRouteWithTwoConnections(){
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("station1"),
                stationIndex.getStation("station10"));
        List<Station> expected = new ArrayList<>(
                Arrays.asList(stationIndex.getStation("station1"), stationIndex.getStation("station2"),
                        stationIndex.getStation("station6"), stationIndex.getStation("station7"),
                        stationIndex.getStation("station8"),stationIndex.getStation("station11"),
                        stationIndex.getStation("station10"))
        );

        assertEquals(expected, actual);

    }


    public void testGetRouteViaConnectedLine(){
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("station1"),
                stationIndex.getStation("station7"));
        List<Station> expected = new ArrayList<>(
                Arrays.asList(stationIndex.getStation("station1"), stationIndex.getStation("station2"),
                        stationIndex.getStation("station6"), stationIndex.getStation("station7"))
        );

        assertEquals(expected, actual);

    }

    public void testCalculateDuration(){
        double actual = RouteCalculator.calculateDuration(
                Arrays.asList(stationIndex.getStation("station6"), stationIndex.getStation("station7"),
                    stationIndex.getStation("station2"), stationIndex.getStation("station3"),
                        stationIndex.getStation("station4"), stationIndex.getStation("station12"),
                        stationIndex.getStation("station13")));
        double expected = 14.5;
        assertEquals(expected, actual);
    }
}
