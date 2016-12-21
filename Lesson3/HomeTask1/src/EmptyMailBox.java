
public class EmptyMailBox {
	
	public static void main(String[] args) {

		System.out.println("CZY MAMY WIADOMOSC W SKRZYNCE ?");
		System.out.println();

		// zmienna = warunek ? wartosc_jak_prawda : wartosc_jak_falsz;

		boolean IsMailBoxEmpty = true;

		String communicate = IsMailBoxEmpty  ? "POCZTA JEST PUSTA" : "MASZ WIADOMOSC";

		System.out.println(communicate);

	}

}
