package ru.wkn.controller.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import ru.wkn.controller.Controller;
import ru.wkn.model.CalculatorExpressionCompiler;
import ru.wkn.model.calculating.Calculator;

import java.util.HashMap;
import java.util.Map;

public class UnaryCalculatorController implements Controller {


    @FXML
    private Button buttonPower;
    @FXML
    private TextField textFieldResult;
    @FXML
    private Button buttonAC;
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
    private Slider sliderAccuracy;
    @FXML
    private Button buttonEqually;

    private Calculator calculator;
    private CalculatorExpressionCompiler calculatorExpressionCompiler;
    private Map<String, Button> stringButtonMap;

    public void initialize() {
        calculator = new Calculator((int) sliderAccuracy.getValue());
        calculatorExpressionCompiler = new CalculatorExpressionCompiler(calculator);
        stringButtonMap = new HashMap<>();
        stringButtonMapInit();
    }

    private void stringButtonMapInit() {
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
        stringButtonMap.put("^", buttonPower);
        stringButtonMap.put("=", buttonEqually);
    }

    private void showErrorInformation(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.show();
    }

    @FXML
    private void onActionTextField(ActionEvent actionEvent) {
        stringButtonMap.get(((Button) actionEvent.getSource()).getText()).fire();
    }

    @FXML
    private void onActionButtonAC() {
        textFieldResult.setText("0");
        calculatorExpressionCompiler.allClear();
    }

    @FXML
    private void onActionButtonValue1() {
        textFieldResult.setText(calculatorExpressionCompiler.getCurrentAnswerAsString('1'));
    }

    @FXML
    private void onActionButtonValue2() {
        textFieldResult.setText(calculatorExpressionCompiler.getCurrentAnswerAsString('2'));
    }

    @FXML
    private void onActionButtonValue3() {
        textFieldResult.setText(calculatorExpressionCompiler.getCurrentAnswerAsString('3'));
    }

    @FXML
    private void onActionButtonValue4() {
        textFieldResult.setText(calculatorExpressionCompiler.getCurrentAnswerAsString('4'));
    }

    @FXML
    private void onActionButtonValue5() {
        textFieldResult.setText(calculatorExpressionCompiler.getCurrentAnswerAsString('5'));
    }

    @FXML
    private void onActionButtonValue6() {
        textFieldResult.setText(calculatorExpressionCompiler.getCurrentAnswerAsString('6'));
    }

    @FXML
    private void onActionButtonValue7() {
        textFieldResult.setText(calculatorExpressionCompiler.getCurrentAnswerAsString('7'));
    }

    @FXML
    private void onActionButtonValue8() {
        textFieldResult.setText(calculatorExpressionCompiler.getCurrentAnswerAsString('8'));
    }

    @FXML
    private void onActionButtonValue9() {
        textFieldResult.setText(calculatorExpressionCompiler.getCurrentAnswerAsString('9'));
    }

    @FXML
    private void onActionButtonValue0() {
        textFieldResult.setText(calculatorExpressionCompiler.getCurrentAnswerAsString('0'));
    }

    @FXML
    private void onActionButtonDot() {
        textFieldResult.setText(calculatorExpressionCompiler.getCurrentAnswerAsString('.'));
    }

    @FXML
    private void onActionButtonPlus() {
        try {
            textFieldResult.setText(calculatorExpressionCompiler.getCurrentAnswerAsString('+'));
        } catch (ArithmeticException e) {
            showErrorInformation(e.getClass().getSimpleName(), e.getMessage());
            onActionButtonAC();
        }
    }

    @FXML
    private void onActionButtonMinus() {
        try {
            textFieldResult.setText(calculatorExpressionCompiler.getCurrentAnswerAsString('-'));
        } catch (ArithmeticException e) {
            showErrorInformation(e.getClass().getSimpleName(), e.getMessage());
            onActionButtonAC();
        }
    }

    @FXML
    private void onActionButtonMultiply() {
        try {
            textFieldResult.setText(calculatorExpressionCompiler.getCurrentAnswerAsString('*'));
        } catch (ArithmeticException e) {
            showErrorInformation(e.getClass().getSimpleName(), e.getMessage());
            onActionButtonAC();
        }
    }

    @FXML
    private void onActionButtonSqrt() {
        try {
            textFieldResult.setText(calculatorExpressionCompiler.getCurrentAnswerAsString('√'));
        } catch (ArithmeticException e) {
            showErrorInformation(e.getClass().getSimpleName(), e.getMessage());
            onActionButtonAC();
        }
    }

    @FXML
    private void onActionButtonDiv() {
        try {
            textFieldResult.setText(calculatorExpressionCompiler.getCurrentAnswerAsString('/'));
        } catch (ArithmeticException e) {
            showErrorInformation(e.getClass().getSimpleName(), e.getMessage());
            onActionButtonAC();
        }
    }

    @FXML
    private void onActionButtonPower() {
        try {
            textFieldResult.setText(calculatorExpressionCompiler.getCurrentAnswerAsString('^'));
        } catch (ArithmeticException e) {
            showErrorInformation(e.getClass().getSimpleName(), e.getMessage());
            onActionButtonAC();
        }
    }

    @FXML
    private void onActionButtonEqually() {
        try {
            textFieldResult.setText(calculatorExpressionCompiler.getCurrentAnswerAsString('='));
        } catch (ArithmeticException e) {
            showErrorInformation(e.getClass().getSimpleName(), e.getMessage());
            onActionButtonAC();
        }
    }

    @FXML
    private void onMouseClickedAccuracy() {
        calculator.setRoundingAccuracy((int) sliderAccuracy.getValue());
    }
}
