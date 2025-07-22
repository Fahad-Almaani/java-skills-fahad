import java.util.ArrayList;
import java.util.List;
public class GradeManger {

    public static String[] reverseStudentNames(String[] names) {
        if (names == null) {
            System.out.println("Warning: Input array is null. Returning null.");
            return null;
        }
        if (names.length == 0) {
            System.out.println("Warning: Input array is empty. Returning the empty array.");
            return names;
        }

        for (int i = 0; i < names.length; i++) {
            String originalName = names[i];


            if (originalName != null) {

                StringBuilder sb = new StringBuilder(originalName);
                sb.reverse();
                names[i] = sb.toString();
            }

            // Return the array

        }
        return names;

    }
    public static char[] getLetterGrade(int[] scores){
        if (scores == null || scores.length == 0) {
            System.err.println("Error: Scores array is null or empty. Cannot calculate grade. Returning 'N' for Not Applicable.");
            return null; // Or throw an IllegalArgumentException, depending on desired error handling
        }
        char[] grades = new char[scores.length];
        char grade;
        for(int i=0;i<scores.length;i++){
            int score = scores[i];
            if(score < 60){
                grade = 'F';
            }else if(score < 70){
                grade = 'D';
            }else if(score < 80){
                grade = 'C';
            }else if (score<90){
                grade= 'B';
            }else{
                grade = 'A';
            }
            grades[i] = grade;
        }
        return grades;
    }

    public static String[] findFailingStudents(String[] names, int[] scores){
        List<String> failingStudentList = new ArrayList<>();
        for(int i=0;i<scores.length;i++){
            if(scores[i]<60){
                failingStudentList.add(names[i]);
            }
        }
        return failingStudentList.toArray(new String[0]);
    }

    public static void  main(String[] args){
        String[] students = {"Alice", "Bob", "Charlie", "Diana"};
        int[] scores = {95, 67, 45, 78};

        String[] reversedNames = reverseStudentNames(students);
        System.out.println("----- Reversed Names -----");
        for(int i=0;i<reversedNames.length;i++){
            System.out.println(reversedNames[i]);
        }

        char[] grades = getLetterGrade(scores);
        System.out.println("----- Grade Letters -----");
        for(int i=0;i<grades.length;i++){
            System.out.println(grades[i]);
        }

    }
}
