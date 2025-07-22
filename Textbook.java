// File: Textbook.java (in the same directory as Book.java)

public class Textbook extends Book { // Textbook is a child class of Book
    private String subject;
    private int edition;

    // Constructor for Textbook
    public Textbook(String title, String author, int pages, String subject, int edition) {
        // Call parent constructor using super()
        // The parameters (title, author, pages) are passed up to the Book constructor.
        super(title, author, pages); // 'pages' is now int, matching Book's constructor

        // Initialize Textbook-specific fields
        this.subject = subject;
        this.edition = edition;
    }

    // Override the displayInfo method
    @Override // This annotation is good practice to indicate method overriding
    public void displayInfo() {
        // Call parent's displayInfo using super.displayInfo()
        super.displayInfo(); // This will print Title, Author, Pages, Available

        // Then add subject and edition information specific to Textbook
        System.out.println("Subject: " + subject);
        System.out.println("Edition: " + edition);
    }

    // Add getter methods for subject and edition
    public String getSubject() {
        return subject;
    }

    public int getEdition() {
        return edition;
    }


}