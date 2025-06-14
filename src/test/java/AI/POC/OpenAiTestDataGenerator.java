package AI.POC;

import com.fasterxml.jackson.databind.*;
import okhttp3.*;


import java.io.IOException;

public class OpenAiTestDataGenerator {

        private static final String OPENAI_API_KEY = "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";

        public static String generateTestData(String prompt) throws IOException {
            OkHttpClient client = new OkHttpClient();
            ObjectMapper mapper = new ObjectMapper();

            String body = """
        {
          "model": "gpt-4o-mini",
          "messages": [{"role": "user", "content": "%s"}]
        }
        """.formatted(prompt);

            Request request = new Request.Builder()
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
