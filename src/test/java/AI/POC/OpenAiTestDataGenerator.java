package AI.POC;

import com.fasterxml.jackson.databind.*;
import java.io.IOException;
import okhttp3.*;

public class OpenAiTestDataGenerator {

  private static final String OPENAI_API_KEY = "";

  public static String generateTestData(String prompt) throws IOException {
    OkHttpClient client = new OkHttpClient();
    ObjectMapper mapper = new ObjectMapper();

    String body =
        """
        {
          "model": "gpt-4o-mini",
          "messages": [{"role": "user", "content": "%s"}]
        }
        """
            .formatted(prompt);

    Request request =
        new Request.Builder()
            .url("https://api.openai.com/v1/chat/completions")
            .addHeader("Authorization", "Bearer " + OPENAI_API_KEY)
            .post(RequestBody.create(body, MediaType.parse("application/json")))
            .build();

    Response response = client.newCall(request).execute();
    JsonNode json = mapper.readTree(response.body().string());
    return json.get("choices").get(0).get("message").get("content").asText();
  }

  public static void main(String[] args) throws IOException {
    String prompt = "Generate dummy JSON test data for a banking app loan request";
    System.out.println(generateTestData(prompt));
  }
}
