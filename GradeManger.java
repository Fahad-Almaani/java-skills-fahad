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
            return names;
        }
        return null;
    }
    public static char getLetterGrade(int score){
        char grade;
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
        return grade;
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
}
