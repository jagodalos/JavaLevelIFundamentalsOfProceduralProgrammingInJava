import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("KALKULATOR");
		System.out.println();

		Scanner scrInt = new Scanner(System.in);
		Scanner scrString = new Scanner(System.in);
		
		System.out.println("Prosze wprowadzic pierwsza liczbe calkowita :");
		int a = scrInt.nextInt();

		System.out.println("Prosze wprowadzic druga liczbe calkowita");
		int b = scrInt.nextInt();

		System.out.println(
				"Prosze podaj znak '+', '-', '*', '/' w zaleznosci jaka operacje chcesz przeprowadzic na swoich liczbach");

		String operator = scrString.next(); // operator arytmetyczny oznaczajcy wybor dzialania
		

		switch (operator) {

		case "+":
			System.out.println("Wybrales dodawanie.");
			System.out.println(a + " + " + b + " = " + (a + b));
			break;
		case "-":
			System.out.println("Wybrales odejmowanie.");
			System.out.println(a + " - " + b + " = " + (a - b));
			break;
		case "*":
			System.out.println("Wybrales mnozenie.");
			System.out.println(a + " * " + b + " = " + (a * b));
			break;
		case "/":
			System.out.println("Wybrales dzielenie.");
			System.out.println(a + " / " + b + " = " + (a / b));
			break;
		
		default:
			System.out.println("Podany znak nie jest poprawny");
			break;

		}

	}

}
