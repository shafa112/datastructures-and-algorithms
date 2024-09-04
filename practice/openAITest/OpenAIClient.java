package openAITest;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class OpenAIClient {
    private static final String API_KEY = "";


    public static void main(String[] args) throws IOException {
        if (API_KEY == null) {
            throw new IllegalArgumentException("API key not set in environment variables");
        }

        OkHttpClient client = new OkHttpClient();

        // Construct the JSON body for the request
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("model", "gpt-3.5-turbo");

        // Create an array of messages
        JSONArray messages = new JSONArray();
        JSONObject message = new JSONObject();
        message.put("role", "user");
        message.put("content", "what is you model version");
        messages.put(message);

        jsonBody.put("messages", messages);
        jsonBody.put("max_tokens", 100);

        RequestBody body = RequestBody.create(
                jsonBody.toString(),
                MediaType.parse("application/json; charset=utf-8")
        );

        Request request = new Request.Builder()
                .url("abc")
                .header("Authorization", "Bearer " + API_KEY)
                .post(body)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }

        System.out.println(response.body().string());
    }

}
