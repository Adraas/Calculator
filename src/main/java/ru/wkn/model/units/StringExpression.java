package ru.wkn.model.units;

import ru.wkn.model.calculating.Calculator;

public class StringExpression {

    private StringNumber firstOperand;
    private StringNumber secondOperand;
    private String operator;
    private Calculator calculator;

    public StringExpression(Calculator calculator) {
        firstOperand = new StringNumber();
        secondOperand = new StringNumber();
        operator = null;
        this.calculator = calculator;
    }

    public void setFirstOperand(StringNumber firstOperand) {
        this.firstOperand = firstOperand;
    }

    public void setSecondOperand(StringNumber secondOperand) {
        this.secondOperand = secondOperand;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperationAnswer() {
        String operationAnswerAsString = "0";
        double firstOperand = Double.parseDouble(this.firstOperand.toString());
        double secondOperand = Double.parseDouble(this.secondOperand.toString());
        if (operator != null) {
            switch (operator) {
                case "+":
                    operationAnswerAsString = String.valueOf(calculator.sum(firstOperand, secondOperand));
                    break;
                case "-":
                    operationAnswerAsString = String.valueOf(calculator.subtract(firstOperand, secondOperand));
                    break;
                case "*":
                    operationAnswerAsString = String.valueOf(calculator.multiply(firstOperand, secondOperand));
                    break;
                case "/":
                    operationAnswerAsString = String.valueOf(calculator.division(firstOperand, secondOperand));
                    break;
                case "√":
                    operationAnswerAsString = String.valueOf(calculator.squareRoot(firstOperand));
                    break;
            }
        }
        if (Double.parseDouble(operationAnswerAsString) % Integer.parseInt(operationAnswerAsString.split(".")[0]) == 0) {
            return operationAnswerAsString.split(".")[0];
        } else {
            return operationAnswerAsString;
        }
    }
}
