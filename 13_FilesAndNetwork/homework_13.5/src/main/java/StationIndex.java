import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StationIndex {
    private List<Line> lines;
    private List<Connection> connections;

    public StationIndex() {
        this.lines = new ArrayList<>();
        this.connections = new ArrayList<>();
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public void addConnection(Connection connection) {
        connections.add(connection);
    }

    public List<Connection> getConnections() {
        return connections;
    }

    public List<Line> getLines() {
        return lines;
    }

    public Line getLine(String number) {
        Line result = new Line("not line", "-1");
        for (Line line : lines) {
            if (line.getNumber().equals(number)) {
                return line;
            }
        }
        return result;
    }

    public Map<String, List<String>> getStationsOnLines() {
        Map<String, List<String>> stationsOnLines = new TreeMap<>();
        for (Line line : lines) {
            stationsOnLines.put(line.getNumber(), line.getStations().stream()
                    .map(Station::getName)
                    .collect(Collectors.toList()));
        }
        return stationsOnLines;
    }
}
