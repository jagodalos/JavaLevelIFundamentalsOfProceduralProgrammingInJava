import java.util.Scanner;

public class DziennikUcznia {

	public static void main(String[] args) {

		System.out.println("DZIENNICZEK UCZNIA");
		System.out.println();

		String schoolType = null, schoolSubject = "WF, Jezyk Polski, Matematyka", nameOfadditionalCourse = null;

		Scanner scString = new Scanner(System.in);
		Scanner scInt = new Scanner(System.in);

		System.out.println("Podaj imie i nazwisko ucznia:");
		String studentName = scString.nextLine();

		System.out.println("Podaj nazwe szkoly:");
		String schoolName = scString.next();

		System.out.println("Szkola podstawowa wybierz - 1");
		System.out.println("Szkola gimnazjalna wybierz - 2");
		int schoolMenuNumber = scInt.nextInt();

		switch (schoolMenuNumber) {

		case 1:
			System.out.println("Wybierz klase");
			int classNumberPrimary = scInt.nextInt();
			if (classNumberPrimary > 6) {
				System.out.println("Nie ma takiej klasy w szkole podstawowej !");
			} else if (schoolMenuNumber == 1) {
				schoolType = "podstawowa";
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
				schoolType = "gimnazjalna";
				schoolSubject += ", Fizyka i Chemia";
			}
			break;

		default:
			System.out.println("Wprowadziles niepoprawny numer !");
			break;

		}

		System.out.println("Podaj profil klasy");
		String classProfile = scString.next();

		System.out.println("Czy uczen uczeszcza na kola dodatkowe ?");
		System.out.println("TAK wybierz - 1");
		System.out.println("NIE wybierz - 2");
		int additionalCourse = scInt.nextInt();

		if (additionalCourse == 1) {
			System.out.println("Wprowadz nazwe kola dodatkowego:");
			nameOfadditionalCourse = scString.next();
		} else if (additionalCourse == 2) {
			nameOfadditionalCourse = "brak";
		} else {
			System.out.println("Wprowadziles niepoprawny numer !");
		}

		System.out.println();

		System.out.println(
				"-------------------------------------------------------------------------------------------------------------");
		System.out.println("Imie i nazwisko: " + studentName);
		System.out.println("Nazwa szkoly: " + schoolName);
		System.out.println("Poziom nauki: Szkola " + schoolType);
		System.out.println("Numer klasy: " + schoolMenuNumber);
		System.out.println("Profil klasy: " + classProfile);
		System.out.println("Przedmioty: " + schoolSubject);
		System.out.println("Dodatkowe kola naukowe: " + nameOfadditionalCourse);
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------");
	}
}
