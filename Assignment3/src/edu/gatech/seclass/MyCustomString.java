package edu.gatech.seclass;

import java.util.*;

public class MyCustomString implements MyCustomStringInterface {

    private String string;

    // Sets the value of the current string
    public void setString(String string) {
        this.string = string;
    }

    // If the string is null, or has not been set to a value with setString, it should return null.
    public String getString() {
        if (string.length() != 0) {
            return string;
        }
        return null;
    }



    public char mostCommonChar() throws NullPointerException{
        //convert to lowercases first, remove all non-alphabetic characters
        String alphaString = string.toLowerCase().replaceAll("[^a-z]", "");
        //work on the processed string from this point
        //if string length = 0, throw null exception, if > 0 the process continues
        if (alphaString.length() <=0 ){
            throw new NullPointerException();
        }

        //set up a dictionary (hashmap) for each letter to count the occurance
        //reference: https://stackoverflow.com/questions/13163547/using-hashmap-to-count-instances
        HashMap<Character, Integer> letterCounts = new HashMap<Character,Integer>();
        int len = alphaString.length();
        for (int i=0; i<len; i++) {
            char l = alphaString.charAt(i);
            if (letterCounts.containsKey(l)){
                letterCounts.put(l, letterCounts.get(l)+1);
            }
            else{
                letterCounts.put(l, 1);
            }
        }

        int loc = alphaString.length();
        char commCh  = alphaString.charAt(0); //initialize commCh as first character
        //get maxcount, reference:https://stackoverflow.com/questions/5911174/finding-key-associated-with-max-value-in-a-java-map
        int maxValueInMap=(Collections.max(letterCounts.values()));
        //System.out.println(maxValueInMap);

        for (Map.Entry<Character, Integer> entry : letterCounts.entrySet()) {
            if (entry.getValue()==maxValueInMap) {
                char currentLetter = entry.getKey();     //locate letter with maxcount
                int currentLoc = alphaString.indexOf(currentLetter);
                //System.out.println(currentLetter);
                if (loc > currentLoc) { //find letter with min location
                    loc = currentLoc;
                    commCh  = alphaString.charAt(loc);
                }
            }
        }
        return commCh;
    }

    public String filterLetters(int n, boolean more) throws NullPointerException, IllegalArgumentException {

        String lowerString = string.toLowerCase(); // convert to lowercase
        // throw exceptions
        if (string == null) {
            throw new NullPointerException();
        }
        if (n <=0) {
            throw new IllegalArgumentException();
        }

        // create hashmap for count
        HashMap<Character,Integer> letterCounts = new HashMap<Character,Integer>();
        int len = string.length();
        for (int i=0; i<len; i++) {
            char l = lowerString.charAt(i);
            if (letterCounts.containsKey(l)){
                letterCounts.put(l, letterCounts.get(l)+1);
            }
            else{
                letterCounts.put(l, 1);
            }
        }

        // append corresponding letter to initialzed result string
        String filLetters = "";
        for (int i=0; i<len; i++) {
            char currentCharacter = lowerString.charAt(i);
            String currentLetter = Character.toString(string.charAt(i));
            if (more){ //keep char greater than n times
                if (letterCounts.get(currentCharacter) > n){
                    filLetters += currentLetter;
                }
            }
            else{ //keep char less than n times
                if (letterCounts.get(currentCharacter) < n){
                    filLetters += currentLetter;
                }
            }
        }
        return filLetters ;
    }


    public void numberLengthsInSubstring(int startPosition, int endPosition) throws IllegalArgumentException, MyIndexOutOfBoundsException{
        if (string == null){
            throw new MyIndexOutOfBoundsException();
        }
        if (string.length() < endPosition && 1 <= startPosition && startPosition<= endPosition){
            throw new MyIndexOutOfBoundsException();
        }
        if (startPosition < 1 || startPosition > endPosition){
            throw new IllegalArgumentException();
        }
        String startString = string.substring(0, startPosition -1);
        String midString = string.substring(startPosition -1, endPosition);
        String endString = string.substring(endPosition);
        int len = midString.length();

        //iterate over substring to replace number
        String replaceString = "";
        int numCount = 0;
        for (int i=0; i<len; i++) {
            if (Character.isDigit(midString.charAt(i))){
                numCount ++;
            }
            else{
                if (numCount > 0){
                    replaceString += String.valueOf(numCount); //add replaced length, need convert to string
                }
                replaceString += String.valueOf(midString.charAt(i));
                numCount = 0;
            }

        }
        //add last digit
        if (numCount > 0){
            replaceString += String.valueOf(numCount);
        }/*
        else{
            replaceString += String.valueOf(midString.charAt(len));
        }*/

        //result strings before start point + replaced substring + string after end point
        String resultLetters = startString + replaceString + endString;
        string = new String(resultLetters);
        //return resultLetters;

    }

}