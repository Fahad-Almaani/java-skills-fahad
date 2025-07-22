public class PatternMaker {
    public static void printNumberTriangle(int rows){
        if(rows <= 0){
            System.out.println("Number of row is 0");
            return;
        }
        for(int i=0;i<rows;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+ " ");

            }
            System.out.println();
        }
    }

    public static void printMultiplicationTable(int number, int limit) {
        System.out.println("\n--- Multiplication Table for " + number + " (Limit: " + limit + ") ---");
        if (limit <= 0) {
            System.out.println("Limit must be positive for a multiplication table.");
            return;
        }

        for (int i = 1; i <= limit; i++) {
            int result = number * i;
            System.out.println(number + " x " + i + " = " + result);
        }
    }

    public static void main(String[] args){
        printNumberTriangle(5);

        System.out.println();

        printMultiplicationTable(7,10);
    }

}
