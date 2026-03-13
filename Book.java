public class Book extends LibraryItem {

    private static final String RESET  = "\033[0m";
    private static final String BOLD   = "\033[1m";
    private static final String YELLOW = "\033[33m";
    private static final String CYAN   = "\033[36m";
    private static final String GREEN  = "\033[32m";
    private static final String RED    = "\033[31m";
    private static final String WHITE  = "\033[37m";

    private String isbn;
    private int numberOfPages;
    private String genre;

    public Book(String itemId, String title, String author, String isbn, int numberOfPages, String genre) {
        super(itemId, title, author);
        this.isbn = isbn;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
    }

    public String getIsbn()                        { return isbn; }
    public void setIsbn(String isbn)               { this.isbn = isbn; }
    public int getNumberOfPages()                  { return numberOfPages; }
    public void setNumberOfPages(int n)            { this.numberOfPages = n; }
    public String getGenre()                       { return genre; }
    public void setGenre(String genre)             { this.genre = genre; }

    @Override
    public String getItemType() { return "Book"; }

    @Override
    public void displayInfo() {
        String status = isAvailable()
            ? GREEN + "✔ Available" + RESET
            : RED   + "✘ Borrowed"  + RESET;

        System.out.println(YELLOW + "  ┌──────────────────────────────────────┐" + RESET);
        System.out.println(YELLOW + "  │  📖  " + BOLD + WHITE + "BOOK" + RESET + YELLOW + "                                 │" + RESET);
        System.out.println(YELLOW + "  ├──────────────────────────────────────┤" + RESET);
        System.out.println(YELLOW + "  │ " + CYAN + " ID      : " + RESET + WHITE + getItemId()     + RESET);
        System.out.println(YELLOW + "  │ " + CYAN + " Title   : " + RESET + WHITE + getTitle()      + RESET);
        System.out.println(YELLOW + "  │ " + CYAN + " Author  : " + RESET + WHITE + getAuthor()     + RESET);
        System.out.println(YELLOW + "  │ " + CYAN + " ISBN    : " + RESET + WHITE + isbn            + RESET);
        System.out.println(YELLOW + "  │ " + CYAN + " Pages   : " + RESET + WHITE + numberOfPages   + RESET);
        System.out.println(YELLOW + "  │ " + CYAN + " Genre   : " + RESET + WHITE + genre           + RESET);
        System.out.println(YELLOW + "  │ " + CYAN + " Status  : " + RESET + status);
        System.out.println(YELLOW + "  └──────────────────────────────────────┘" + RESET);
    }
}
