package utils;

import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class JSONLogger {

    public static void logTestResult(String testName, boolean status, long durationInMs) {
        JSONObject log = new JSONObject();
        log.put("testName", testName);
        log.put("status", status ? "PASSED" : "FAILED");
        log.put("timestamp", LocalDateTime.now().toString());
        log.put("durationInMs", durationInMs);
        log.put("module", "UI");

        try (FileWriter file = new FileWriter("logs/test-metrics.json", true)) {
            file.write(log.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
