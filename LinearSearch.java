import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    int entries[] = {32, 14, 89, 62, 10, 20, 88, 40, 22,  91, 88, 65};
    Scanner userInput = new Scanner(System.in);

     
    System.out.println("Enter number! ");
    int num = userInput.nextInt();

    System.out.println(linearSearch(entries, num ));

  }

  public static int linearSearch (int values[], int key  ) {
    for (int i=0; i < values.length; i++ ) {
      if(values [i] == key ) {
        return i;
      }
    }

    return -1;

  }  
   
}