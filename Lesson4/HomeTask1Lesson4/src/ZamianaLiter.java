
public class ZamianaLiter {
	public static void main(String[] args) {

		System.out.println("PROGRAM ZMIANA LITER W IMIENIU");
		System.out.println();

		
	
		char[] name = "Janek".toCharArray();



		name[0] = 'M';
		name[2] = 'r';
		for (int j = 0; j < name.length; j++) {
			System.out.print(name[j]);
		}

	}

}
