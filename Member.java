// Member class - represents a library member
// Demonstrates ENCAPSULATION with private fields and public getters/setters
public class Member {

    private String memberId;
    private String name;
    private String email;
    private String phoneNumber;
    private int borrowedCount;

    // Maximum items a member can borrow at once
    private static final int MAX_BORROW_LIMIT = 3;

    // Constructor
    public Member(String memberId, String name, String email, String phoneNumber) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.borrowedCount = 0;
    }

    // Getters and Setters
    public String getMemberId() { return memberId; }
    public void setMemberId(String memberId) { this.memberId = memberId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public int getBorrowedCount() { return borrowedCount; }

    // Check if member can borrow more items
    public boolean canBorrow() {
        return borrowedCount < MAX_BORROW_LIMIT;
    }

    // Increment borrowed count
    public void borrowItem() {
        if (canBorrow()) {
            borrowedCount++;
        }
    }

    // Decrement borrowed count when returning
    public void returnItem() {
        if (borrowedCount > 0) {
            borrowedCount--;
        }
    }

    // Display member information
    public void displayInfo() {
        System.out.println("-----------------------------");
        System.out.println("Member ID  : " + memberId);
        System.out.println("Name       : " + name);
        System.out.println("Email      : " + email);
        System.out.println("Phone      : " + phoneNumber);
        System.out.println("Borrowed   : " + borrowedCount + "/" + MAX_BORROW_LIMIT);
        System.out.println("-----------------------------");
    }
}
