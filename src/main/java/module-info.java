module com.mycompany.quizapplication {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.quizapplication to javafx.fxml;
    exports com.mycompany.quizapplication;
}
