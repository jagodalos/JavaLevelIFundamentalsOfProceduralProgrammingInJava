import java.util.Random;
import java.util.Scanner;

public class SredniaUcznia {

	static public double calculateAverage(int[] grades) {
		double sum = 0;
		for (int grade : grades) {
			sum += grade;
		}
		double average = sum / grades.length;
		return average;
	}

	static public double getMax(int[] grades) {
		int max = grades[0];
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] > max) {
				max = grades[i];
			}
		}
		return max;
	}

	static public double getMin(int[] grades) {
		int min = grades[0];
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] < min) {
				min = grades[i];
			}
		}
		return min;
	}

	static public void printInfo(int[] grades) {
		double min = SredniaUcznia.getMin(grades);
		System.out.println("Srednia ocen : " + SredniaUcznia.calculateAverage(grades));
		System.out.println("Najwyzsza ocena :" + SredniaUcznia.getMax(grades));
		System.out.println("Najnizsza ocena :" + min);
		if (min == 1) {
			System.out.println("Uczen jest zagrozony");
		}

	}

	public static void main(String[] args) {

		System.out.println("PROGRAM SREDNIA KONCOWA UCZNIA");
		System.out.println();
		int[] primarySchoolGrades = new int[4];
		int[] secondarySchoolGrades = new int[6];
		int[] highSchoolGrades = new int[7];

		int max = 0;
		int min = 0;

		Scanner scrInt = new Scanner(System.in);
		Random generator = new Random();

		System.out.println("Podstawówka wybierz - 1");
		System.out.println("Gimnazjum wybierz - 2");
		System.out.println("Liceum wybierz - 3");

		int subject = scrInt.nextInt();

		switch (subject) {

		case 1:

			System.out.println("Wylosowanie oceny ucznia: ");
			for (int i = 0; i < primarySchoolGrades.length; i++) {
				int random = generator.nextInt(6) + 1;
				primarySchoolGrades[i] = random;
				System.out.print(" " + primarySchoolGrades[i]);

			}
			SredniaUcznia.printInfo(primarySchoolGrades);
			break;

		case 2:

			System.out.println("Wylosowanie oceny ucznia: ");
			for (int i = 0; i < secondarySchoolGrades.length; i++) {
				int temp = generator.nextInt(6) + 1;
				secondarySchoolGrades[i] = temp;
				System.out.print(" " + secondarySchoolGrades[i]);

			}
			SredniaUcznia.printInfo(secondarySchoolGrades);
			break;

		case 3:

			System.out.println("Wylosowanie oceny ucznia: ");
			for (int i = 0; i < highSchoolGrades.length; i++) {
				int random = generator.nextInt(6) + 1;
				highSchoolGrades[i] = random;
				System.out.print(" " + highSchoolGrades[i]);
			}
			System.out.println();
			SredniaUcznia.printInfo(highSchoolGrades);
			break;

		}
	}
}
