module com.apitool.apitool {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.apitool.apitool to javafx.fxml;
    exports com.apitool.apitool;
}