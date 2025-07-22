public class VisitorCounter {
    private static int totalVisitors = 0;

    private int sessionVisits;
    private String visitorName;


    public VisitorCounter(String visitorName) {
        this.visitorName = visitorName;
        this.sessionVisits = 0;
        totalVisitors++;
    }

    public void recordVisit(){
        sessionVisits++;
        System.out.println(visitorName +" Visited, Session Visit: " + sessionVisits);


    }

    public static void displayTotalVisitors() {
        System.out.println("Total visitors today: " + totalVisitors);
    }
    public static int getTotalVisitors() {
        return totalVisitors;
    }

    public static void main(String[] args){
        VisitorCounter visitor1 = new VisitorCounter("Fahad");
        VisitorCounter visitor2 = new VisitorCounter("Said");
        VisitorCounter visitor3 = new VisitorCounter("Mohammed");

        visitor1.recordVisit();
        visitor2.recordVisit();
        visitor3.recordVisit();
        visitor3.recordVisit();
        visitor3.recordVisit();

        System.out.println("-- Displaying Total --");
        VisitorCounter.displayTotalVisitors();






    }
}
