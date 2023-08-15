package com.apitool.apitool;

import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public class ResponseReader implements ResponseInterface {

    @Override
    public void Reader(HttpURLConnection connection, TextArea responseTextArea, String requestMethod, String requestBody) {
        try {
            if (requestMethod.equalsIgnoreCase("post") || requestMethod.equalsIgnoreCase("put")) {
                connection.setDoOutput(true); // Enable output for POST and PUT
                connection.setRequestProperty("Content-Type", "application/json"); // Set content type

                try (OutputStream os = connection.getOutputStream()) {
                    byte[] input = requestBody.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder responseContent = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                    responseContent.append("\n");
                }

                responseTextArea.setText(responseContent.toString());

            } catch (IOException e) {
                e.printStackTrace();
                responseTextArea.setText("Error occurred during API request: " + e.getMessage());
            } finally {
                connection.disconnect();
            }

        } catch (IOException e) {
            e.printStackTrace();
            responseTextArea.setText("Error opening connection to API: " + e.getMessage());
        }
    }

    @Override
    public void Reader(HttpURLConnection connection, TextArea responseTextArea) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder responseContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
                responseContent.append("\n");
            }

            // Display the response in the TextArea
            responseTextArea.setText(responseContent.toString());

        } catch (IOException e) {
            e.printStackTrace();
            // Handle any exceptions that occur during the API request // For example, display an error message in the responseTextArea
            responseTextArea.setText("Error occurred during API request: " + e.getMessage());
        } finally {
            // Disconnect the connection
            connection.disconnect();
        }

    }
}