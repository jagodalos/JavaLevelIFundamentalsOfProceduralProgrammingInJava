import java.util.Random;
import java.util.Scanner;

public class Wielokat {

	public static void main(String[] args) {

		System.out.println("PROGRAM LICZACY OBWOD WIELOKATA.");
		System.out.println();

		int numberOfAngles = 3;
		int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0;

		if (numberOfAngles < 3) {

			System.out.println("Ilosc katow w wielokacie jest nieprawidlowa.");
			System.out.println("Zdefiniuj ilosc katow jeszcze raz");
 
		}
		System.out.println("Liczba katow w Twoim wielokacie to: " + numberOfAngles);
		System.out.println();

		Scanner scInt = new Scanner(System.in);

		if (numberOfAngles == 3) {
			for (int i = 2; i < numberOfAngles; i++) {
				System.out.println("Podaj bok a");
				a = scInt.nextInt();
				System.out.println("Podaj bok b");
				b = scInt.nextInt();
				System.out.println("Podaj bok c");
				c = scInt.nextInt();
			}
			System.out.println("Obwod wielokata : " + (a + b + c));

		} else if (numberOfAngles == 4) {
			for (int i = 3; i < numberOfAngles; i++) {
				System.out.println("Podaj bok a");
				a = scInt.nextInt();
				System.out.println("Podaj bok b");
				b = scInt.nextInt();
				System.out.println("Podaj bok c");
				c = scInt.nextInt();
				System.out.println("Podaj bok d");
				d = scInt.nextInt();
			}
			System.out.println("Obwod wielokata : " + (a + b + c + d));

		} else if (numberOfAngles == 5) {
			for (int i = 4; i < numberOfAngles; i++) {
				System.out.println("Podaj bok a");
				a = scInt.nextInt();
				System.out.println("Podaj bok b");
				b = scInt.nextInt();
				System.out.println("Podaj bok c");
				c = scInt.nextInt();
				System.out.println("Podaj bok d");
				d = scInt.nextInt();
				System.out.println("Podaj bok e");
				e = scInt.nextInt();
			}
			System.out.println("Obwod wielokata : " + (a + b + c + d + e));

		} else if (numberOfAngles == 6) {
			for (int i = 5; i < numberOfAngles; i++) {
				System.out.println("Podaj bok a");
				a = scInt.nextInt();
				System.out.println("Podaj bok b");
				b = scInt.nextInt();
				System.out.println("Podaj bok c");
				c = scInt.nextInt();
				System.out.println("Podaj bok d");
				d = scInt.nextInt();
				System.out.println("Podaj bok e");
				e = scInt.nextInt();
				System.out.println("Podaj bok f");
				f = scInt.nextInt();
			}
			System.out.println("Obwod wielokata : " + (a + b + c + d + f));
		}

		else {
			Random generator = new Random();
			System.out.println("Wylosowane liczby: ");
			int[] table = new int[numberOfAngles];
			for (int i = 0; i < numberOfAngles; i++) {
				int result = generator.nextInt(13);
				table[i] = result;
				System.out.print(" " + result);
			}

			int sum = 0;
			for (int i : table) {
				sum = sum + i;

			}
			System.out.println();
			System.out.println("Obwod wielokata : " + sum);

		}

	}
}
