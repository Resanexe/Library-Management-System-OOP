// Abstract class representing a general library item
// This demonstrates ABSTRACTION - we define a blueprint that subclasses must follow
public abstract class LibraryItem {

    // ENCAPSULATION - private attributes, only accessible via getters/setters
    private String itemId;
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    // Getters and Setters
    public String getItemId() { return itemId; }
    public void setItemId(String itemId) { this.itemId = itemId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    // Abstract method - subclasses MUST override this (Abstraction)
    public abstract String getItemType();

    // Abstract method - subclasses MUST override this (Abstraction + Polymorphism)
    public abstract void displayInfo();

    // Common method shared by all subclasses
    public String getAvailabilityStatus() {
        return isAvailable ? "Available" : "Borrowed";
    }
}
