package com.apitool.apitool;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainController {

    @FXML
    private TextField urlTextField;

    @FXML
    private TextField requestTypeTextField;

    @FXML
    private TextArea headersTextArea;

    @FXML
    private TextArea bodyParamsTextArea;

    @FXML
    private TextArea responseTextArea;




    // Add the event handler for the "Send Request" button
    @FXML
    private void handleSendRequest() {
        String url = urlTextField.getText();
        String requestType = requestTypeTextField.getText();

        if (requestType.equalsIgnoreCase("post")) {
            try {
                URL apiUrl = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
                connection.setRequestMethod("POST");
                connection.setDoOutput(true); // Enable output for POST request

                String requestBody = bodyParamsTextArea.getText(); // Read body parameters
                connection.getOutputStream().write(requestBody.getBytes());

                //get the response
                ResponseInterface responseReader = new ResponseReader();
                responseReader.Reader(connection, responseTextArea, requestType, requestBody);


            } catch (IOException e) {
                e.printStackTrace();
                // Handle any exceptions that occur during the API request // For example, display an error message in the responseTextArea
                responseTextArea.setText("Error occurred during API request: " + e.getMessage());
            }
        }
        else if (requestType.equalsIgnoreCase("put")) {
            try {
                URL apiUrl = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
                connection.setRequestMethod("PUT");
                connection.setDoOutput(true);

                String requestBody = bodyParamsTextArea.getText();
                connection.getOutputStream().write(requestBody.getBytes());

                // get the response
                ResponseInterface responseReader = new ResponseReader();
                responseReader.Reader(connection, responseTextArea, requestType, requestBody);


            } catch (IOException e) {
                e.printStackTrace();
                // Handle any exceptions that occur during the API request // For example, display an error message in the responseTextArea
                responseTextArea.setText("Error occurred during API request: " + e.getMessage());
            }
        }
        if (requestType.equalsIgnoreCase("delete")) {
            try {
                URL apiUrl = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
                connection.setRequestMethod("DELETE");


                // get the response
                ResponseInterface responseReader = new ResponseReader();
                responseReader.Reader(connection, responseTextArea);

            } catch (IOException e) {
                e.printStackTrace();
                // Handle any exceptions that occur during the API request // For example, display an error message in the responseTextArea
                responseTextArea.setText("Error occurred during API request: " + e.getMessage());
            }
        }
        // If the Request Type is "get" (case-insensitive), perform the GET request
         else if (requestType.equalsIgnoreCase("get")) {
            try {
                // Create a URL object from the API URL string
                URL apiUrl = new URL(url);

                // Open a connection to the API URL
                HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

                // Set the request method to GET
                connection.setRequestMethod("GET");



                // Read the response from the API
// get the response
                ResponseInterface responseReader = new ResponseReader();
                responseReader.Reader(connection, responseTextArea);


            } catch (IOException e) {
                e.printStackTrace();
                // Handle any exceptions that occur when opening the connection

                responseTextArea.setText("Error opening connection to API: " + e.getMessage());
            }
        } else {
            // Handle other request types here if needed
            responseTextArea.setText("Unsupported Request Type: " + requestType);
        }
    }
}
