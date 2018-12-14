package ru.wkn.model.units;

public class StringNumber {

    private String integerPart;
    private String fractionalPart;
    private boolean firstInput;
    private boolean isIntegerValue;
    private boolean dotEntered;
    private boolean fractionalPartEntered;

    public StringNumber() {
        integerPart = "0";
        fractionalPart = "";
        firstInput = true;
        isIntegerValue = true;
        dotEntered = false;
        fractionalPartEntered = false;
    }

    public void addToIntegerPart(char digit) {
        if (firstInput) {
            integerPart = String.valueOf(digit);
            firstInput = false;
        } else {
            integerPart = integerPart.concat(String.valueOf(digit));
        }
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

    public void setValueByString(String newValue) {
        String[] valueAsStringArray = newValue.split("\\.");
        integerPart = valueAsStringArray[0];
        if (valueAsStringArray.length > 1) {
            fractionalPart = valueAsStringArray[1];
        }
    }

    public String getNumberAsString() {
        String numberAsString = integerPart.equals("") ? "0" : integerPart;
        if (dotEntered) {
            if (fractionalPartEntered) {
                numberAsString = numberAsString.concat(".").concat(fractionalPart);
            }
        }
        return numberAsString;
    }
}
