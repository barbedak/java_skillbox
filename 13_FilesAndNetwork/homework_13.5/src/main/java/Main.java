import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").maxBodySize(0).get();
            List<Line> lines = parseLines(doc);
            JSONObject jsonObject = createJson(lines);
            System.out.println(jsonObject);
            writeJsonObjToFile(jsonObject);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void createFile(String path) {
        File files = new File(path);
        if (!files.exists()) {
            try {
                files.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void writeJsonObjToFile(JSONObject jsonObject) {
        String fileName = ".\\file\\map_moscow.json";
        createFile(fileName);
        try {
            FileWriter file = new FileWriter(fileName);
            file.write(jsonObject.toJSONString());
            file.flush();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static JSONObject createJson(List<Line> lines) {
        Map<String, List<String>> stations2Lines = getStationsOnLines(lines);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stations", stations2Lines);
        JSONArray jsonArray = new JSONArray();
        for (Line line : lines) {
            Map<String, String> lineNumberName = new TreeMap<>();
            lineNumberName.put("number", line.getNumber());
            lineNumberName.put("name", line.getName());
            jsonArray.add(lineNumberName);
        }
        jsonObject.put("lines", jsonArray);
        return jsonObject;
    }

    private static Map<String, List<String>> getStationsOnLines(List<Line> lines) {
        Map<String, List<String>> stationsOnLines = new TreeMap<>();
        for (Line line : lines) {
            stationsOnLines.put(line.getNumber(), line.getStations().stream()
                    .map(Station::getName)
                    .collect(Collectors.toList()));
        }
        return stationsOnLines;
    }

    private static List<Line> parseLines(Document doc) {
        List<Line> lines = new ArrayList<>();
        Elements parseLines = doc.select("span.js-metro-line");
        parseLines.forEach(parseLine -> {
            Line line = new Line(parseLine.text(), parseLine.attr("data-line"));
            lines.add(line);
            Elements parseStations = doc.select("[data-line=" + line.getNumber() + "]  span.name");
            parseStations.forEach(station -> line.addStation(new Station(station.text(), line)));
        });
        return lines;
    }
}
