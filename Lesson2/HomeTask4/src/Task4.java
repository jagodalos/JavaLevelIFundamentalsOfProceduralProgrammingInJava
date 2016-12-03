import java.util.Scanner;

public class Task4 {

	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		int c;

		// try {
		// if ( a >= 500 || b >= 500) {
		// }
		// }catch (Exception exc){
		// System.out.println("Please enter a number less than 500. ");
		// }

		Scanner scr = new Scanner(System.in);
		System.out.println("Enter number a: ");
		a = scr.nextInt();
		System.out.println("Enter number b: ");
		b = scr.nextInt();
		if (a >= 500 || b >= 500) {
			System.out.println("Please enter a number less than 500. ");
		} else {
			System.out.println("Your numbers : " + a + ", " + b + ".");
		}

		c = a * a + b * b;

		System.out.println("\nHypotenuse is equal " + c + ".");

	}

}
