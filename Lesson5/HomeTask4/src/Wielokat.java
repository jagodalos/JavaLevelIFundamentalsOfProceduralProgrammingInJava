import java.util.Random;
import java.util.Scanner;

public class Wielokat {

	int[] borders;
	final public static int BORDER_COUNT = 8;

	public Wielokat(int[] borders) {
		this.borders = borders;
	}

	public int getCircuit() {
		int sum = 0;
		for (int number : borders)
			sum += number;
		return sum;
	}

	public static void main(String[] args) {

		System.out.println("PROGRAM LICZACY OBWOD WIELOKATA.");
		System.out.println();

		int[] borders = new int[Wielokat.BORDER_COUNT];
		Scanner scInt = new Scanner(System.in);
		Random generator = new Random();
		Wielokat wielokat = null;

		if (borders.length < 3) {
			System.out.println("Ilosc katow w wielokacie jest nieprawidlowa.");
			System.out.println("Zdefiniuj ilosc katow jeszcze raz !");
		} else {
			System.out.println("Liczba katow w Twoim wielokacie to: " + borders.length);
			System.out.println();

			if (borders.length <= 7) {
				for (int i = 0; i < borders.length; i++) {
					System.out.println("Podaj dlugosc boku: ");
					borders[i] = scInt.nextInt();
				}
				wielokat = new Wielokat(borders);
			} else {
				System.out.println("Wylosowane liczby reprezentujace boki wielokata :");
				int[] tableOfRandom = new int[Wielokat.BORDER_COUNT];
				for (int i = 0; i < tableOfRandom.length; i++) {
					int result = generator.nextInt(13);
					System.out.print(" " + result);
					tableOfRandom[i] = result;
				}
				wielokat = new Wielokat(tableOfRandom);
			}
		}
		System.out.println();
		System.out.println("Obwod wielokata : " + wielokat.getCircuit());
	}
}
