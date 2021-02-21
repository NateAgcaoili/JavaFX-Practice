import java.util.Scanner;

public class MiscPractice {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String temp;
		
		// Prompt user for width and rectangle height.
		
		System.out.printf("Enter width for rectangle: " );
		int width = input.nextInt();
		System.out.printf("Enter height for rectangle: ");
		int height = input.nextInt();
		
		// Error
		if (width < 1 || height < 1) {
			System.out.printf("Your rectangle must have a positive height and width.");
			System.exit(0);
		}
		
		// Prompt the user for x,y values for center and point to test
		System.out.printf("Enter x,y value for center point of rectangle: ");
		temp = input.next();
		
		// Parsing substrings of temp by dividing them based on the index of the comma
		int centerX = Integer.parseInt(temp.substring(0, temp.indexOf(',')));
		int centerY = Integer.parseInt(temp.substring(temp.indexOf(',') + 1));
		
		System.out.printf("Enter x,y value for test point: ");
		temp = input.next();
		
		// Parsing substrings of temp by dividing them based on the index of the comma
		int testPointX = Integer.parseInt(temp.substring(0, temp.indexOf(',')));
		int testPointY = Integer.parseInt(temp.substring(temp.indexOf(',') + 1));
			
		double horizDist = Math.sqrt(Math.pow(testPointX - centerX, 2));
		double vertDist = Math.sqrt(Math.pow(testPointY - centerY, 2));
		
		// Create an if determining if the point is in the rectangle.
		String isIn = "";
		
		if (horizDist <= width / 2 && vertDist <= height / 2) {
			isIn = "is in";
		} else {
			isIn = "is not in";			
		}
		
		// Final printf
		System.out.printf("(%d, %d) %s the triangle centered at (%d, %d) with width %d and height %d", testPointX, testPointY, isIn, centerX, centerY, width, height);	
			
	}
}
