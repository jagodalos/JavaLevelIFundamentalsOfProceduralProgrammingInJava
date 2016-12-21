import java.util.Scanner;

public class Odwrotnosc {
	
	public static void main(String[] args) {
		
		System.out.println("PROGRAM WCZYTUJE 10 LICZ I WYSWIETLA JE W ODWROTNEJ KOLEJNOSCI");
		System.out.println();

		Scanner scrInt = new Scanner(System.in);

		int[] tableOfNumbers = new int[10];

		for (int i = 0; i < tableOfNumbers.length; i++) {
			tableOfNumbers[i] = scrInt.nextInt();
		}
		System.out.println("\nLiczby wyswietlane w odwrotnej kolejnosci: ");
		System.out.println();

		for (int j = tableOfNumbers.length - 1; j >= 0; j--) {

			System.out.println(" " + tableOfNumbers[j]);
		}

	}
}
