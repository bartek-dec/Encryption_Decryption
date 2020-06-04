package com.company.strategy;

public class EncodeShift implements Strategy{

    @Override
    public String processMessage(String message, int key) {
        if (key > 25) {
            key %= 26;
        }

        StringBuilder builder = new StringBuilder();

        int length = message.length();

        for (int i = 0; i < length; i++) {
            int value = message.charAt(i);
            int shiftedValue = value + key;
            char shiftedLetter = '0';
            int temp = key;

            if (value >= 65 && value <= 90) {
                if (shiftedValue <= 90) {
                    shiftedLetter = (char) shiftedValue;
                } else {
                    key = shiftedValue - 90;
                    shiftedLetter = (char) (64 + key);
                }
            } else if (value >= 97 && value <= 122) {
                if (shiftedValue <= 122) {
                    shiftedLetter = (char) shiftedValue;
                } else {
                    key = shiftedValue - 122;
                    shiftedLetter = (char) (96 + key);
                }
            } else {
                shiftedLetter = message.charAt(i);
            }
            key = temp;
            builder.append(shiftedLetter);
        }
        return builder.toString();
    }
}
