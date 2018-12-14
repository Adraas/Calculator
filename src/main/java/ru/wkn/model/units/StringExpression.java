package ru.wkn.model.units;

import ru.wkn.model.calculating.Calculator;

public class StringExpression {

    private StringNumber firstOperand;
    private StringNumber secondOperand;
    private char operator;
    private Calculator calculator;

    public StringExpression(Calculator calculator) {
        firstOperand = new StringNumber();
        secondOperand = new StringNumber();
        this.calculator = calculator;
    }

    public void setFirstOperand(StringNumber firstOperand) {
        this.firstOperand = firstOperand;
    }

    public void setSecondOperand(StringNumber secondOperand) {
        this.secondOperand = secondOperand;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public String getAnswerAsString() throws ArithmeticException {
        String operationAnswerAsString = firstOperand.getNumberAsString();
        double firstOperand = Double.parseDouble(this.firstOperand.getNumberAsString());
        double secondOperand = Double.parseDouble(this.secondOperand.getNumberAsString());
        if (operator != 0) {
            switch (operator) {
                case '+': {
                    operationAnswerAsString = String.valueOf(calculator.sum(firstOperand, secondOperand));
                    break;
                }
                case '-': {
                    operationAnswerAsString = String.valueOf(calculator.subtract(firstOperand, secondOperand));
                    break;
                }
                case '*': {
                    operationAnswerAsString = String.valueOf(calculator.multiply(firstOperand, secondOperand));
                    break;
                }
                case '/': {
                    operationAnswerAsString = String.valueOf(calculator.division(firstOperand, secondOperand));
                    break;
                }
                case '√': {
                    operationAnswerAsString = String.valueOf(calculator.squareRoot(firstOperand, secondOperand));
                    break;
                }
                case '^': {
                    operationAnswerAsString = String.valueOf(calculator.power(firstOperand, secondOperand));
                    break;
                }
                case '=': {
                    operationAnswerAsString = this.firstOperand.getNumberAsString();
                }
            }
        }
        String[] operationAnswerAsStringArray = operationAnswerAsString.split("\\.");
        if (operationAnswerAsStringArray.length > 0) {
            if (Double.parseDouble(operationAnswerAsString) % Integer.parseInt(operationAnswerAsStringArray[0]) == 0) {
                return operationAnswerAsStringArray[0];
            }
        }
        return operationAnswerAsString;
    }
}
