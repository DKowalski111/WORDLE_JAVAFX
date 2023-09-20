module com.example.wordlefx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.wordlefx to javafx.fxml;
    exports com.example.wordlefx;
}