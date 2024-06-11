package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Json {
    static List<User> users = new ArrayList<>();
    public static  void JsonConvert(String FilePath)
    {
        File file = new File(FilePath);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        int counter = 0;
        if(file.exists())
        {
            try(FileInputStream fIs = new FileInputStream(file))
            {
                Scanner scanner = new Scanner(fIs);
                while(scanner.hasNext()) {
                    String[] tokens = scanner.nextLine().split(" ");
                    if (counter > 0) {
                        String name = tokens[0];
                        int age = Integer.parseInt(tokens[1]);
                        users.add(new User(name , age));
                    }
                    counter++;
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            try(FileWriter fW = new FileWriter("User.json"))
            {
                gson.toJson(users, fW);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            String line = gson.toJson(users);
            System.out.println(line);

        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        JsonConvert("src/text2.txt");
    }
}

