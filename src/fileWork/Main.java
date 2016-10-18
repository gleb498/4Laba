package fileWork;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
       try {
            String name = new String("D:\\newJavaFile.java");
            WorkInFile.write(name, EditText.delete(WorkInFile.read("D:\\Java Projects\\4Laba\\example.java")));
        } catch (FileNotFoundException e){
            System.out.println("NO FILE!!!");
        }
    }
}
