package com.company;

public class Helper {

    private String[] args;
    private String modeValue;
    private String keyValue;
    private String dataValue;
    private String in;
    private String out;
    private String alg;

    public Helper(String[] args) {
        this.args = args;
        divideArray();
    }

    public String getModeValue() {
        return modeValue;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public String getDataValue() {
        return dataValue;
    }

    public String getIn() {
        return in;
    }

    public String getOut() {
        return out;
    }

    public String getAlg() {
        return alg;
    }

    private void divideArray() {
        int length = args.length;

        for (int i = 0; i < length; i += 2) {
            String s = args[i];

            switch (s) {
                case "-mode":
                    modeValue = args[i + 1];
                    break;
                case "-key":
                    keyValue = args[i + 1];
                    break;
                case "-data":
                    dataValue = args[i + 1];
                    break;
                case "-in":
                    in = args[i + 1];
                    break;
                case "-out":
                    out = args[i + 1];
                    break;
                case "-alg":
                    alg = args[i + 1];
            }
        }
    }
}
