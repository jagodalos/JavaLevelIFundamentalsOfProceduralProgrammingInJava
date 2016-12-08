
public class EmptyMailBox {
	
	public static void main(String[] args) {

		System.out.println("CZY MAMY WIADOMOSC W SKRZYNCE ?");
		System.out.println();

		// zmienna = warunek ? wartosc_jak_prawda : wartosc_jak_falsz;

		boolean IsMailBoxEmpty = true;

		IsMailBoxEmpty = true ? true : false;

		if (IsMailBoxEmpty == true) {
			System.out.println("POCZTA JEST PUSTA");
		} else {
			System.out.println("MASZ WIADOMOSC");
		}

	}

}
