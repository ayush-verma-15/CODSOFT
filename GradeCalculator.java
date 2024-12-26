import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        double[] marks = new double[numSubjects];

        for (int i = 0; i < numSubjects; i++) {
            marks[i] = getValidMark(scanner, i + 1);
        }

        double totalMarks = calculateTotalMarks(marks);
        double averagePercentage = totalMarks / numSubjects;

        String grade = calculateGrade(averagePercentage);

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

    }
    }
    private static double getValidMark(Scanner scanner, int subjectNumber) {
        while (true) {
            System.out.print("Enter marks obtained in subject " + subjectNumber + " (out of 100): ");
            double mark = scanner.nextDouble();
            if (mark >= 0 && mark <= 100) {
                return mark;
            } else {
                System.out.println("Invalid input. Marks must be between 0 and 100.");
            }
        }
    }
    private static double calculateTotalMarks(double[] marks) {
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total;
    }

    private static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B";
        } else if (averagePercentage >= 60) {
            return "C";
        } else if (averagePercentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
