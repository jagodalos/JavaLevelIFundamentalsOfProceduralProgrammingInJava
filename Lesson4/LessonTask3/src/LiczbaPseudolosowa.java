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

		int result = generator.nextInt(31);
		int numberOfAttempts = 0;

		do {
			result = generator.nextInt(31);
			System.out.print(" " + result);
			numberOfAttempts++;
		} while (result != myNumbers);

		System.out.println();
		System.out.println();
		System.out.println("Potrzebowalismy " + numberOfAttempts + " prób do uzyskania Twojej liczby.");

	}
}
