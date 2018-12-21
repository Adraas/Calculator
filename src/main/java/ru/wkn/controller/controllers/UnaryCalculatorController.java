package ru.wkn.controller.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import ru.wkn.controller.Controller;
import ru.wkn.model.CalculatorExpressionCompiler;
import ru.wkn.model.calculating.Calculator;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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
        stringButtonMap.put("NUMPAD0", buttonValue0);
        stringButtonMap.put("NUMPAD1", buttonValue1);
        stringButtonMap.put("NUMPAD2", buttonValue2);
        stringButtonMap.put("NUMPAD3", buttonValue3);
        stringButtonMap.put("NUMPAD4", buttonValue4);
        stringButtonMap.put("NUMPAD5", buttonValue5);
        stringButtonMap.put("NUMPAD6", buttonValue6);
        stringButtonMap.put("NUMPAD7", buttonValue7);
        stringButtonMap.put("NUMPAD8", buttonValue8);
        stringButtonMap.put("NUMPAD9", buttonValue9);
        stringButtonMap.put("DECIMAL", buttonDot);
        stringButtonMap.put("ADD", buttonPlus);
        stringButtonMap.put("SUBTRACT", buttonMinus);
        stringButtonMap.put("MULTIPLY", buttonMultiply);
        stringButtonMap.put("DIVIDE", buttonDiv);
        stringButtonMap.put("DIGIT6", buttonPower);
        stringButtonMap.put("ENTER", buttonEqually);
        stringButtonMap.put("BACK_SPACE", buttonAC);
    }

    private void showInformation(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.show();
    }

    @FXML
    private void onActionMenuItemAbout() {
        Properties properties = new Properties();
        Reader reader = new InputStreamReader(getClass().getResourceAsStream("/information/information.properties"));
        try {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        showInformation(properties.getProperty("title"), properties.getProperty("message"), Alert.AlertType.INFORMATION);
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
            showInformation(e.getClass().getSimpleName(), e.getMessage(), Alert.AlertType.ERROR);
            onActionButtonAC();
        }
    }

    @FXML
    private void onActionButtonMinus() {
        try {
            textFieldResult.setText(calculatorExpressionCompiler.getCurrentAnswerAsString('-'));
        } catch (ArithmeticException e) {
            showInformation(e.getClass().getSimpleName(), e.getMessage(), Alert.AlertType.ERROR);
            onActionButtonAC();
        }
    }

    @FXML
    private void onActionButtonMultiply() {
        try {
            textFieldResult.setText(calculatorExpressionCompiler.getCurrentAnswerAsString('*'));
        } catch (ArithmeticException e) {
            showInformation(e.getClass().getSimpleName(), e.getMessage(), Alert.AlertType.ERROR);
            onActionButtonAC();
        }
    }

    @FXML
    private void onActionButtonSqrt() {
        try {
            textFieldResult.setText(calculatorExpressionCompiler.getCurrentAnswerAsString('√'));
        } catch (ArithmeticException e) {
            showInformation(e.getClass().getSimpleName(), e.getMessage(), Alert.AlertType.ERROR);
            onActionButtonAC();
        }
    }

    @FXML
    private void onActionButtonDiv() {
        try {
            textFieldResult.setText(calculatorExpressionCompiler.getCurrentAnswerAsString('/'));
        } catch (ArithmeticException e) {
            showInformation(e.getClass().getSimpleName(), e.getMessage(), Alert.AlertType.ERROR);
            onActionButtonAC();
        }
    }

    @FXML
    private void onActionButtonPower() {
        try {
            textFieldResult.setText(calculatorExpressionCompiler.getCurrentAnswerAsString('^'));
        } catch (ArithmeticException e) {
            showInformation(e.getClass().getSimpleName(), e.getMessage(), Alert.AlertType.ERROR);
            onActionButtonAC();
        }
    }

    @FXML
    private void onActionButtonEqually() {
        try {
            textFieldResult.setText(calculatorExpressionCompiler.getCurrentAnswerAsString('='));
        } catch (ArithmeticException e) {
            showInformation(e.getClass().getSimpleName(), e.getMessage(), Alert.AlertType.ERROR);
            onActionButtonAC();
        }
    }

    @FXML
    private void onMouseClickedAccuracy() {
        calculator.setRoundingAccuracy((int) sliderAccuracy.getValue());
    }

    @FXML
    private void onActionTextField(KeyEvent keyEvent) {
        stringButtonMap.get(keyEvent.getCode().toString()).fire();
    }

    @FXML
    private void onActionButton1(KeyEvent keyEvent) {
        stringButtonMap.get(keyEvent.getCode().toString()).fire();
    }

    @FXML
    private void onActionButton2(KeyEvent keyEvent) {
        stringButtonMap.get(keyEvent.getCode().toString()).fire();
    }

    @FXML
    private void onActionButton3(KeyEvent keyEvent) {
        stringButtonMap.get(keyEvent.getCode().toString()).fire();
    }

    @FXML
    private void onActionButton4(KeyEvent keyEvent) {
        stringButtonMap.get(keyEvent.getCode().toString()).fire();
    }

    @FXML
    private void onActionButton5(KeyEvent keyEvent) {
        stringButtonMap.get(keyEvent.getCode().toString()).fire();
    }

    @FXML
    private void onActionButton6(KeyEvent keyEvent) {
        stringButtonMap.get(keyEvent.getCode().toString()).fire();
    }

    @FXML
    private void onActionButton7(KeyEvent keyEvent) {
        stringButtonMap.get(keyEvent.getCode().toString()).fire();
    }

    @FXML
    private void onActionButton8(KeyEvent keyEvent) {
        stringButtonMap.get(keyEvent.getCode().toString()).fire();
    }

    @FXML
    private void onActionButton9(KeyEvent keyEvent) {
        stringButtonMap.get(keyEvent.getCode().toString()).fire();
    }

    @FXML
    private void onActionButton0(KeyEvent keyEvent) {
        stringButtonMap.get(keyEvent.getCode().toString()).fire();
    }

    @FXML
    private void onActionKeyDot(KeyEvent keyEvent) {
        stringButtonMap.get(keyEvent.getCode().toString()).fire();
    }

    @FXML
    private void onActionKeyPlus(KeyEvent keyEvent) {
        stringButtonMap.get(keyEvent.getCode().toString()).fire();
    }

    @FXML
    private void onActionKeyMinus(KeyEvent keyEvent) {
        stringButtonMap.get(keyEvent.getCode().toString()).fire();
    }

    @FXML
    private void onActionKeyMultiply(KeyEvent keyEvent) {
        stringButtonMap.get(keyEvent.getCode().toString()).fire();
    }

    @FXML
    private void onActionKeyDiv(KeyEvent keyEvent) {
        stringButtonMap.get(keyEvent.getCode().toString()).fire();
    }

    @FXML
    private void onActionKeySqrt(KeyEvent keyEvent) {
        stringButtonMap.get(keyEvent.getCode().toString()).fire();
    }

    @FXML
    private void onActionSliderAccuracy(KeyEvent keyEvent) {
        stringButtonMap.get(keyEvent.getCode().toString()).fire();
    }

    @FXML
    private void onActionKeyPower(KeyEvent keyEvent) {
        stringButtonMap.get(keyEvent.getCode().toString()).fire();
    }

    @FXML
    private void onActionKeyEqually(KeyEvent keyEvent) {
        stringButtonMap.get(keyEvent.getCode().toString()).fire();
    }
}
