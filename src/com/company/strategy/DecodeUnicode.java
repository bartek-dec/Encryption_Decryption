package com.company.strategy;

public class DecodeUnicode implements Strategy {

    @Override
    public String processMessage(String message, int key) {
        StringBuilder builder = new StringBuilder();

        int length = message.length();

        for (int i = 0; i < length; i++) {
            int value = message.charAt(i) - key;
            char shiftedSign = (char) value;
            builder.append(shiftedSign);
        }
        return builder.toString();
    }
}
