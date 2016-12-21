import java.util.Random;
import java.util.Scanner;

public class Wielokat {

	public static void main(String[] args) {

		System.out.println("PROGRAM LICZACY OBWOD WIELOKATA.");
		System.out.println();

		int[] numberOfsides = new int[8];
		int sum = 0;

		Scanner scInt = new Scanner(System.in);
		Random generator = new Random();

		if (numberOfsides.length < 3) {

			System.out.println("Ilosc katow w wielokacie jest nieprawidlowa.");
			System.out.println("Zdefiniuj ilosc katow jeszcze raz !");

		} else {

			System.out.println("Liczba katow w Twoim wielokacie to: " + numberOfsides.length);
			System.out.println();

			if (numberOfsides.length <= 7) {

				for (int i = 0; i < numberOfsides.length; i++) {
					System.out.println("Podaj dlugosc boku: ");
					numberOfsides[i] = scInt.nextInt();
					sum = sum + numberOfsides[i];
				}

			} else {

				System.out.println("Wylosowane liczby reprezentujace boki wielokata :");
				int[] tableOfRandom = new int[numberOfsides.length];
				for (int i = 0; i < tableOfRandom.length; i++) {
					int result = generator.nextInt(13);
					System.out.print(" " + result);
					tableOfRandom[i] = result;
					sum = sum + tableOfRandom[i];
				}

			}

		}
		System.out.println();
		System.out.println("Obwod wielokata : " + sum);

	}

}
