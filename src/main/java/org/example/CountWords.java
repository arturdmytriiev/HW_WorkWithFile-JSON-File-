package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CountWords {
    public static void counterWords(String FilePath)
    {
        Map<String, Integer> map = new HashMap<String, Integer>();
        File file = new File(FilePath);
        try(BufferedReader bR = new BufferedReader(new FileReader(file)))
        {
            while(bR.ready()) {
                String [] line = bR.readLine().split(" ");
                for(String word : line) {
                    boolean onlyLetters = word.matches("[a-zA-Z]+");
                    if(!word.equals("") && onlyLetters)
                    {
                        map.put(word, map.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        //Сортировка по ключу
        /*TreeMap<String,Integer> sorted  = new TreeMap<>(Collections.reverseOrder());
        sorted.putAll(map);*/
        List<Map.Entry<String, Integer>>list = new ArrayList<>(map.entrySet());
        list.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        for(Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }

    public static void main(String[] args) {
        counterWords("src/words.txt");
    }
}
