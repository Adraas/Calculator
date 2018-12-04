package ru.wkn.model;

public class UnaryCalculatorExpressionChecker {

    private double previousOperand;
    private double currentOperand;
    private boolean firstInput;
    private boolean operatorEntered;
    private String currentOperator;

    public UnaryCalculatorExpressionChecker() {
        allClear();
    }

    public double getCurrentAnswer(String inputSymbol) {
        // some stub...
        return 0;
    }

    public void allClear() {
        previousOperand = 0;
        currentOperand = 0;
        firstInput = true;
        operatorEntered = true;
        currentOperator = "+";
    }
}
