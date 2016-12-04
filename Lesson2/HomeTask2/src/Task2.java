
public class Task2 {

	enum ColorOfFlag {
		BLUE, WHITE, RED
	};

	public static void main(String[] args) {

		char firstLetter = 'J';
		String surname = "Los";
		int temperature = 32;
		float temperatureC = 25.5f;
		short numberOfStudents = 20;
		float weight = 55.5f;
		float height = 185.6f;
		double heightOfMontEverest = 884400.0;
		boolean isEmptyMailBox = true;
		long numberOfNeurons;
		final double PI_NUMBER = 3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582;
		long peopleOnFB;

		System.out.println("First letter of my name: " + firstLetter + ".");
		System.out.println("My last name: " + surname + ".");
		System.out.println("Today is: " + temperature + " degree.");
		System.out.println("Today is: " + temperatureC + " degree of Celsius.");
		System.out.println("There are: " + numberOfStudents + " students in the class.");
		System.out.println("He has: " + weight + " kg.");
		System.out.println("He has: " + height + " cm.");
		System.out.println("ME has: " + heightOfMontEverest + " cm.");
		System.out.println("Is my mailbox empty ? " + isEmptyMailBox);
		System.out.println("PI is: " + PI_NUMBER);
	}
}
