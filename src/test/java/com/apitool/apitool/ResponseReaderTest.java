package com.apitool.apitool;

import javafx.scene.control.TextArea;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ResponseReaderTest {

    @Test
    void testReader() {
        // Mocking HttpURLConnection
        HttpURLConnection connection = mock(HttpURLConnection.class);

        // Mocking InputStream
        String responseContent = "Sample API response content";
        InputStream inputStream = new ByteArrayInputStream(responseContent.getBytes(StandardCharsets.UTF_8));

        // Configure mock behavior
        try {
            when(connection.getInputStream()).thenReturn(inputStream);
        } catch (IOException e) {
            fail("IOException while configuring mock: " + e.getMessage());
        }

        // Creating a ResponseReader instance
        ResponseReader responseReader = new ResponseReader();

        // Test TextArea (assuming you have a TextArea instance)
        TextArea responseTextArea = new TextArea();

        // Call the Reader method
        responseReader.Reader(connection, responseTextArea);

        // Check if the responseTextArea contains the expected response content
        assertEquals(responseContent, responseTextArea.getText());
    }

    @Test
    void testErrorResponse() {
        // Mocking HttpURLConnection to simulate an error response
        HttpURLConnection connection = mock(HttpURLConnection.class);

        // Configure mock behavior for an IOException
        try {
            when(connection.getInputStream()).thenThrow(new IOException("Simulated error"));
        } catch (IOException e) {
            fail("IOException while configuring mock: " + e.getMessage());
        }

        // Creating a ResponseReader instance
        ResponseReader responseReader = new ResponseReader();

        // Test TextArea (assuming you have a TextArea instance)
        TextArea responseTextArea = new TextArea();

        // Call the Reader method
        responseReader.Reader(connection, responseTextArea);

        // Check if the responseTextArea contains the error message
        assertTrue(responseTextArea.getText().contains("Error occurred during API request"));
    }
}
