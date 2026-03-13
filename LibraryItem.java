public abstract class LibraryItem {

    private String itemId;
    private String title;
    private String author;
    private boolean isAvailable;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getItemId()            { return itemId; }
    public void setItemId(String id)     { this.itemId = id; }
    public String getTitle()             { return title; }
    public void setTitle(String title)   { this.title = title; }
    public String getAuthor()            { return author; }
    public void setAuthor(String author) { this.author = author; }
    public boolean isAvailable()         { return isAvailable; }
    public void setAvailable(boolean b)  { this.isAvailable = b; }

    public String getAvailabilityStatus() { return isAvailable ? "Available" : "Borrowed"; }

    public abstract String getItemType();
    public abstract void displayInfo();
}
