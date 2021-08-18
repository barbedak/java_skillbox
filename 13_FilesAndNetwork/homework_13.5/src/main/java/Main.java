import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;


public class Main {
    private static StationIndex stationIndexFromWeb = new StationIndex();
    private static StationIndex stationIndexFromFile = new StationIndex();

    public static void main(String[] args) {
        String fileName = ".\\file\\map_moscow.json";
        try {
            Document doc = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").maxBodySize(0).get();
            parseLines(doc);
            parseConnections(doc);
            JSONObject jsonObject = createJson();
            writeJsonObjToFile(jsonObject, fileName);
            readJSON(fileName);
            for (Line line : stationIndexFromFile.getLines()) {
                System.out.println(line.getName() + " число станций : " + line.getStations().size());
            }
            System.out.println("Количество переходов в метро - " + stationIndexFromWeb.getConnections().size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void parseConnections(Document doc) {
        Elements parseConnections = doc.select("[title^=\"переход\"]");
        parseConnections.forEach(parseConn -> {
            String stationName = parseConn.attr("title");
            stationName = stationName.replaceAll("^.+«", "").replaceAll("».+$", "");
            String lineNumber = parseConn.attr("class").replaceAll("^.+ln-", "");
            stationIndexFromWeb.addConnection(new Connection(stationName, lineNumber));
        });
    }

    private static void parseLines(Document doc) {
        Elements parseLines = doc.select("span.js-metro-line");
        parseLines.forEach(parseLine -> {
            Line line = new Line(parseLine.text(), parseLine.attr("data-line"));
            Elements parseStations = doc.select("[data-line=" + line.getNumber() + "]  span.name");
            parseStations.forEach(station -> line.addStation(new Station(station.text(), line.getNumber())));
            stationIndexFromWeb.addLine(line);
        });
    }

    private static void readJSON(String fileName) {
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader fileReader = new FileReader(fileName);
            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
            JSONArray linesArr = (JSONArray) jsonObject.get("lines");
            linesArr.forEach(lineObj -> {
                JSONObject lineJSONObj = (JSONObject) lineObj;
                stationIndexFromFile.addLine(new Line((String) lineJSONObj.get("name"), (String) lineJSONObj.get("number")));
            });
            JSONObject stationsObj = (JSONObject) jsonObject.get("stations");
            stationsObj.keySet().forEach(lineNumber -> {
                Line line = stationIndexFromFile.getLine((String) lineNumber);
                if (!line.getNumber().equals("-1")) {
                    JSONArray stationsArr = (JSONArray) stationsObj.get(lineNumber);
                    stationsArr.forEach(station -> line.addStation(new Station((String) station, line.getNumber())));
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
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

    private static void writeJsonObjToFile(JSONObject jsonObject, String fileName) {
        createFile(fileName);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter file = new FileWriter(fileName);
            file.write(gson.toJson(jsonObject));
            file.flush();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static JSONObject createJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stations", stationIndexFromWeb.getStationsOnLines());
        JSONArray jsonArray = new JSONArray();
        for (Line line : stationIndexFromWeb.getLines()) {
            Map<String, String> lineNumberName = new TreeMap<>();
            lineNumberName.put("number", line.getNumber());
            lineNumberName.put("name", line.getName());
            jsonArray.add(lineNumberName);
        }
        jsonObject.put("lines", jsonArray);
        JSONArray jsonConnList = new JSONArray();
        stationIndexFromWeb.getConnections().forEach(conn -> {
            JSONObject jsonConn = new JSONObject();
            jsonConn.put(conn.getStationName(), conn.getLineNumber());
            jsonConnList.add(jsonConn);
        });
        jsonObject.put("connections", jsonConnList);
        return jsonObject;
    }
}
