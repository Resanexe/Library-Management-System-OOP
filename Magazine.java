public class Magazine extends LibraryItem {

    private static final String RESET  = "\033[0m";
    private static final String BOLD   = "\033[1m";
    private static final String PURPLE = "\033[35m";
    private static final String CYAN   = "\033[36m";
    private static final String GREEN  = "\033[32m";
    private static final String RED    = "\033[31m";
    private static final String WHITE  = "\033[37m";

    private int issueNumber;
    private String month;
    private String category;

    public Magazine(String itemId, String title, String author, int issueNumber, String month, String category) {
        super(itemId, title, author);
        this.issueNumber = issueNumber;
        this.month = month;
        this.category = category;
    }

    public int getIssueNumber()               { return issueNumber; }
    public void setIssueNumber(int n)         { this.issueNumber = n; }
    public String getMonth()                  { return month; }
    public void setMonth(String month)        { this.month = month; }
    public String getCategory()               { return category; }
    public void setCategory(String category)  { this.category = category; }

    @Override
    public String getItemType() { return "Magazine"; }

    @Override
    public void displayInfo() {
        String status = isAvailable()
            ? GREEN + "✔ Available" + RESET
            : RED   + "✘ Borrowed"  + RESET;

        System.out.println(PURPLE + "  ┌──────────────────────────────────────┐" + RESET);
        System.out.println(PURPLE + "  │  📰  " + BOLD + WHITE + "MAGAZINE" + RESET + PURPLE + "                             │" + RESET);
        System.out.println(PURPLE + "  ├──────────────────────────────────────┤" + RESET);
        System.out.println(PURPLE + "  │ " + CYAN + " ID       : " + RESET + WHITE + getItemId()  + RESET);
        System.out.println(PURPLE + "  │ " + CYAN + " Title    : " + RESET + WHITE + getTitle()   + RESET);
        System.out.println(PURPLE + "  │ " + CYAN + " Publisher: " + RESET + WHITE + getAuthor()  + RESET);
        System.out.println(PURPLE + "  │ " + CYAN + " Issue No.: " + RESET + WHITE + issueNumber  + RESET);
        System.out.println(PURPLE + "  │ " + CYAN + " Month    : " + RESET + WHITE + month        + RESET);
        System.out.println(PURPLE + "  │ " + CYAN + " Category : " + RESET + WHITE + category     + RESET);
        System.out.println(PURPLE + "  │ " + CYAN + " Status   : " + RESET + status);
        System.out.println(PURPLE + "  └──────────────────────────────────────┘" + RESET);
    }
}
