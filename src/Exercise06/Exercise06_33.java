package Exercise06;
import java.util.Scanner;
/**
 * @author Nishant Kotadia 20CS029
 * @Email 20cs029@charusat.edu.in
 * 
 * (Culture: Chinese Zodiac) Simplify Listing 3.10 using an array of strings to
 * store the animal names.
 */
public class Exercise06_33 {
    public static void main(String[] args) {
		
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Create array for Chinese Zodiac animal
        String[] zodiacs = {"monkey", "rooster", "dog", "pig", "rat", "ox", 
                            "tiger","rabbit", "dragon", "snake", "horse",
                            "sheep"};

        // for the user to enter a year
	System.out.print("Enter a year: ");
        int year = input.nextInt();

	// Display Chinese Zodiac animal name
        System.out.println(zodiacs[year % 12]);
    }
}
