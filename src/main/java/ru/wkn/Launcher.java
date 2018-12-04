package ru.wkn;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.wkn.view.Window;
import ru.wkn.view.windows.UnaryCalculatorWindow;

import java.io.IOException;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Window window = new UnaryCalculatorWindow();
        try {
            window.windowInit("Unary calculator", 430, 545);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
