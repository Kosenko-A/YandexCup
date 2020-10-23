package ru.geekbrains.homeworks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Robot {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("input.txt");
       // FileWriter fw = new FileWriter("output.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        int result = 0;
        int upperLetter = 0;
        int lineLength = line.length();
            for (int i = 0; i<lineLength; i++){
                if (Character.isUpperCase(line.charAt(i))){
                    upperLetter++;
                }
            }
            if (lineLength -1 == upperLetter){
                result = lineLength +2;
            } else {
                result = lineLength + upperLetter;
            }
            System.out.println(result);
            //String res = Integer.toString(result);
            //fw.write(res);
            fr.close();
            //fw.close();
            br.close();
    }

}
