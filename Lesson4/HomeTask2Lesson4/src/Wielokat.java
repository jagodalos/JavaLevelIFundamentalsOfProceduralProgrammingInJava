import java.util.Random;
import java.util.Scanner;

public class Wielokat {

	public static void main(String[] args) {

		int iloscKatow = 4;
		int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0;

		if (iloscKatow < 3) {

			System.out.println("Ilosc katow w wielokacie jest nieprawidlowa.");
			System.out.println("Zdefiniuj ilosc katow jeszcze raz");

		}
		System.out.println();

		Scanner scInt = new Scanner(System.in);
		if (iloscKatow == 3) {
			for (int i = 2; i < iloscKatow; i++) {
				System.out.println("Podaj bok a");
				a = scInt.nextInt();
				System.out.println("Podaj bok b");
				b = scInt.nextInt();
				System.out.println("Podaj bok c");
				c = scInt.nextInt();
			}
			System.out.println("obwod" + (a + b + c));
		} else if (iloscKatow == 4) {
			for (int i = 3; i < iloscKatow; i++) {
				System.out.println("Podaj bok a");
				a = scInt.nextInt();
				System.out.println("Podaj bok b");
				b = scInt.nextInt();
				System.out.println("Podaj bok c");
				c = scInt.nextInt();
				System.out.println("Podaj bok d");
				d = scInt.nextInt();
			}
			System.out.println("obwod" + (a + b + c + d));
		} else if (iloscKatow == 5) {
			for (int i = 4; i < iloscKatow; i++) {
				System.out.println("Podaj bok a");
				a = scInt.nextInt();
				System.out.println("Podaj bok b");
				b = scInt.nextInt();
				System.out.println("Podaj bok c");
				c = scInt.nextInt();
				System.out.println("Podaj bok d");
				d = scInt.nextInt();
				System.out.println("Podaj bok e");
				e = scInt.nextInt();
			}
			System.out.println("obwod" + (a + b + c + d + e));
		} else if (iloscKatow == 6) {
			for (int i = 5; i < iloscKatow; i++) {
				System.out.println("Podaj bok a");
				a = scInt.nextInt();
				System.out.println("Podaj bok b");
				b = scInt.nextInt();
				System.out.println("Podaj bok c");
				c = scInt.nextInt();
				System.out.println("Podaj bok d");
				d = scInt.nextInt();
				System.out.println("Podaj bok e");
				e = scInt.nextInt();
				System.out.println("Podaj bok f");
				f = scInt.nextInt();
			}
			System.out.println("obwod" + (a + b + c + d + f));
		}

		else {
			Random generator = new Random();
			System.out.println("The ten random values are: ");
			int[] table = new int[iloscKatow];
			for(int i = 0; i < iloscKatow; i++) {
			   int wynik = generator.nextInt(13);
			   table[i] = wynik;
			   System.out.print(" ," + wynik);
			}
		
			int sum = 0;
			for ( int i : table){
				sum=sum+i;
				
			}
			System.out.println("obwod" + sum);
			
			
			}
			
			

		}
	}








