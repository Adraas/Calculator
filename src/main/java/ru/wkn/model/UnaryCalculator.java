package ru.wkn.model;

public class UnaryCalculator {

    private int roundingAccuracy;

    public UnaryCalculator(int roundingAccuracy) {
        this.roundingAccuracy = roundingAccuracy;
    }

    public int getRoundingAccuracy() {
        return roundingAccuracy;
    }

    public void setRoundingAccuracy(int roundingAccuracy) {
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
        return Math.round(value * accuracyCoefficient) / accuracyCoefficient;
    }
}
