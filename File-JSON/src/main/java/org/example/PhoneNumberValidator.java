package org.example;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

class PhoneNumberValidator {

    public static void phoneNumberValidator(String FilePath) throws FileNotFoundException {
        File file = new File(FilePath);
        if(!file.exists())
        {
            throw new FileNotFoundException();
        }
        Pattern pattern = Pattern.compile("^\\(\\d{3}\\) \\d{3}-\\d{4}$");
        Pattern pattern1 = Pattern.compile("^\\d{3}-\\d{3}-\\d{4}$");
        try(FileInputStream fileInputStream = new FileInputStream(file))
        {
        Scanner scanner = new Scanner(fileInputStream);
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            if (pattern.matcher(line).matches() || pattern1.matcher(line).matches()) {
                System.out.println(line);
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) throws FileNotFoundException {
        phoneNumberValidator("src/text1.txt");
    }
}

