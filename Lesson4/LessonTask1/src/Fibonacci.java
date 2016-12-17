import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		System.out.println("PROGRAM OBLICZAJACY N-TY WYRAZ CIAGU FIBONACCIEGO");
		System.out.println();

		int previuosNumber = -1;
		int result = 1;

		Scanner scrInt = new Scanner(System.in);

		System.out.print("Podaj wartosc n: ");
		int n = scrInt.nextInt();

		for (int i = 0; i < n; i++) {
			int sum = previuosNumber + result;
			previuosNumber = result;
			result = sum;
			System.out.print(sum + ", ");

		}

		// 1 -> previous(-1) + result(1) = 0
		// 2 -> 0 + result(1) = 1
		// 3 -> 0 + 1 = 1
		// 4 -> 1 + 1 = 2
		// 5 -> 1 + 2 = 3
		// 6 -> 2 + 3 = 5
		// 7 -> 3 + 5 = 8
		// 8 -> 5 + 8 = 13

	}

}
