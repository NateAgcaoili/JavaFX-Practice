import java.util.Scanner;

public class MiscPractice {
	public static void main(String[] args) {
		// Variables
		int validGrades = 0, rejectedGrades = 0, gradeA = 0, gradeB = 0, gradeC = 0, gradeD = 0, gradeF = 0,
				examGrade = 0, numGrades;
		double highGrade = 0, lowGrade = 100;
		boolean isValid = false;
		Scanner input = new Scanner(System.in);

		System.out.print("Number of Grades: ");
		numGrades = input.nextInt();

		// Get input from user loop
		for (int i = 0; i < numGrades; i++) {
			while (isValid == false) {
				System.out.printf("Enter a grade from 0-100 (%d of %d): ", i + 1, numGrades);
				examGrade = input.nextInt();
				if (examGrade >= 0 && examGrade <= 100) {
					isValid = true;
				} else {
					System.out.println("Error: That is not a valid score.");
				}
			}
			if (examGrade > highGrade) {
				highGrade = examGrade;
			}
			if (examGrade < lowGrade) {
				lowGrade = examGrade;
			}
			if (examGrade >= 90 && examGrade <= 100) {
				gradeA++;
			} else if (examGrade >= 80 && examGrade < 90) {
				gradeB++;
			} else if (examGrade >= 75 && examGrade < 80) {
				gradeC++;
			} else if (examGrade >= 70 && examGrade < 75) {
				gradeD++;
			} else {
				gradeF++;
			}
			//isValid = false;
		}

		System.out.printf("%nValid grades:\t%d" + "%nInvalid grades:\t%d" + "%nHighest grade:\t%.2f"
				+ "%nLowest grade:\t%.2f%n%n", validGrades, rejectedGrades, highGrade, lowGrade);
		System.out.printf("As:\t%d" + "%nBs:\t%d" + "%nCs:\t%d" + "%nDs:\t%d" + "%nFs:\t%d%n", gradeA, gradeB, gradeC,
				gradeD, gradeF);

	}
}
