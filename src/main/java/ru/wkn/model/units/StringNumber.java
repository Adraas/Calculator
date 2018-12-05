package ru.wkn.model.units;

public class StringNumber {

    private String integerPart;
    private String fractionalPart;
    private boolean isIntegerValue;
    private boolean dotEntered;
    private boolean fractionalPartEntered;

    public StringNumber() {
        integerPart = "";
        fractionalPart = "";
        isIntegerValue = true;
        dotEntered = false;
        fractionalPartEntered = false;
    }

    public void addToIntegerPart(char digit) {
        integerPart = integerPart.concat(String.valueOf(digit));
    }

    public void addToFractionalPart(char digit) {
        fractionalPart = fractionalPart.concat(String.valueOf(digit));
        if (!fractionalPartEntered) {
            isIntegerValue = false;
            fractionalPartEntered = true;
        }
    }

    public boolean isDotEntered() {
        return dotEntered;
    }

    public void inputDot() {
        dotEntered = true;
    }

    public boolean isFractionalPartEntered() {
        return fractionalPartEntered;
    }

    public boolean isIntegerValue() {
        return isIntegerValue;
    }

    @Override
    public String toString() {
        String numberAsString = integerPart.equals("") ? "0" : integerPart;
        if (dotEntered) {
            if (fractionalPartEntered) {
                numberAsString = numberAsString.concat(".").concat(fractionalPart);
            }
        }
        return numberAsString;
    }
}
