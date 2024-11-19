module org.example.employeemanagementsql {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.sql;

    opens org.example.employeemanagementsql to javafx.fxml;
    exports org.example.employeemanagementsql;
}