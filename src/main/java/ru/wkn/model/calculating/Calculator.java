package ru.wkn.model.calculating;

public class Calculator {

    private int roundingAccuracy;

    public Calculator(int roundingAccuracy) {
        setRoundingAccuracy(roundingAccuracy);
    }

    public int getRoundingAccuracy() {
        return roundingAccuracy;
    }

    public void setRoundingAccuracy(int roundingAccuracy) {
        if (roundingAccuracy <= 0) {
            throw new NumberFormatException("Value of the rounding accuracy is incorrect: "
                    .concat(String.valueOf(roundingAccuracy).concat(";\n"))
                    .concat("Expected value > 0."));
        }
        this.roundingAccuracy = roundingAccuracy;
    }

    public double sum(double firstAddend, double secondAddend) {
        return round(firstAddend + secondAddend);
    }

    public double subtract(double minuend, double subtrahend) {
        return round(minuend - subtrahend);
    }

    public double multiply(double firstMultiplier, double secondMultiplier) {
        return round(firstMultiplier * secondMultiplier);
    }

    public double division(double dividend, double divisor) {
        return round(dividend / divisor);
    }

    public double squareRoot(double value) {
        return round(Math.sqrt(value));
    }

    private double round(double value) {
        int accuracyCoefficient = (int) Math.pow(10, roundingAccuracy);
        return (double) Math.round(value * accuracyCoefficient) / accuracyCoefficient;
    }
}
