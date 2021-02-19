import java.util.Scanner;

public class MiscPractice {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String temp;
		int separatorIndex = 0;
		
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
		
		// Finding index in which the comma separates the center X and center Y coordinates
		temp = input.next();
		for(int i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) == ',') {
				separatorIndex = i;
				break;
			}
		}
		
		// Parsing substrings of temp by dividing them based on the separator index
		int centerX = Integer.parseInt(temp.substring(0, separatorIndex));
		int centerY = Integer.parseInt(temp.substring(separatorIndex + 1));
		
		System.out.printf("Enter x,y value for test point: ");
		
		// Finding index in which the comma separates the test point X and test point Y coordinates
		temp = input.next();
		for(int i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) == ',') {
				separatorIndex = i;
				break;
			}
		}
		
		// Parsing substrings of temp by dividing them based on the separator index
		int testPointX = Integer.parseInt(temp.substring(0, separatorIndex));
		int testPointY = Integer.parseInt(temp.substring(separatorIndex + 1));
			
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
