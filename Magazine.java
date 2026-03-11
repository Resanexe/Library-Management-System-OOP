// Magazine class - INHERITS from LibraryItem (Inheritance)
public class Magazine extends LibraryItem {

    // Attributes specific to Magazine
    private int issueNumber;
    private String month;
    private String category;

    // Constructor
    public Magazine(String itemId, String title, String author, int issueNumber, String month, String category) {
        super(itemId, title, author);
        this.issueNumber = issueNumber;
        this.month = month;
        this.category = category;
    }

    // Getters and Setters
    public int getIssueNumber() { return issueNumber; }
    public void setIssueNumber(int issueNumber) { this.issueNumber = issueNumber; }

    public String getMonth() { return month; }
    public void setMonth(String month) { this.month = month; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    // POLYMORPHISM - Method overriding
    @Override
    public String getItemType() {
        return "Magazine";
    }

    // POLYMORPHISM - Method overriding
    @Override
    public void displayInfo() {
        System.out.println("-----------------------------");
        System.out.println("Type       : " + getItemType());
        System.out.println("ID         : " + getItemId());
        System.out.println("Title      : " + getTitle());
        System.out.println("Publisher  : " + getAuthor());
        System.out.println("Issue No.  : " + issueNumber);
        System.out.println("Month      : " + month);
        System.out.println("Category   : " + category);
        System.out.println("Status     : " + getAvailabilityStatus());
        System.out.println("-----------------------------");
    }
}
