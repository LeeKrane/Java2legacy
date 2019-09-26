import java.util.Scanner;

public class Labor1_3 {
  public static void main (String [] args) {
    System.out.println("Zahl 1 --> ");
    Scanner scana = new Scanner(System.in);
    int z1 = scana.nextInt();
    System.out.println("Zahl 2 --> ");
    Scanner scanb = new Scanner(System.in);
    int z2 = scanb.nextInt();
    int z3 = z1+z2;
    System.out.println(z1 + " + " + z2 + " = " + z3);
  }
}