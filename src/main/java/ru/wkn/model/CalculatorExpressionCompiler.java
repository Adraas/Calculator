package ru.wkn.model;

import ru.wkn.model.calculating.Calculator;
import ru.wkn.model.units.StringExpression;
import ru.wkn.model.units.StringNumber;

public class CalculatorExpressionCompiler {

    private StringNumber firstOperand;
    private StringNumber secondOperand;
    private StringExpression stringExpression;
    private Calculator calculator;
    private boolean firstInput;
    private boolean operatorEntered;
    private char currentOperator;

    public CalculatorExpressionCompiler(Calculator calculator) {
        this.calculator = calculator;
        allClear();
    }

    public String getCurrentAnswerAsString(char inputSymbol) throws ArithmeticException {
        if (Character.isDigit(inputSymbol)) {
            if (firstInput) {
                firstOperand.addToIntegerPart(inputSymbol);
                firstInput = false;
                return firstOperand.getNumberAsString();
            } else {
                if (operatorEntered) {
                    if (!secondOperand.isDotEntered()) {
                        secondOperand.addToIntegerPart(inputSymbol);
                    } else {
                        secondOperand.addToFractionalPart(inputSymbol);
                    }
                    operatorEntered = false;
                    return secondOperand.getNumberAsString();
                } else {
                    if (!firstOperand.isDotEntered()) {
                        firstOperand.addToIntegerPart(inputSymbol);
                    } else {
                        firstOperand.addToFractionalPart(inputSymbol);
                    }
                    return firstOperand.getNumberAsString();
                }
            }
        } else {
            if (inputSymbol == '.') {
                if (!operatorEntered) {
                    firstOperand.inputDot();
                    firstInput = false;
                    return firstOperand.getNumberAsString();
                } else {
                    secondOperand.inputDot();
                    firstInput = false;
                    return secondOperand.getNumberAsString();
                }
            } else {
                switch (inputSymbol) {
                    case '+': {
                        currentOperator = inputSymbol;
                        fillExpression();
                        operatorEntered = true;
                        return firstOperand.getNumberAsString();
                    }
                    case '-': {
                        currentOperator = inputSymbol;
                        fillExpression();
                        operatorEntered = true;
                        return firstOperand.getNumberAsString();
                    }
                    case '*': {
                        currentOperator = inputSymbol;
                        fillExpression();
                        operatorEntered = true;
                        return firstOperand.getNumberAsString();
                    }
                    case '/': {
                        currentOperator = inputSymbol;
                        fillExpression();
                        operatorEntered = true;
                        return firstOperand.getNumberAsString();
                    }
                    case '√': {
                        currentOperator = inputSymbol;
                        fillExpression();
                        operatorEntered = true;
                        return firstOperand.getNumberAsString();
                    }
                    case '^': {
                        currentOperator = inputSymbol;
                        fillExpression();
                        operatorEntered = true;
                        return firstOperand.getNumberAsString();
                    }
                    case '=': {
                        operatorEntered = false;
                        break;
                    }
                }
            }
        }
        return stringExpression.getAnswerAsString();
    }

    private void fillExpression() {
        stringExpression.setOperator(currentOperator);
        if (!operatorEntered) {
            stringExpression.setFirstOperand(firstOperand);
        } else {
            stringExpression.setSecondOperand(secondOperand);
        }
    }

    public void allClear() {
        firstOperand = new StringNumber();
        secondOperand = new StringNumber();
        stringExpression = new StringExpression(calculator);
        firstInput = true;
        operatorEntered = false;
        currentOperator = 0;
    }

    public boolean isFirstInput() {
        return firstInput;
    }

    public boolean isOperatorEntered() {
        return operatorEntered;
    }
}
