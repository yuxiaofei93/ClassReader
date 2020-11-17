package nick.personal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {
        try {
            ClassInfo info = new ClassInfo();
            InputStream is = new FileInputStream("./input/Test.class");
            info.readFrom(is);
            info.print();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
