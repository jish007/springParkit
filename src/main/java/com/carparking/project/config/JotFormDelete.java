package com.carparking.project.config;

    import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream;

    public class JotFormDelete {
        public static void main(String[] args) {
            String submissionId = "6185453127224289732";  // Replace with the actual submission ID
            String apiKey = "08a0d24f66cb11857e6faf1ebe788fdc";  // Replace with your JotForm API Key

            try {
                URL url = new URL("https://api.jotform.com/submission/" + submissionId + "?apiKey=" + apiKey);
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
        }
    }


