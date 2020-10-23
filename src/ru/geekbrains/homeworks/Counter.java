package ru.geekbrains.homeworks;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Counter {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("input.txt");
       // FileWriter fileWriter = new FileWriter("output.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line1 = bufferedReader.readLine();
        String line2 = bufferedReader.readLine();
        String [] lineAsArray1 = line1.split(" ");
        String [] lineAsArray2 =line2.split(" ");
        List<Integer> nkr = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        for (String s : lineAsArray1) {
            nkr.add(Integer.parseInt(s));
        }
        for (String s : lineAsArray2) {
            a.add(Integer.parseInt(s));
        }
        int k = nkr.get(1);
        int r = nkr.get(2);
        List<Integer> aDoCounter;
        aDoCounter = searchMinValues(a,k);
        List<Integer> resultCounter;
        resultCounter = counter(aDoCounter,a,r,k);
       /* StringBuilder resultOfProgram  = new StringBuilder();
        Iterator<Integer> iter = resultCounter.iterator();
        while(iter.hasNext())
        {
            resultOfProgram.append(iter.next());
            if(iter.hasNext()){
                resultOfProgram.append(" ");
            }
        }*/
        for (int i = 0; i< resultCounter.size(); i++) {
            if (i == 0){
                System.out.print(resultCounter.get(0));
            } else {
                System.out.print(" " + resultCounter.get(i));
            }
        }
        //fileWriter.write(resultOfProgram.toString());
        fileReader.close();
        //fileWriter.close();
        bufferedReader.close();
        }

        public static List<Integer> searchMinValues (List<Integer> a, int k){
           List<Integer>minValues = new ArrayList<>();
           List<Integer>aCopy = new ArrayList<>(a);
        for (int i = 0; i<k; i++){
            minValues.add(Collections.min(a));
            a.remove(Collections.min(a));
        }
            if (!a.isEmpty()) {
                    a.removeAll(a);
            }
            a.addAll(aCopy);
            return minValues;
        }
        public static List<Integer> counter (List<Integer> aDoCounter, List<Integer> a, int r, int k) {
            a.set(0, aDoCounterSum(aDoCounter));
            Collections.sort(a);
            for (int i = 0; i < r - 1; i++) {
                a.set(0, aDoCounterSum(searchMinValues(a,k)));
                Collections.sort(a);
            }
            return a;
        }
        public static int aDoCounterSum (List<Integer> aDoCounter){
        int sum = 0;
            for (Integer integer : aDoCounter) {
                sum += integer;
            }
        return sum;
        }

}

