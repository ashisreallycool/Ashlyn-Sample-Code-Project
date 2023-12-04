import java.util.Scanner;


class Main {
  public static void main(String[] args) {
    int[] values = { 32, 14, 89, 62, 10, 20, 80, 40, 22, 91, 88, 65 };
    Scanner userInput = new Scanner(System.in);

    selectionSort(values);

    for (int i = 0; i < values.length; i++) {
      System.out.println(values[i] + " ");
    }
    System.out.println("\n");

    System.out.println("Enter number! ");
    int num = userInput.nextInt();

    System.out.println(binarySearch(values, num));
  }

  public static void selectionSort(int values[]) {
    int arrlen = values.length;
    for (int i = 0; i < arrlen - 1; i++) {
      int smallest = i;

      for (int j = i + 1; j < arrlen; j++) {
        if (values[j] < values[smallest]) {
          smallest = j;
        }
      }
      int temp = values[smallest];
      values[smallest] = values[i];
      values[i] = temp;

    }
  }

  public static String binarySearch(int values[], int x) {
    int low = 0;
    int high = values.length - 1;

    while (low <= high) {
      int midpoint = (low + high) / 2;

      if (values[midpoint] == x) {
        return "Found it";
      } else if (values[midpoint] > x) {
        high = midpoint - 1;
      } else if (values[midpoint] < x) {
        low = midpoint + 1;
      }

      // System.out.println(midpoint + " " + values[midpoint] );
    }
    return "Not found";
  }
}