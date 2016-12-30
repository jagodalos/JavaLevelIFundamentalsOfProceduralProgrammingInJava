import java.util.Random;
import java.util.Scanner;

public class LiczbaPseudolosowa {

	private int min;
	private int max;

	private Scanner scInt = new Scanner(System.in);
	private Random generator = new Random();

	public LiczbaPseudolosowa(int min, int max) {
		this.min = min;
		this.max = max;
	}

	public int getNumberFromUser() {
		System.out.println(String.format("Podaj liczbe calkowita z zakresu od %d do %d", min, max));
		int myNumber = scInt.nextInt();
		return myNumber;
	}

	public boolean validate(int number) {
		if (number > max) {
			System.out.println("Wprowadziles niepoprawna liczbe");
			return false;
		} else {
			System.out.println("Twoja liczba to: " + number + ".");
			return true;
		}
	}

	public int getNextRandom(boolean print) {
		int random = generator.nextInt(max);
		if (print == true) {
			System.out.println(
					String.format("Wylosowana liczba calkowita z zakresu od %d do %d to %d", min, max, random));
		}
		return random;
	}

	public static void main(String[] args) {
		System.out.println("PROGRAM LOSOWANIE LICZB.");
		System.out.println();

		LiczbaPseudolosowa liczbaPseudolosowa = new LiczbaPseudolosowa(1, 12);
		int userNumber = liczbaPseudolosowa.getNumberFromUser();
		liczbaPseudolosowa.validate(userNumber);

		int numberOfAttempts = 0;
		int guessNumber;
		do {
			guessNumber = liczbaPseudolosowa.getNextRandom(true);
			numberOfAttempts++;
		} while (guessNumber != userNumber);

		System.out.println();
		System.out.println("Potrzebowalismy " + numberOfAttempts + " prób do uzyskania Twojej liczby.");

	}
}
