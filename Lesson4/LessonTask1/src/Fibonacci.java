import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		System.out.println("PROGRAM OBLICZAJACY N-TY WYRAZ CIAGU FIBONACCIEGO");
		System.out.println();

		int a = 0;
		int b = 1;

		Scanner scrInt = new Scanner(System.in);

		System.out.print("Podaj wartosc n: ");
		int n = scrInt.nextInt();

		if (n == 0) {
			System.out.println("0");
		} else if (n == 1) {
			System.out.println("0, 1");
		} else {
			System.out.println("0, 1");
			for (int i = 2; i < n; i++) {
				b = a + b;
				a = b - a;
				System.out.println(b);
			}
		}
	}

}

// (0,1)
// b = 1; a = 1;
// b = 2; a = 1;
// b =3;  a =2;
