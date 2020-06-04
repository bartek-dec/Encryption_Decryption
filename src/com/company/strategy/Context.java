package com.company.strategy;

public class Context {

    private Strategy strategy;
    private String inputMessage;
    private int key;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setInputMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String processMessage() {
        return strategy.processMessage(inputMessage, key);
    }
}
