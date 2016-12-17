import java.util.Random;
import java.util.Scanner;

public class LiczbaPseudolosowa {

	public static void main(String[] args) {

		System.out.println("PROGRAM LOSOWANIE LICZB.");
		System.out.println();

		Scanner scInt = new Scanner(System.in);
		Random generator = new Random();

		System.out.println("Podaj liczbe calkowita z zakresu od 1 do 30.");
		int myNumbers = scInt.nextInt();

		if (myNumbers > 30) {
			System.out.println("Wprowadziles niepoprawna liczbe");
		} else {
			System.out.println("Twoja liczba to: " + myNumbers + ".");
		}
		System.out.println();

		System.out.println("Wylosowana liczba calkowita z zakresu 1-30 to : " + generator.nextInt(31));
		System.out.println();

		// System.out.println("Kolejne wyniki losowan: ");
		// for (int i = 0; i < 10; i++){
		// System.out.print(generator.nextInt(31) + " ");
		// }

		int result = generator.nextInt(31);
		int numberOfAttempts = 0;

		while (result != myNumbers) {
			result = generator.nextInt(31) + 1;
			System.out.print(" " + result);
			numberOfAttempts++;

		}
		System.out.println();
		System.out.println();
		System.out.println("Potrzebowalismy " + numberOfAttempts + " prób do uzyskania Twojej liczby.");

	}
}
