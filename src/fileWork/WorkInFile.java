package fileWork;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.System.out;

public class WorkInFile {
    public static void write(String fileName, String text) {
        File file = new File(fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter out = new FileWriter(file); // file.getAbsoluteFile()
            StringTokenizer stringTokenizer = new StringTokenizer(text, "\n");
            while (stringTokenizer.hasMoreTokens()) {
                out.write(stringTokenizer.nextToken() + "\n");
            }
            out.close();
        } catch (IOException e) {
            System.out.println("Can't create new file.");
        }
    }

    private static void isExists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }

    public static String read(String fileName) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        isExists(fileName);
        Scanner sc = new Scanner(new File(fileName));
        while (sc.hasNextLine()) {
            sb.append(sc.nextLine() + "\n");
        }
        return sb.toString();
    }
}
