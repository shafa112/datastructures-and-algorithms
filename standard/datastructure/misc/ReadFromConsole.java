package datastructure.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromConsole {

    public static void main(String[] args) throws IOException {
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        // Reading data using readLine
        String name = reader.readLine();

        String[] strArray = null;
        strArray = name.split(" ");
        //printing the converted string array
        for (int i = 0; i< strArray.length; i++){
            System.out.println(strArray[i]);
        }

        // Printing the read line
        System.out.println(name);
    }
}
