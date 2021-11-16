package com.hemebiotech.analytics;
import java.io.*;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class WriteFile {
    private SortedMap<String, Integer> result;
    public WriteFile() {
        this.result = new TreeMap<>();
    }

    /**
     * @create a file "result.out"
     */
    public void createFile() {

        try {
            File myObj = new File("result.out");
            if (myObj.createNewFile()) {

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    /**
    /* result get his information from readSymptomDataFromFile then it wrote into result.out
     */
    public void writeToFile() {


        ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile("symptoms.txt");


        createFile();


        this.result = readSymptomDataFromFile.getSymptoms();
        System.out.println("test 5");


        try {

            FileWriter writer = new FileWriter ("result.out");

            for(String iteration: result.keySet()){
                writer.write(iteration + " " + this.result.get(iteration) + "\n");
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}

