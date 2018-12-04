package ru.wkn.controller.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.wkn.controller.Controller;
import ru.wkn.model.UnaryCalculatorExpressionChecker;

import java.util.HashMap;
import java.util.Map;

public class UnaryCalculatorController implements Controller {

    @FXML
    private TextField textFieldResult;
    @FXML
    private Button buttonAC;
    @FXML
    private Button buttonEqually;
    @FXML
    private Button buttonValue1;
    @FXML
    private Button buttonValue2;
    @FXML
    private Button buttonValue3;
    @FXML
    private Button buttonValue4;
    @FXML
    private Button buttonValue5;
    @FXML
    private Button buttonValue6;
    @FXML
    private Button buttonValue7;
    @FXML
    private Button buttonValue8;
    @FXML
    private Button buttonValue9;
    @FXML
    private Button buttonValue0;
    @FXML
    private Button buttonDot;
    @FXML
    private Button buttonPlus;
    @FXML
    private Button buttonMinus;
    @FXML
    private Button buttonMultiply;
    @FXML
    private Button buttonDiv;
    @FXML
    private Button buttonSqrt;

    private UnaryCalculatorExpressionChecker unaryCalculatorExpressionChecker;
    private Map<String, Button> stringButtonMap;

    public void initialize() {
        unaryCalculatorExpressionChecker = new UnaryCalculatorExpressionChecker();
        stringButtonMap = new HashMap<>();

        stringButtonMap.put("0", buttonValue0);
        stringButtonMap.put("1", buttonValue1);
        stringButtonMap.put("2", buttonValue2);
        stringButtonMap.put("3", buttonValue3);
        stringButtonMap.put("4", buttonValue4);
        stringButtonMap.put("5", buttonValue5);
        stringButtonMap.put("6", buttonValue6);
        stringButtonMap.put("7", buttonValue7);
        stringButtonMap.put("8", buttonValue8);
        stringButtonMap.put("9", buttonValue9);
        stringButtonMap.put(".", buttonDot);
        stringButtonMap.put("+", buttonPlus);
        stringButtonMap.put("-", buttonMinus);
        stringButtonMap.put("*", buttonMultiply);
        stringButtonMap.put("/", buttonDiv);
        stringButtonMap.put("=", buttonEqually);
    }

    @FXML
    private void onActionTextField(ActionEvent actionEvent) {
        stringButtonMap.get(((Button) actionEvent.getSource()).getText()).fire();
    }

    @FXML
    private void onActionButtonAC() {
    }

    @FXML
    private void onActionButtonEqually() {
    }

    @FXML
    private void onActionButtonValue1() {
    }

    @FXML
    private void onActionButtonValue2() {
    }

    @FXML
    private void onActionButtonValue3() {
    }

    @FXML
    private void onActionButtonValue4() {
    }

    @FXML
    private void onActionButtonValue5() {
    }

    @FXML
    private void onActionButtonValue6() {
    }

    @FXML
    private void onActionButtonValue7() {
    }

    @FXML
    private void onActionButtonValue8() {
    }

    @FXML
    private void onActionButtonValue9() {
    }

    @FXML
    private void onActionButtonValue0() {
    }

    @FXML
    private void onActionButtonDot() {
    }

    @FXML
    private void onActionButtonPlus() {
    }

    @FXML
    private void onActionButtonMinus() {
    }

    @FXML
    private void onActionButtonMultiply() {
    }

    @FXML
    private void onActionButtonDiv() {
    }

    @FXML
    private void onActionButtonSqrt() {
    }
}
