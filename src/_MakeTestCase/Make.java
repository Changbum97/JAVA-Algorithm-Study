package _MakeTestCase;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Make {
    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir") + "/src/_MakeTestCase/";
        PrintWriter pw = new PrintWriter(new FileWriter(path + "output.txt"));

        int n = 1000000;
        pw.println(n);
        for (int i = 0 ; i < n ; i ++) {
            pw.println(i);
        }

        pw.close();
    }
}
