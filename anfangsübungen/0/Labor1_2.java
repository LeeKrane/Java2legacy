import java.util.Scanner;

public class Labor1_2 {
  public static void main (String [] args) {
    System.out.println("Geben Sie Ihren Vornamen ein --> ");
    Scanner scan = new Scanner(System.in);
    String vName = scan.nextLine();
    System.out.println("Hallo, " + vName);
  }
}