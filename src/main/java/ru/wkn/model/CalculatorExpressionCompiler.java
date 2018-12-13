package ru.wkn.model;

import ru.wkn.model.calculating.Calculator;
import ru.wkn.model.units.StringExpression;
import ru.wkn.model.units.StringNumber;

public class CalculatorExpressionCompiler {

    private StringNumber previousOperand;
    private StringNumber currentOperand;
    private StringExpression stringExpression;
    private Calculator calculator;
    private boolean firstInput;
    private boolean operatorEntered;
    private String currentOperator;

    public CalculatorExpressionCompiler(Calculator calculator) {
        this.calculator = calculator;
        allClear();
    }

    public String getCurrentAnswerAsString(char inputSymbol) throws ArithmeticException {
        if (Character.isDigit(inputSymbol)) {
            if (firstInput) {
                previousOperand.addToIntegerPart(inputSymbol);
                firstInput = false;
                return previousOperand.getNumberAsString();
            } else {
                if (operatorEntered) {
                    if (!currentOperand.isDotEntered()) {
                        currentOperand.addToIntegerPart(inputSymbol);
                    } else {
                        currentOperand.addToFractionalPart(inputSymbol);
                    }
                    operatorEntered = false;
                    return currentOperand.getNumberAsString();
                } else {
                    if (!previousOperand.isDotEntered()) {
                        previousOperand.addToIntegerPart(inputSymbol);
                    } else {
                        previousOperand.addToFractionalPart(inputSymbol);
                    }
                    return previousOperand.getNumberAsString();
                }
            }
        } else {
            if (inputSymbol == '.') {
                if (!operatorEntered) {
                    previousOperand.inputDot();
                    firstInput = false;
                    return previousOperand.getNumberAsString();
                } else {
                    currentOperand.inputDot();
                    firstInput = false;
                    return currentOperand.getNumberAsString();
                }
            } else {
                if (!operatorEntered) {
                    switch (inputSymbol) {
                        case '+': {
                            break;
                        }
                        case '-': {
                            break;
                        }
                        case '*': {
                            break;
                        }
                        case '/': {
                            break;
                        }
                        case '√': {
                            break;
                        }
                        case '^': {
                            break;
                        }
                        case '=': {
                            break;
                        }
                    }
                }
            }
        }
        return "0";
    }

    public void allClear() {
        previousOperand = new StringNumber();
        currentOperand = new StringNumber();
        stringExpression = new StringExpression(calculator);
        firstInput = true;
        operatorEntered = false;
        currentOperator = null;
    }

    public boolean isFirstInput() {
        return firstInput;
    }

    public boolean isOperatorEntered() {
        return operatorEntered;
    }
}
