package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Messenger {

    private String inputURL = "./src/com/input/";
    private String outputURL = "./src/com/output/";

    private String inputMessage;
    private String outputMessage;

    public String getInputMessage() {
        return inputMessage;
    }

    public String getOutputMessage() {
        return outputMessage;
    }

    public void setOutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public void readFromFile(String fileName) {
        File file = new File(inputURL + fileName);
        StringBuilder builder = new StringBuilder();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                builder.append(scanner.nextLine());
            }
            inputMessage = builder.toString();

        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }

    public void writeToFile(String fileName) {
        try (FileWriter writer = new FileWriter(outputURL + fileName);) {
            writer.write(outputMessage);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
