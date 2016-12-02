
public class Main {

	public static void main(String[] args) {
		int redBalls = 10;
		int blueBalls = 5;		
		int greenBalls = 15;	
		
		System.out.println("Number of red balls : " + redBalls );
		System.out.println("Number of blue balls : " + blueBalls );
		System.out.println("Number of green balls : " + greenBalls );
		System.out.println("All balls : " + (greenBalls + blueBalls + redBalls) );
		
		
		int sum = redBalls + blueBalls + greenBalls;
		int blackBalls = 2;
		sum += blackBalls;
		
		System.out.println("All balls : " + sum);
		
		redBalls = 5;
		
		System.out.println("All balls : " + sum);
		

	}

}
