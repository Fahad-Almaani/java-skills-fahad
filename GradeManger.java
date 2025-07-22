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

}
