package com.apitool.apitool;

import javafx.scene.control.TextArea;

import java.net.HttpURLConnection;

public interface ResponseInterface {

    // implementing two same method with different parameter

    public void Reader(HttpURLConnection connection, TextArea responseTextArea, String requestMethod, String requestBody);

    public void Reader(HttpURLConnection connection, TextArea responseTextArea);
}
