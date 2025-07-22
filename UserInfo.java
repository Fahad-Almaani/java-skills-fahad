public class UserInfo {
    private String name;
    private int age;
    private String email;
    private boolean isActive;

    public UserInfo(String name,int age,  String email, boolean isActive) {

        this.name = name;
        this.age = age;
        this.email = email;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAeg() {
        return age;
    }

    public void setAeg(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void displayInfo(){
        System.out.println("--User Info--");
        System.out.println("  Name     : " + name);
        System.out.println("  Age      : " + age + " years old");
        System.out.println("  Email    : " + email);
        System.out.println("  Status   : " + (isActive ? "Active" : "Inactive"));
    }

    public static void main(String[] args){
        UserInfo user1 = new UserInfo("Fahad Almaani",22,"fahad@gmail.com",true);
        UserInfo user2 = new UserInfo("Said mohammed",32,"fahad@gmail.com",true);
        UserInfo user3 = new UserInfo("Someone nobody", 41, "fahad@gmail.com", false);

        user1.displayInfo();
        user2.displayInfo();
        user3.displayInfo();

        System.out.println("---------Testing Getter and setters---------");

        user1.setName("Fahad updated");
        user1.setAeg(30);
        user1.setActive(false);
        user1.setEmail("F@gmail.com");

        System.out.println(user1.getName());
        System.out.println(user1.getEmail());
        System.out.println(user1.getAeg());
        System.out.println(user1.isActive());
    }
}
