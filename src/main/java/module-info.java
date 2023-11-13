module com.example.javagroupproject1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;


    opens com.example.javagroupproject1 to javafx.fxml;
    exports com.example.javagroupproject1;
}