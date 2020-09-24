package ru.geekbrains.homeworks;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("output.txt");
        FileReader fr = new FileReader(("input.txt"), Charset.defaultCharset());
        Scanner scanner = new Scanner(fr);

        List <Integer> arr = new ArrayList<>();
        int i = 0;

        while (i<10){
            arr.add(Integer.parseInt(scanner.next()));
            i++;
        }

        int value  = Integer.parseInt(scanner.next());
        i = 0;
        List <Integer> arrays = new ArrayList<>();
        for (int n = 0; n<= value; n++) {
            while (i < 6) {
                arrays.add(Integer.parseInt(scanner.next()));
                i++;
            }
            System.out.println(arrays);
            if (checkLuck(arr, arrays)) {
                System.out.println("Lucky");
            } else {
                System.out.println("Unlucky");
            }
        }


        System.out.println(arr);
        System.out.println(value);
        fr.close();
    }
    public static boolean checkLuck(List<Integer> arr, List<Integer> arrays){
        boolean b = false;
        for (int i = 0; i<arr.size(); i++){
            int a = 0;
            if(arrays.contains(arr.get(i))){
                a++;
            }
            if (a >=3 ){
                b = true;
            }
        }
        return b;
    }
}
