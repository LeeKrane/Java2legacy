public class Labor2_1 {
  public static void main (String [] args) {
    String str = new String ("Java ist interessant");
    
    System.out.println("String --> " + str);
    System.out.println("Länge --> " + str.length());
    
    System.out.println("1. Zeichen: " + str.charAt(0));
    System.out.println("1. Zeichen: " + str.charAt(str.length()-1));
    
    System.out.println("Mittleres Wort --> " + str.substring(str.indexOf("i"), 8));
  }
}