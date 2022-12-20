package cinema_jetbrains;

import java.util.Scanner;

public class Solutions {

	 public void printIsNull(Object o) {
	     if(o == null) {
	    	 System.out.println("It's null");
	     }else {
	    	 System.out.println("It's an object");
	     }
	 }
}

class Main {
    public static void main(String[] args) {
        Solutions solution = new Solutions();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            Object obj = "null".equals(scanner.nextLine()) ? null : new Object();
            solution.printIsNull(obj);
        }
    }
}
