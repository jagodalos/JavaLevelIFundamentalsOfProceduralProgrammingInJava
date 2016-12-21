import java.util.Random;
import java.util.Scanner;

public class SredniaUcznia {

	public static void main(String[] args) {

		System.out.println("PROGRAM SREDNIA KONCOWA UCZNIA");
		System.out.println();

		int[] PrimarySchoolSubjects = new int[4];
		int[] SecondarySchoolSubjects = new int[6];
		int[] HighSchoolSubcjects = new int[7];
		// float a = 1.5f;
		// float b = 5.5f;
		double average = 0;
		double sum = 0;

		Scanner scrInt = new Scanner(System.in);
		Random generator = new Random();

		System.out.println("Podstawówka wybierz - 1");
		System.out.println("Gimnazjum wybierz - 2");
		System.out.println("Liceum wybierz - 3");

		int subject = scrInt.nextInt();

		switch (subject) {

		case 1:
			
			System.out.println("Wylosowanie oceny ucznia: ");
			for (int i = 0; i < PrimarySchoolSubjects.length; i++) {
				double temp = generator.nextInt(6) + 1;
				PrimarySchoolSubjects[i] += temp;
				System.out.print(" " + PrimarySchoolSubjects[i]);
			}

			for (int number : PrimarySchoolSubjects) {
				sum = sum + number;
				average = sum / PrimarySchoolSubjects.length;
			}
			System.out.println();
			System.out.println("Srednia ocen : " + average);
			break;
			
		case 2:
			
			System.out.println("Wylosowane oceny ucznia: ");
			for (int i = 0; i < SecondarySchoolSubjects.length; i++) {
				int temp = generator.nextInt(6) + 1;
				SecondarySchoolSubjects[i] += temp;
				System.out.print(" " + SecondarySchoolSubjects[i]);
			}
			for (int number : SecondarySchoolSubjects) {
				sum = sum + number;
				average = sum / SecondarySchoolSubjects.length;
			}
			System.out.println();
			System.out.println("Srednia ocen : " + average);
			break;
			
		case 3:
			
			System.out.println("Wylosowane oceny ucznia: ");
			for (int i = 0; i < HighSchoolSubcjects.length; i++) {
				int temp = generator.nextInt(6) + 1;
				// float temp = generator.nextFloat() * (b - a) + a;
				HighSchoolSubcjects[i] += temp;
				System.out.print(" " + HighSchoolSubcjects[i]);
			}
			for (int number : HighSchoolSubcjects) {
				sum = sum + number;
				average = sum / HighSchoolSubcjects.length;
			}
			System.out.println();
			System.out.println("Srednia ocen : " + average);
			break;
		}

	}

}
