package com.company.strategy;

public class DecodeShift implements Strategy {

    @Override
    public String processMessage(String message, int key) {
        if (key > 25) {
            key %= 26;
        }

        StringBuilder builder = new StringBuilder();

        int length = message.length();

        for (int i = 0; i < length; i++) {
            int value = message.charAt(i);
            int shiftedValue = value - key;
            char shiftedLetter = '0';
            int temp = key;

            if (value >= 65 && value <= 90) {
                if (shiftedValue >= 65) {
                    shiftedLetter = (char) shiftedValue;
                } else {
                    key = 65 - shiftedValue;
                    shiftedLetter = (char) (91 - key);
                }
            } else if (value >= 97 && value <= 122) {
                if (shiftedValue >= 97) {
                    shiftedLetter = (char) shiftedValue;
                } else {
                    key = 97 - shiftedValue;
                    shiftedLetter = (char) (123 - key);
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
