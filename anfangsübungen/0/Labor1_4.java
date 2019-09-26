import java.util.Scanner;

public class Labor1_4 {
  public static void main (String [] args) {
    System.out.println("Temperatur in Fahrenheit --> ");
    Scanner scan = new Scanner(System.in);
    double tempF = scan.nextDouble();
    //double tempC = (tempF - 32) / 1.8 ;
    //System.out.println(tempC);
    System.out.println((tempF - 32) / 1.8);
  }
}