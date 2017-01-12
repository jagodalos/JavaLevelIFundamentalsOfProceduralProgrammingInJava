import java.util.Scanner;

public class DziennikUcznia {

	static String schoolType = null, schoolSubject = "WF, Jezyk Polski, Matematyka", nameOfadditionalCourse;

	static Scanner scString = new Scanner(System.in);
	static Scanner scInt = new Scanner(System.in);

	public static void getAdditionalCourse() {
		System.out.println("Czy uczen uczeszcza na kola dodatkowe ?");
		System.out.println("TAK wybierz - 1");
		System.out.println("NIE wybierz - 2");
		int additionalCourse = scInt.nextInt();
		if (additionalCourse == 1) {
			System.out.println("Wprowadz nazwe kola dodatkowego:");
			nameOfadditionalCourse = scString.nextLine();
		} else {
			nameOfadditionalCourse = "brak";
		}
	}

	public static void printInfo(String classProfile, int schoolMenuNumber, String schoolName, String studentName) {

		System.out.println("Imie i nazwisko: " + studentName);
		System.out.println("Nazwa szkoly: " + schoolName);
		System.out.println("Poziom nauki: Szkola " + schoolType);
		System.out.println("Numer klasy: " + schoolMenuNumber);
		System.out.println("Profil klasy: " + classProfile);
		System.out.println("Przedmioty: " + schoolSubject);
		System.out.println("Dodatkowe kola naukowe: " + nameOfadditionalCourse);
	}

	public static void main(String[] args) {

		System.out.println("DZIENNICZEK UCZNIA");
		System.out.println();

		System.out.println("Podaj imie i nazwisko ucznia:");
		String studentName = scString.nextLine();

		System.out.println("Podaj nazwe szkoly:");
		String schoolName = scString.nextLine();

		System.out.println("Szkola podstawowa wybierz - 1");
		System.out.println("Szkola gimnazjalna wybierz - 2");
		int schoolMenuNumber = scInt.nextInt();

		switch (schoolMenuNumber) {

		case 1:
			System.out.println("Wybierz klase");
			int classNumberPrimary = scInt.nextInt();
			if (classNumberPrimary > 6) {
				System.out.println("Nie ma takiej klasy w szkole podstawowej !");
			} else {
				schoolType = "podstawowa";
				schoolMenuNumber = classNumberPrimary;
			}
			break;

		case 2:
			System.out.println("Wybierz klase");
			int classNumberSecondary = scInt.nextInt();
			if (classNumberSecondary > 3) {
				System.out.println("Nie ma takiej klasy w gimnazjum !");
			} else {
				schoolType = "gimnazjalna";
				schoolSubject += ", Fizyka i Chemia";
				schoolMenuNumber = classNumberSecondary;
			}
			break;

		default:
			System.out.println("Wprowadziles niepoprawny numer !");
			break;
		}

		System.out.println("Podaj profil klasy");
		String classProfile = scString.nextLine();

		DziennikUcznia.getAdditionalCourse();
		DziennikUcznia.printInfo(classProfile, schoolMenuNumber, schoolName, studentName);

	}
}
