package com.carparking.project.config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

    public class JotFormGetSubmissions {
        public static void main(String[] args) {
            String formId = "250394366931058"; // Your JotForm Form ID
            String apiKey = "08a0d24f66cb11857e6faf1ebe788fdc"; // Your JotForm API Key

            try {
                URL url = new URL("https://api.jotform.com/form/" + formId + "/submissions?apiKey=" + apiKey);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");

                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line);
                }
                br.close();

                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray submissions = jsonResponse.getJSONArray("content");

                System.out.println("Submission IDs:");
                for (int i = 0; i < submissions.length(); i++) {
                    String submissionId = submissions.getJSONObject(i).getString("id");
                    System.out.println(submissionId);
                }

                conn.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }






