package ru.wkn.model;

import ru.wkn.model.calculating.Calculator;
import ru.wkn.model.units.StringExpression;
import ru.wkn.model.units.StringNumber;

public class CalculatorExpressionCompiler {

    private StringNumber firstOperand;
    private StringNumber secondOperand;
    private StringExpression stringExpression;
    private Calculator calculator;
    private boolean firstOperandInput;
    private char currentOperator;

    public CalculatorExpressionCompiler(Calculator calculator) {
        this.calculator = calculator;
        allClear();
    }

    public String getCurrentAnswerAsString(char inputSymbol) throws ArithmeticException {
        if (Character.isDigit(inputSymbol)) {
            return valueAfterAddingDigit(inputSymbol);
        }
        if (inputSymbol == '.') {
            return valueAfterInputDot();
        }
        if ("+-*/√^=".contains(String.valueOf(inputSymbol))) {
            currentOperator = inputSymbol;
            inputOperator();
        }
        return stringExpression.getAnswerAsString();
    }

    private String valueAfterAddingDigit(char inputDigit) {
        if (firstOperandInput) {
            if (!firstOperand.isDotEntered()) {
                firstOperand.addToIntegerPart(inputDigit);
            } else {
                firstOperand.addToFractionalPart(inputDigit);
            }
            return firstOperand.getNumberAsString();
        } else {
            if (!secondOperand.isDotEntered()) {
                secondOperand.addToIntegerPart(inputDigit);
            } else {
                secondOperand.addToFractionalPart(inputDigit);
            }
            return secondOperand.getNumberAsString();
        }
    }

    private String valueAfterInputDot() {
        if (firstOperandInput) {
            firstOperand.inputDot();
            return firstOperand.getNumberAsString();
        } else {
            secondOperand.inputDot();
            return secondOperand.getNumberAsString();
        }
    }

    private void inputOperator() {
        switch (currentOperator) {
            case '+': {
                fillExpression();
                break;
            }
            case '-': {
                fillExpression();
                break;
            }
            case '*': {
                fillExpression();
                break;
            }
            case '/': {
                fillExpression();
                break;
            }
            case '√': {
                fillExpression();
                break;
            }
            case '^': {
                fillExpression();
                break;
            }
            case '=': {
                fillExpression();
                break;
            }
        }
    }

    private void fillExpression() {
        stringExpression.setOperator(currentOperator);
        if (firstOperandInput) {
            stringExpression.setFirstOperand(firstOperand);
        } else {
            stringExpression.setSecondOperand(secondOperand);
        }
        firstOperandInput = false;
    }

    public void allClear() {
        firstOperand = new StringNumber();
        secondOperand = new StringNumber();
        stringExpression = new StringExpression(calculator);
        firstOperandInput = true;
        currentOperator = 0;
    }
}
