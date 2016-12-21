import java.util.Scanner;

public class PoleFigury {
	public static void main(String[] args) {

		System.out.println("OBLICZ POLE FIGURY");
		System.out.println();

		System.out.println("Wybierz dla jakiej figury chcesz obliczyc pole (cm).");
		System.out.println("1 - POLE KWADRATU");
		System.out.println("2 - POLE PROSTOKATA");
		System.out.println("3 - POLE KOLA");
		System.out.println("4 - POLE ROMBU");

		Scanner scrInt = new Scanner(System.in);
		int figureField = scrInt.nextInt();

		Scanner scrDouble = new Scanner(System.in);

		switch (figureField) {

		case 1:
			System.out.println("Podaj dlugosc boku a: ");
			int a = scrInt.nextInt();
			int fieldSquare = a * a;
			System.out.println("Pole kwadratu wynosi: " + fieldSquare + " cm.");
			break;

		case 2:
			System.out.println("Podaj dlugosc boku f: ");
			int f = scrInt.nextInt();
			System.out.println("Podaj dlugosc boku g: ");
			int g = scrInt.nextInt();
			int fieldRectangle = f * g;
			System.out.println("Pole kwadratu wynosi: " + fieldRectangle + " cm.");
			break;
		case 3:
			System.out.println("Podaj promien kola r: ");
			double r = scrDouble.nextDouble();
			final double PI = 3.14;
			double fieldCircle = r * r * 3.14;
			System.out.println("Pole kola wynosi: " + fieldCircle + " cm.");
			break;
		case 4:
			System.out.println("Podaj dlugosc boku i: ");
			int i = scrInt.nextInt();
			System.out.println("Podaj dlugosc wysokosci h: ");
			int h = scrInt.nextInt();
			int fieldRhombus = i * h;
			System.out.println("Pole rombu wynosi: " + fieldRhombus + " cm.");
			break;
		}

	}

}
