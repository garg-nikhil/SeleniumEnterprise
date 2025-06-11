package utils;

import java.time.Instant;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApi;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import java.util.concurrent.TimeUnit;

public class InfluxDBLogger {

    private static InfluxDBClient client;
    private static final String token = "o2AmNH6TXe2qGISfPhHFeCp6JPA1tZGCrqSlBSyWV2ipD8AE-EEenEaFqSptsEbN9xvGABG7dhn98ltj1HbtJw==";
    private static final String bucket = "automationBucket";
    private static final String org = "automationOrg";

    static {
        try {
            client = InfluxDBClientFactory.create("http://localhost:8086", token.toCharArray(), org, bucket);
        } catch (Exception e) {
            System.err.println("❌ InfluxDB client init failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void logTestResult(String testName, String status, String browser, long durationMs) {
        if (client == null) {
            System.err.println("⚠️ InfluxDB client not initialized, skipping logging.");
            return;
        }

        try (WriteApi writeApi = client.getWriteApi()) {
            Point point = Point
                    .measurement("test_execution_v4")
                    .addTag("testName", testName)                   // Test Case
                    .addTag("browser", "Chrome")                    // Browser
                    .addTag("device", "Android Emulator")           // Device (update dynamically if needed)
                    .addTag("hostOS", System.getProperty("os.name"))// Host OS
                    .addTag("status", status)                       // Status
                    .addField("duration", durationMs)                 // Duration (MUST be numeric!)
                    .time(Instant.now(), WritePrecision.MS);

            writeApi.writePoint(point);
        } catch (Exception e) {
            System.err.println("❌ Failed to log to InfluxDB: " + e.getMessage());
        }
    }


}
