package com.carparking.project.helper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class JotFormSubmissions {
    private static final String API_KEY = "08a0d24f66cb11857e6faf1ebe788fdc";
   // private static final String FORM_ID = "250571659232054";



    public  String getFormResponse(String formId) {
        String url = "https://api.jotform.com/form/" + formId + "/submissions?apiKey=" + API_KEY;

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        return  response;
    }



    public String deleteForm(String submissionId){


        try {
            URL url = new URL("https://api.jotform.com/submission/" + submissionId + "?apiKey=" + API_KEY);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");
            conn.setRequestProperty("Accept", "application/json");

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                System.out.println("Submission deleted successfully!");
            } else {
                System.out.println("Failed to delete. Response Code: " + responseCode);
            }

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  "Submission deleted successfully!";
    }

    public  JSONArray getSubmissionId(String formId){

        JSONArray submissions =null;
        try {
            URL url = new URL("https://api.jotform.com/form/" + formId + "/submissions?apiKey=" + API_KEY);
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
             submissions = jsonResponse.getJSONArray("content");

            System.out.println("Submission IDs:");
            for (int i = 0; i < submissions.length(); i++) {
                String submissionId = submissions.getJSONObject(i).getString("id");
                System.out.println(submissionId);
            }

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return submissions;
    }
}