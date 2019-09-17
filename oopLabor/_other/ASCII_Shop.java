package school.chif2.oopLabor._other;// @author Kranabetter Christian

import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.Scanner;

public class ASCII_Shop {
    public static void main(String[] args) throws FileNotFoundException {  // psv
        Scanner sc = new Scanner(new File("bild2.ascii"));
        String line;
        int counter = 0, lenOld = 0, lenNew = 0;
        boolean wahrheitswert = TRUE;
        while(sc.hasNextLine()) {
            line = sc.nextLine();
            System.out.println(line);
            counter++;
            lenNew = line.length();
            if(lenNew == lenOld) {
                lenOld = lenNew;
            }else if(0 == lenOld) {
                lenOld = lenNew;
            }else{
                wahrheitswert = FALSE;
            }
        }
        if(wahrheitswert == TRUE) {
            System.out.println("ok " + lenOld + " " + counter);
        }else{
            System.out.println("fail");
        }
    }
}
