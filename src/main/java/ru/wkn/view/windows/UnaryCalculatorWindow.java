package ru.wkn.view.windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ru.wkn.view.Window;

import java.io.IOException;

public class UnaryCalculatorWindow implements Window {

    @Override
    public void windowInit(String windowName, double height, double width) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/fxml/unary-calculator-window.fxml"));
        Stage stage = new Stage();
        stage.setTitle(windowName);
        stage.setScene(new Scene(anchorPane, width, height));
        stage.setResizable(false);
        stage.show();
    }
}
