package ru.geekbrains.homeworks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Servers {
    public static void main(String[] args) throws IOException {
       // FileWriter fileWriter = new FileWriter("output.txt");
        FileReader fileReader = new FileReader("input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line1 = bufferedReader.readLine();
        String line2 = bufferedReader.readLine();


        int number = Integer.parseInt(line1);

        String[] lineArray2 = line2.split(" ");
        List<String> serversLine = Arrays.asList(lineArray2);
        List<Integer> servers = new ArrayList<>();
        for (int j = 0; j < serversLine.size(); j++) {
            servers.add(Integer.parseInt(serversLine.get(j)));
        }


        int newServerValues = 0;
        List<Integer> serverValuesList = new ArrayList<>();
        serverValuesList.add(0);

        for (int numberFor = 2; numberFor<=number-1;numberFor++) {
            for (int i = 0; i < numberFor-1; i++) {
                int elementCompare = servers.get(i);
                for (int e = i + 1; e < numberFor; e++) {
                    if (elementCompare > servers.get(e)) {
                        int elementE = servers.get(e);
                        servers.set(i, elementE);
                        servers.set(e, elementCompare);
                        newServerValues += elementCompare;
                    }
                }
            }
            serverValuesList.add(newServerValues);
                int elementCompare2 = servers.get(number-1);
                for (int e = number - 2; e >= 1; e--) {
                    if (elementCompare2 < servers.get(e)) {
                        int elementE = servers.get(e);
                        servers.set(numberFor, elementE);
                        servers.set(e, elementCompare2);
                        newServerValues += elementE;
                    }
                }
        }
        serverValuesList.add(newServerValues);

       // StringBuilder result = new StringBuilder();
        //Iterator<Integer> iter = serverValuesList.iterator();
        //while (iter.hasNext()){
            //result.append(iter.next());
            //if (iter.hasNext()){
              //  result.append(" ");
            //}
        for (int i = 0; i< serverValuesList.size(); i++) {
            if (i == 0){
                System.out.print(serverValuesList.get(0));
            } else {
                System.out.print(" " + serverValuesList.get(i));
            }
        }
        //fileWriter.write(result.toString());
        fileReader.close();
       // fileWriter.close();
        bufferedReader.close();
    }
}


