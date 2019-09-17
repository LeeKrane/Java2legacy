package school.chif2.linkedListsOLD.lLs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Zoechling Amelie
 */
public class Auszählreim {

    public static void main(String[] args) throws FileNotFoundException {

        int n = 0;
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(new File("kids.txt"));
        while (sc.hasNextLine()) {
            list.add(sc.nextLine());
        }

        System.out.println(list);
        
        sc = new Scanner(System.in);
        try {
            System.out.print("Anzahl der Silben --> ");
            n = sc.nextInt();
        }catch(InputMismatchException exception) {
            System.out.println("Falsche Eingabe! Versuchen Sie es erneut!");
            System.exit(0);
        }

        System.out.println(list.erschiessungsKommando(n) + " ist der einzige Überlebende!");
    }
}
