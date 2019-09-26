public class Labor2_2 {
  public static void main (String [] args) {
    String str = new String ("This is the Mississippi River");
    
    int j = System.out.println("Erster Index    --> " + str.indexOf("s"));
    for(int i = 0; i<j; i++){
      System.out.println("Nächster Index  --> " + str.indexOf("s", i));
    
    }
  }
}