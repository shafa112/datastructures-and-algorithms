package filereadwrite;

import java.io.*;

public class FileOperations {

    public static void main(String[] args) throws IOException {
        //String filePath = "/Users/shafahassan/study/datastructures-and-algorithms/practice/filereadwrite/testfile";
        String filePath = "./practice/filereadwrite/testfile";
/*        Reader reader = new FileReader(filePath);
        BufferedReader bfr = new BufferedReader(reader);*/
        BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath))));
        String line;
        while((line = bfr.readLine()) != null) {
            System.out.println(line);
        }
    }
}
