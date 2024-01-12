module com.example.javagroupproject1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;
    requires org.xerial.sqlitejdbc;
    requires ormlite.jdbc;
    requires org.controlsfx.controls;


    opens com.example.javagroupproject1 to javafx.fxml;
    opens com.example.javagroupproject1.parsing to javafx.fxml;
    opens com.example.javagroupproject1.controller to javafx.fxml;
    opens com.example.javagroupproject1.tools to ormlite.jdbc;

    exports com.example.javagroupproject1;
    exports com.example.javagroupproject1.parsing;
    exports com.example.javagroupproject1.data to ormlite.jdbc;
    exports com.example.javagroupproject1.repository to ormlite.jdbc;

}