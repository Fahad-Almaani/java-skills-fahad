public class ShoppingCart {

    public static double calculateTotal(double[] prices, String customerType){
        double total = 0;

        for(int i=0;i<prices.length;i++){
            total+=prices[i];
        }
        switch (customerType){
            case "PREMIUM":
                total = total - (total * 0.10);
                break;
            case "VIP":
                total = total - (total * 0.20);
                break;
            default:
                break;
        }
        return  total;
    }
    public static double findMostExpensive(double[] prices){
        double mostExpensive = Double.MIN_VALUE;
        for (double price : prices) {
            if (price > mostExpensive) {
                mostExpensive = price;
            }
        }
        return mostExpensive;
    }

    public static int countExpensiveItems(double[] prices,double threshold){
        int count = 0;
        for (double price : prices) {
            if (price > threshold) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        double[] cart = {25.99, 45.50, 12.99, 89.99, 15.75};
        System.out.println("Regular customer total: $" + calculateTotal(cart, "REGULAR"));
        System.out.println("Premium customer total: $" + calculateTotal(cart, "PREMIUM"));
        System.out.println("VIP customer total: $" + calculateTotal(cart, "VIP"));
    }

}
