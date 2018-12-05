package ru.wkn.model;

public class CalculatorExpressionCompiler {

    private double previousOperand;
    private double currentOperand;
    private boolean firstInput;
    private boolean operatorEntered;
    private String currentOperator;

    public CalculatorExpressionCompiler() {
        allClear();
    }

    public double getCurrentAnswer(char inputSymbol) {
        if (Character.isDigit(inputSymbol)) {
            if (firstInput) {
                previousOperand = Double.parseDouble(String.valueOf(inputSymbol));
                firstInput = false;
            } else {
                if (operatorEntered) {
                    currentOperand = Double.parseDouble(String.valueOf(inputSymbol));
                    operatorEntered = false;
                } else {
                    previousOperand = Double.parseDouble(String.valueOf(previousOperand)
                            .concat(String.valueOf(inputSymbol)));
                }
            }
        } else {
            if (inputSymbol == '.') {
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
                        case '=': {
                            break;
                        }
                    }
                }
            }
        }
        return 0;
    }

    public void allClear() {
        previousOperand = 0;
        currentOperand = 0;
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
