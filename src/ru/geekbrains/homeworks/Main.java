package ru.geekbrains.homeworks;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("output.txt");
        FileReader fr = new FileReader("input.txt");
        Scanner scanner = new Scanner(fr);

        List<Integer> arr = new ArrayList<>();
        int i = 0;

        while (i < 10) {
            arr.add(Integer.parseInt(scanner.next()));
            i++;
        }

        int value = Integer.parseInt(scanner.next());
        List<Integer> arrays = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.isEmpty()) {
                String [] timeArr = line.split(" ");
                List<String> timeArr2;
                timeArr2 = Arrays.asList(timeArr);
                if (!arrays.isEmpty()) {
                    arrays.removeAll(arrays);
                }
                for (int q = 0; q < timeArr2.size(); q++) {
                    arrays.add(Integer.parseInt(timeArr2.get(q)));
                }
                if (checkLuck(arr, arrays)) {
                    fw.write("Lucky");
                    fw.append("\n");
                } else {
                    fw.write("Unlucky");
                    fw.append("\n");
                }
            }

        }
        fr.close();
        fw.close();
    }
    public static boolean checkLuck(List<Integer> arr, List<Integer> arrays){
        boolean b = false;
        int a = 0;
        for (int i = 0; i<arr.size(); i++){
            if(arrays.contains(arr.get(i))){
                a++;
            }
        }
        if (a >=3){
            b = true;
        }
        return b;
    }
}

