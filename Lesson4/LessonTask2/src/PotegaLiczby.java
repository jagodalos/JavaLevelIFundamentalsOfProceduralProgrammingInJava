import java.util.Scanner;

public class PotegaLiczby {

	public static void main(String[] args) {

		System.out.println("PROGRAM WYZNACZAJACY POTEGE LICZBY CALKOWITEJ");
		System.out.println();

		Scanner scInt = new Scanner(System.in);
		Scanner scDouble = new Scanner(System.in);

		System.out.println("Podaj podstawe potegi");
		int base = scInt.nextInt();

		System.out.println("Podaj wykladnik potegi");
		int power = scInt.nextInt();

		int result = 0;
		result = base;

		for (int i = 1; i < power; i++) {
			result = result * base;
		}
		System.out.println("Liczba " + base + " podniesiona do potegi " + power + " jest rowna " + result + ".");

		System.out.println("Podaj liczbe calkowita a");
		double a = scDouble.nextDouble();

		System.out.println("Podaj liczbe calkowita b");
		double b = scDouble.nextDouble();

		int powerFunction = (int) Math.pow(a, b);

		System.out.println(powerFunction);

	}

}
