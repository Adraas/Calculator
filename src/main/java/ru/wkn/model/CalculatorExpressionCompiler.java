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
            if (firstOperandInput) {
                if (!firstOperand.isDotEntered()) {
                    firstOperand.addToIntegerPart(inputSymbol);
                } else {
                    firstOperand.addToFractionalPart(inputSymbol);
                }
                return firstOperand.getNumberAsString();
            }
            if (!firstOperandInput) {
                if (!secondOperand.isDotEntered()) {
                    secondOperand.addToIntegerPart(inputSymbol);
                } else {
                    secondOperand.addToFractionalPart(inputSymbol);
                }
                return secondOperand.getNumberAsString();
            }
        }
        if (inputSymbol == '.') {
            if (firstOperandInput) {
                firstOperand.inputDot();
                return firstOperand.getNumberAsString();
            }
            if (!firstOperandInput) {
                secondOperand.inputDot();
                return secondOperand.getNumberAsString();
            }
        }
        if ("+-*/√^=".contains(String.valueOf(inputSymbol))) {
            currentOperator = inputSymbol;
            switch (inputSymbol) {
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
        return stringExpression.getAnswerAsString();
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
