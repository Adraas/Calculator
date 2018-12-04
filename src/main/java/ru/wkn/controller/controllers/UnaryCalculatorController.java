package ru.wkn.controller.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.wkn.controller.Controller;

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

    @FXML
    private void onActionTextField(ActionEvent actionEvent) {
        switch (((Button) actionEvent.getSource()).getText()) {
            case "0":
                buttonValue0.fire();
                break;
            case "1":
                buttonValue1.fire();
                break;
            case "2":
                buttonValue2.fire();
                break;
            case "3":
                buttonValue3.fire();
                break;
            case "4":
                buttonValue4.fire();
                break;
            case "5":
                buttonValue5.fire();
                break;
            case "6":
                buttonValue6.fire();
                break;
            case "7":
                buttonValue7.fire();
                break;
            case "8":
                buttonValue8.fire();
                break;
            case "9":
                buttonValue9.fire();
                break;
            case ".":
                buttonDot.fire();
                break;
            case "+":
                buttonPlus.fire();
                break;
            case "-":
                buttonMinus.fire();
                break;
            case "*":
                buttonMultiply.fire();
                break;
            case "/":
                buttonDiv.fire();
                break;
            case "=":
                buttonEqually.fire();
                break;
        }
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
