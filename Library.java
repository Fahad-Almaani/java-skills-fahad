public class Library {
    public static void main(String[] args){
    Book regulerBook1 = new Book("From Good to Great","Mark H.E",450);
    Book regulerBook2 = new Book("Shadow of the wind","Calre C.S",1200);

    Textbook scienceTextbook = new Textbook(
            "introduction to somthing",
            "Dr. P. Someone",
            780,
            "Physics",
            5
    );

    System.out.println("----------Book info----------");
    System.out.println("RegularBook 1:");
    regulerBook1.displayInfo();
    System.out.println("\nRegular Book 2:");
    regulerBook2.displayInfo();
    System.out.println("\nScience Textbook:");
    scienceTextbook.displayInfo();
    System.out.println("\n--- Testing Borrowing and Returning ---");

    // test borrow book
    regulerBook1.borrowBook();
    System.out.println("Current status of " + regulerBook1.getTitle() + ":");
    regulerBook1.displayInfo();

    System.out.println("\nAttempting to borrow " + regulerBook1.getTitle() + " again...");
    regulerBook1.borrowBook();

    // test borrow text book
    System.out.println("\nAttempting to borrow " + scienceTextbook.getTitle() + "...");
    scienceTextbook.borrowBook();
    System.out.println("Current status of " + scienceTextbook.getTitle() + ":");
    scienceTextbook.displayInfo();

    // test returnging book
    System.out.println("\nAttempting to return " + regulerBook1.getTitle() + "...");
    regulerBook1.returnBook();
    System.out.println("Current status of " + regulerBook1.getTitle() + ":");
    regulerBook1.displayInfo();

    // test returning text book
    System.out.println("\nAttempting to return " + scienceTextbook.getTitle() + "...");
    scienceTextbook.returnBook();
    System.out.println("Current status of " + scienceTextbook.getTitle() + ":");
    scienceTextbook.displayInfo();

    }

}
