// Book class - INHERITS from LibraryItem (Inheritance using 'extends')
public class Book extends LibraryItem {

    // Additional attributes specific to Book
    private String isbn;
    private int numberOfPages;
    private String genre;

    // Constructor calling superclass constructor using 'super'
    public Book(String itemId, String title, String author, String isbn, int numberOfPages, String genre) {
        super(itemId, title, author); // Call parent constructor
        this.isbn = isbn;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
    }

    // Getters and Setters
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public int getNumberOfPages() { return numberOfPages; }
    public void setNumberOfPages(int numberOfPages) { this.numberOfPages = numberOfPages; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    // POLYMORPHISM - Method overriding (overrides abstract method from LibraryItem)
    @Override
    public String getItemType() {
        return "Book";
    }

    // POLYMORPHISM - Method overriding
    @Override
    public void displayInfo() {
        System.out.println("-----------------------------");
        System.out.println("Type       : " + getItemType());
        System.out.println("ID         : " + getItemId());
        System.out.println("Title      : " + getTitle());
        System.out.println("Author     : " + getAuthor());
        System.out.println("ISBN       : " + isbn);
        System.out.println("Pages      : " + numberOfPages);
        System.out.println("Genre      : " + genre);
        System.out.println("Status     : " + getAvailabilityStatus());
        System.out.println("-----------------------------");
    }
}
