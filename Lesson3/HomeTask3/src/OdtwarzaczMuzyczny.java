import java.util.Scanner;

public class OdtwarzaczMuzyczny {
	public static void main(String[] args) {

		System.out.println("MOJ ODTWARZACZ MUZYCZNY");
		System.out.println();

		String variableMusicType = null, variableMusicVolume = null;
		int numberOfDBRightSpeaker = 0, numberOfDBOneSpeaker = 0, numberOfDBLeftSpeaker = 0;

		Scanner scInt = new Scanner(System.in);
		Scanner scString = new Scanner(System.in);

		System.out.println("I. Wybierz Twoj gatunek muzyczny.");
		System.out.println("1 - Rock");
		System.out.println("2 - Jazz");
		System.out.println("3 - Pop");
		System.out.println("4 - Rnb");
		int musicType = scInt.nextInt();

		switch (musicType) {

		case 1:
			variableMusicType = "Rock";
			break;
		case 2:
			variableMusicType = "Jazz";
			break;
		case 3:
			variableMusicType = "Pop";
			break;
		case 4:
			variableMusicType = "Rnb";
			break;
		default:
			System.out.println("Wprowadziles niepoprawny numer !");
		}

		System.out.println();

		System.out.println("II. Wybierz poziom natezenia muzyki.");
		System.out.println("1 - cichy");
		System.out.println("2 - glosny");
		int musicVolume = scInt.nextInt();

		switch (musicVolume) {

		case 1:
			variableMusicVolume = "cichy";
			break;
		case 2:
			variableMusicVolume = "glosny";
			break;
		default:
			System.out.println("Wprowadziles niepoprawny numer !");

		}

		System.out.println();

		Scanner scBool = new Scanner(System.in);

		System.out.println("III. Wybierz conajmniej jeden ton muzyki.");
		System.out.println();

		System.out.println("Niski ton - napisz \"true\", \"false\" - nie.");
		boolean niski = scBool.nextBoolean();

		System.out.println("Wysoki ton - napisz \"true\", \"false\" - nie.");

		boolean wysoki = scBool.nextBoolean();

		System.out.println("Sredni ton - napisz \"true\", \"false\" - nie.");

		boolean sredni = scBool.nextBoolean();

		String tones = " ";

		if (niski == true) {
			tones += "niski ";
		}

		if (wysoki == true) {
			tones += "wysoki ";
		}

		if (!niski && !wysoki) {
			sredni = true;
			tones += "sredni ";

		} else if (!niski && wysoki == true && sredni == true) {
			tones += ",sredni";
		}

		else if (!wysoki && niski == true && sredni == true) {
			tones += ",sredni";
		}

		else if (niski == true && sredni == true && wysoki == true) {
			tones += " sredni";
		}

		System.out.println();

		System.out.println("V. Wybierz ilosc glosnikow. ");
		System.out.println("1 - jeden glosnik");
		System.out.println("2 - dwa glosniki");
		int musicSpeaker = scInt.nextInt();

		switch (musicVolume) {

		case 1:
			System.out.println("VI. Wybierz ilosc DB (decybeli).");
			numberOfDBOneSpeaker = scInt.nextInt();
			if (numberOfDBOneSpeaker > 10) {
				System.out.println("Ilosc DB w jednym glosniku nie moze przekraczac 10 !");
			} else {
				// System.out.println("Ilosc decybeli " + numberOfDBOneSpeaker);
			}
			break;
		case 2:
			System.out.println("VI. Wybierz ilosc DB (decybeli) w lewym glosniku");
			numberOfDBLeftSpeaker = scInt.nextInt();
			if (numberOfDBLeftSpeaker > 10) {
				System.out.println("Ilosc DB w jednym glosniku nie moze przekraczac 10 !");
			} else {
				numberOfDBRightSpeaker = 10 - numberOfDBLeftSpeaker;

				// System.out.println("Ilosc decybeli w lewym glosniku: " +
				// numberOfDBLeftSpeaker + " "
				// + "Ilosc decybeli w prawym glosniku: " +
				// numberOfDBRightSpeaker);
			}

			break;
		default:
			System.out.println("Wprowadziles niepoprawny numer");

		}

		System.out.println();

		System.out.println(
				"-------------------------------------------------------------------------------------------------------------");
		System.out.println("Twoj typ muzyki: " + variableMusicType);
		System.out.println("Poziom natezenia muzyki: " + variableMusicVolume);
		System.out.println("Ton/y muzyki: " + tones);
		if (numberOfDBOneSpeaker != 0)
			System.out.println("Ilosc DB w glosniku: " + numberOfDBOneSpeaker);
		if (numberOfDBRightSpeaker != 0 || numberOfDBLeftSpeaker != 0)
			System.out.println("Ilosc DB w prawym glosniku: " + numberOfDBRightSpeaker + "\nIlosc DB w lewym glosniku: "
					+ numberOfDBLeftSpeaker);
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------");
	}

}
