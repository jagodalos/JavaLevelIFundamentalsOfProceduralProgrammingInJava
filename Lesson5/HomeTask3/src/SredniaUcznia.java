import java.awt.SecondaryLoop;
import java.util.Random;
import java.util.Scanner;

public class SredniaUcznia {

	double max = 0;
	double min = 0;
	double mark = 0;

	static Scanner scrInt = new Scanner(System.in);
	static Random generator = new Random();

	static public double calculateAverage(double[] grades) {
		double sum = 0;
		for (double grade : grades) {
			sum += grade;
		}
		double average = sum / grades.length;
		return average;
	}

	static public double getMax(double[] grades) {
		double max = grades[0];
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] > max) {
				max = grades[i];
			}
		}
		return max;
	}

	static public double getMin(double[] grades) {
		double min = grades[0];
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] < min) {
				min = grades[i];
			}
		}
		return min;
	}

	public static double getMark(int mark) {
		if (mark != 6) {
			if (generator.nextBoolean()) {
				return mark + 0.5;
			}
		}
		return mark;
	}

	static public void printInfo(double[] grades) {
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

		double[] primarySchoolGrades = new double[4];
		double[] secondarySchoolGrades = new double[6];
		double[] highSchoolGrades = new double[7];

		System.out.println("Podstawówka wybierz - 1");
		System.out.println("Gimnazjum wybierz - 2");
		System.out.println("Liceum wybierz - 3");

		int subject = scrInt.nextInt();

		switch (subject) {

		case 1:

			System.out.println("Wylosowanie oceny ucznia: ");
			for (int i = 0; i < primarySchoolGrades.length; i++) {
				primarySchoolGrades[i] = getMark(generator.nextInt(6) + 1);
				System.out.print(" " + primarySchoolGrades[i]);

			}
			System.out.println();
			SredniaUcznia.printInfo(primarySchoolGrades);
			break;

		case 2:

			System.out.println("Wylosowanie oceny ucznia: ");
			for (int i = 0; i < secondarySchoolGrades.length; i++) {
				secondarySchoolGrades[i] = getMark(generator.nextInt(6) + 1);
				System.out.print(" " + secondarySchoolGrades[i]);

			}
			System.out.println();
			SredniaUcznia.printInfo(secondarySchoolGrades);
			break;

		case 3:

			System.out.println("Wylosowanie oceny ucznia: ");
			for (int i = 0; i < highSchoolGrades.length; i++) {
				highSchoolGrades[i] = getMark(generator.nextInt(6) + 1);
				System.out.print(" " + highSchoolGrades[i]);
			}
			System.out.println();
			SredniaUcznia.printInfo(highSchoolGrades);
			break;

		}
	}
}
