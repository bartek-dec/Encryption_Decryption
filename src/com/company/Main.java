package com.company;

import com.company.strategy.*;

public class Main {

    private static final String ENC = "enc";
    private static final String DEC = "dec";
    private static final String UNICODE = "unicode";
    private static final String SHIFT = "shift";

    public static void main(String[] args) {

        Helper helper = new Helper(args);
        Context context = new Context();
        Messenger messenger = new Messenger();

        //get data from command line
        String modeValue = helper.getModeValue();
        String keyValue = helper.getKeyValue();
        String dataValue = helper.getDataValue();
        String in = helper.getIn();
        String out = helper.getOut();
        String alg = helper.getAlg();

        //set key in context
        if (keyValue != null) {
            context.setKey(Integer.parseInt(keyValue));
        } else {
            context.setKey(0);
        }

        //set input message in context
        if (dataValue != null && in != null) {
            context.setInputMessage(dataValue);
        } else if (dataValue != null) {
            context.setInputMessage(dataValue);
        } else if (in != null) {
            messenger.readFromFile(in);
            context.setInputMessage(messenger.getInputMessage());
        } else {
            context.setInputMessage("");
        }

        //set strategy
        if (ENC.equals(modeValue) && UNICODE.equals(alg)) {
            context.setStrategy(new EncodeUnicode());
        } else if (ENC.equals(modeValue) && SHIFT.equals(alg)) {
            context.setStrategy(new EncodeShift());
        } else if (DEC.equals(modeValue) && UNICODE.equals(alg)) {
            context.setStrategy(new DecodeUnicode());
        } else if (DEC.equals(modeValue) && SHIFT.equals(alg)) {
            context.setStrategy(new DecodeShift());
        } else if (modeValue == null && UNICODE.equals(alg)) {
            context.setStrategy(new EncodeUnicode());
        } else if (modeValue == null && SHIFT.equals(alg)) {
            context.setStrategy(new EncodeShift());
        } else if (ENC.equals(modeValue) && alg == null) {
            context.setStrategy(new EncodeShift());
        } else if (DEC.equals(modeValue) && alg == null) {
            context.setStrategy(new DecodeShift());
        } else {
            context.setStrategy(new EncodeShift());
        }

        //perform required action
        String output = context.processMessage();
        messenger.setOutputMessage(output);

        //display result
        if (out != null) {
            messenger.writeToFile(out);
        } else {
            System.out.println(messenger.getOutputMessage());
        }
    }
}
