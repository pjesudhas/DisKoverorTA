package model;

/**
 * Created by praveen on 14/10/14.
 */

public class DataContent {

    public String rawInput;

    public DataContent() {}

    public DataContent(String rawInput) {
        this.rawInput = rawInput;
    }

    public void save() {
       System.out.println(rawInput);
    }

    public String toString() {
        return String.format("%s",rawInput);
    }

}