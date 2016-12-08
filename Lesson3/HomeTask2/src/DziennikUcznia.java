import java.util.Scanner;

public class DziennikUcznia {

	public static void main(String[] args) {

		System.out.println("DZIENNICZEK UCZNIA");
		System.out.println();

		String schoolType, schoolSubject;

		Scanner scString = new Scanner(System.in);

		System.out.println("Podaj imie i nazwisko ucznia:");
		String studentName = scString.nextLine();

		System.out.println("Podaj nazwe szkoly:");
		String schoolName = scString.next();

		System.out.println("Szkola podstawowa wybierz - 1");
		System.out.println("Szkola gimnazjalna wybierz - 2");

		Scanner scInt = new Scanner(System.in);
		int schoolMenuNumber = scInt.nextInt();

		switch (schoolMenuNumber) {

		case 1:
			System.out.println("Wybierz klase");
			int classNumberPrimary = scInt.nextInt();
			if (classNumberPrimary > 6) {
				System.out.println("Nie ma takiej klasy w szkole podstawowej !");
			} else {
				System.out.println("Wybrales klase nr: " + classNumberPrimary);

			}
			break;
		case 2:
			System.out.println("Wybierz klase");
			int classNumberSecondary = scInt.nextInt();
			if (classNumberSecondary > 3) {
				System.out.println("Nie ma takiej klasy w gimnazjum !");
			} else {
				System.out.println("Wybrales klase nr: " + classNumberSecondary);
			}
			break;

		default:
			System.out.println("Wprowadziles niepoprawny numer !");
			break;

		}

		if (schoolMenuNumber == 1) {
			schoolType = "podstawowa";
			schoolSubject = "WF, Jezyk Polski, Matematyka";
		} else {
			schoolType = "gimnazjalna";
			schoolSubject = "Fizyka i Chemia";
		}

		System.out.println("Podaj profil klasy");
		String classProfile = scString.next();

		System.out.println("Dodatkowe kola naukowe");
		String additionalCourse = scString.next();

		System.out.println();

		System.out.println(
				"-------------------------------------------------------------------------------------------------------------");
		System.out.println("Imie i nazwisko: " + studentName);
		System.out.println("Nazwa szkoly: " + schoolName);
		System.out.println("Poziom nauki: Szkola " + schoolType);
		System.out.println("Numer klasy: " + schoolMenuNumber);
		System.out.println("Profil klasy: " + classProfile);
		System.out.println("Przedmioty: " + schoolSubject);
		System.out.println("Dodatkowe kola naukowe: " + additionalCourse);
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------");
	}
}
