import java.util.Scanner;

public class Main {

    private static final String RESET   = "\033[0m";
    private static final String BOLD    = "\033[1m";
    private static final String RED     = "\033[31m";
    private static final String GREEN   = "\033[32m";
    private static final String YELLOW  = "\033[33m";
    private static final String BLUE    = "\033[34m";
    private static final String PURPLE  = "\033[35m";
    private static final String CYAN    = "\033[36m";
    private static final String WHITE   = "\033[37m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library("City University Library");
        preloadData(library);

        System.out.println(BOLD + CYAN + "╔══════════════════════════════════════════╗" + RESET);
        System.out.println(BOLD + CYAN + "║                                          ║" + RESET);
        System.out.println(BOLD + CYAN + "║     📚  " + BOLD + WHITE + "CITY UNIVERSITY" + BOLD + CYAN + "                 ║" + RESET);
        System.out.println(BOLD + CYAN + "║         " + CYAN + "Library Management System " + BOLD + CYAN + "     ║" + RESET);
        System.out.println(BOLD + CYAN + "║                                          ║" + RESET);
        System.out.println(BOLD + CYAN + "╚══════════════════════════════════════════╝" + RESET);

        boolean running = true;
        while (running) {
            printMainMenu();
            System.out.print(BOLD + WHITE + "  Enter your choice: " + RESET);
            int choice = getIntInput(scanner);

            switch (choice) {
                case 1:  addBookMenu(scanner, library);      break;
                case 2:  addMagazineMenu(scanner, library);  break;
                case 3:  addMemberMenu(scanner, library);    break;
                case 4:  library.displayAllItems();          break;
                case 5:  library.displayAllMembers();        break;
                case 6:  borrowItemMenu(scanner, library);   break;
                case 7:  returnItemMenu(scanner, library);   break;
                case 8:  searchMenu(scanner, library);       break;
                case 9:  deleteItemMenu(scanner, library);   break;
                case 10: deleteMemberMenu(scanner, library); break;
                case 0:
                    System.out.println("\n" + BOLD + CYAN + "  Thanks for using the Library System. Goodbye! 👋" + RESET + "\n");
                    running = false;
                    break;
                default:
                    System.out.println(BOLD + RED + "  ✘ Invalid choice. Please try again." + RESET);
            }
        }
        scanner.close();
    }

    static void printMainMenu() {
        System.out.println("\n" + BOLD + BLUE + "╔══════════════════════════════════╗" + RESET);
        System.out.println(BOLD + BLUE +        "║       📋  " + BOLD + WHITE + "MAIN MENU" + BOLD + BLUE + "            ║" + RESET);
        System.out.println(BOLD + BLUE +        "╠══════════════════════════════════╣" + RESET);
        System.out.println(BOLD + BLUE +        "║  " + BOLD + GREEN  + "1.  Add New Book          " + BOLD + BLUE + "      ║" + RESET);
        System.out.println(BOLD + BLUE +        "║  " + BOLD + GREEN  + "2.  Add New Magazine      " + BOLD + BLUE + "      ║" + RESET);
        System.out.println(BOLD + BLUE +        "║  " + BOLD + GREEN  + "3.  Register New Member   " + BOLD + BLUE + "      ║" + RESET);
        System.out.println(BOLD + BLUE +        "║  " + BOLD + YELLOW + "4.  Display All Items     " + BOLD + BLUE + "      ║" + RESET);
        System.out.println(BOLD + BLUE +        "║  " + BOLD + YELLOW + "5.  Display All Members   " + BOLD + BLUE + "      ║" + RESET);
        System.out.println(BOLD + BLUE +        "║  " + CYAN          + "6.  Borrow Item           " + BOLD + BLUE + "      ║" + RESET);
        System.out.println(BOLD + BLUE +        "║  " + CYAN          + "7.  Return Item           " + BOLD + BLUE + "      ║" + RESET);
        System.out.println(BOLD + BLUE +        "║  " + PURPLE        + "8.  Search Item by Title  " + BOLD + BLUE + "      ║" + RESET);
        System.out.println(BOLD + BLUE +        "║  " + BOLD + RED    + "9.  Delete Item           " + BOLD + BLUE + "      ║" + RESET);
        System.out.println(BOLD + BLUE +        "║  " + BOLD + RED    + "10. Delete Member         " + BOLD + BLUE + "      ║" + RESET);
        System.out.println(BOLD + BLUE +        "║  " + WHITE         + "0.  Exit                  " + BOLD + BLUE + "      ║" + RESET);
        System.out.println(BOLD + BLUE +        "╚══════════════════════════════════╝" + RESET);
    }

    static void addBookMenu(Scanner scanner, Library library) {
        System.out.println("\n" + BOLD + GREEN + "┌─────────────────────────────┐" + RESET);
        System.out.println(BOLD + GREEN        + "│       ➕  Add New Book       │" + RESET);
        System.out.println(BOLD + GREEN        + "└─────────────────────────────┘" + RESET);
        System.out.print(GREEN + "  Book ID   : " + RESET); String id     = scanner.nextLine();
        System.out.print(GREEN + "  Title     : " + RESET); String title  = scanner.nextLine();
        System.out.print(GREEN + "  Author    : " + RESET); String author = scanner.nextLine();
        System.out.print(GREEN + "  ISBN      : " + RESET); String isbn   = scanner.nextLine();
        System.out.print(GREEN + "  Pages     : " + RESET); int pages     = getIntInput(scanner);
        System.out.print(GREEN + "  Genre     : " + RESET); String genre  = scanner.nextLine();
        library.addItem(new Book(id, title, author, isbn, pages, genre));
    }

    static void addMagazineMenu(Scanner scanner, Library library) {
        System.out.println("\n" + BOLD + GREEN + "┌─────────────────────────────┐" + RESET);
        System.out.println(BOLD + GREEN        + "│     ➕  Add New Magazine     │" + RESET);
        System.out.println(BOLD + GREEN        + "└─────────────────────────────┘" + RESET);
        System.out.print(GREEN + "  Magazine ID : " + RESET); String id        = scanner.nextLine();
        System.out.print(GREEN + "  Title       : " + RESET); String title     = scanner.nextLine();
        System.out.print(GREEN + "  Publisher   : " + RESET); String publisher = scanner.nextLine();
        System.out.print(GREEN + "  Issue No.   : " + RESET); int issue        = getIntInput(scanner);
        System.out.print(GREEN + "  Month       : " + RESET); String month     = scanner.nextLine();
        System.out.print(GREEN + "  Category    : " + RESET); String category  = scanner.nextLine();
        library.addItem(new Magazine(id, title, publisher, issue, month, category));
    }

    static void addMemberMenu(Scanner scanner, Library library) {
        System.out.println("\n" + BOLD + GREEN + "┌─────────────────────────────┐" + RESET);
        System.out.println(BOLD + GREEN        + "│   ➕  Register New Member    │" + RESET);
        System.out.println(BOLD + GREEN        + "└─────────────────────────────┘" + RESET);
        System.out.print(GREEN + "  Member ID : " + RESET); String id    = scanner.nextLine();
        System.out.print(GREEN + "  Name      : " + RESET); String name  = scanner.nextLine();
        System.out.print(GREEN + "  Email     : " + RESET); String email = scanner.nextLine();
        System.out.print(GREEN + "  Phone     : " + RESET); String phone = scanner.nextLine();
        library.addMember(new Member(id, name, email, phone));
    }

    static void borrowItemMenu(Scanner scanner, Library library) {
        System.out.println("\n" + BOLD + CYAN + "┌─────────────────────────────┐" + RESET);
        System.out.println(BOLD + CYAN        + "│       📤  Borrow Item        │" + RESET);
        System.out.println(BOLD + CYAN        + "└─────────────────────────────┘" + RESET);
        System.out.print(CYAN + "  Enter Member ID : " + RESET); String memberId = scanner.nextLine();
        System.out.print(CYAN + "  Enter Item ID   : " + RESET); String itemId   = scanner.nextLine();
        library.borrowItem(memberId, itemId);
    }

    static void returnItemMenu(Scanner scanner, Library library) {
        System.out.println("\n" + BOLD + CYAN + "┌─────────────────────────────┐" + RESET);
        System.out.println(BOLD + CYAN        + "│       📥  Return Item        │" + RESET);
        System.out.println(BOLD + CYAN        + "└─────────────────────────────┘" + RESET);
        System.out.print(CYAN + "  Enter Member ID : " + RESET); String memberId = scanner.nextLine();
        System.out.print(CYAN + "  Enter Item ID   : " + RESET); String itemId   = scanner.nextLine();
        library.returnItem(memberId, itemId);
    }

    static void searchMenu(Scanner scanner, Library library) {
        System.out.println("\n" + BOLD + PURPLE + "┌─────────────────────────────┐" + RESET);
        System.out.println(BOLD + PURPLE        + "│       🔍  Search Item        │" + RESET);
        System.out.println(BOLD + PURPLE        + "└─────────────────────────────┘" + RESET);
        System.out.print(PURPLE + "  Enter title keyword: " + RESET); String keyword = scanner.nextLine();
        library.searchItemByTitle(keyword);
    }

    static void deleteItemMenu(Scanner scanner, Library library) {
        System.out.println("\n" + BOLD + RED + "┌─────────────────────────────┐" + RESET);
        System.out.println(BOLD + RED        + "│       🗑️   Delete Item        │" + RESET);
        System.out.println(BOLD + RED        + "└─────────────────────────────┘" + RESET);
        System.out.print(RED + "  Enter Item ID to delete: " + RESET); String itemId = scanner.nextLine();
        library.deleteItem(itemId);
    }

    static void deleteMemberMenu(Scanner scanner, Library library) {
        System.out.println("\n" + BOLD + RED + "┌─────────────────────────────┐" + RESET);
        System.out.println(BOLD + RED        + "│      🗑️   Delete Member       │" + RESET);
        System.out.println(BOLD + RED        + "└─────────────────────────────┘" + RESET);
        System.out.print(RED + "  Enter Member ID to delete: " + RESET); String memberId = scanner.nextLine();
        library.deleteMember(memberId);
    }

    static int getIntInput(Scanner scanner) {
        while (true) {
            try { return Integer.parseInt(scanner.nextLine()); }
            catch (NumberFormatException e) {
                System.out.print(BOLD + RED + "  Please enter a valid number: " + RESET);
            }
        }
    }

    // ── PRELOAD DATA (silent - no console output) ─────────────────────────
    // TO CUSTOMIZE: edit the names, IDs, emails etc. below freely

    static void preloadData(Library library) {
        // ── 10 BOOKS ──────────────────────────────────────────────────────
        library.addItem(new Book("B001", "Clean Code",                            "Robert C. Martin",    "978-0132350884", 431,  "Programming"), true);
        library.addItem(new Book("B002", "The Great Gatsby",                      "F. Scott Fitzgerald", "978-0743273565", 180,  "Fiction"),     true);
        library.addItem(new Book("B003", "Introduction to Java",                  "Herbert Schildt",     "978-1260440232", 1312, "Education"),   true);
        library.addItem(new Book("B004", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling",        "978-0439708180", 309,  "Fantasy"),     true);
        library.addItem(new Book("B005", "The Pragmatic Programmer",              "Andrew Hunt",         "978-0135957059", 352,  "Programming"), true);
        library.addItem(new Book("B006", "To Kill a Mockingbird",                 "Harper Lee",          "978-0061935466", 281,  "Fiction"),     true);
        library.addItem(new Book("B007", "Artificial Intelligence",               "Stuart Russell",      "978-0134610993", 1132, "Education"),   true);
        library.addItem(new Book("B008", "Design Patterns",                       "Erich Gamma",         "978-0201633610", 395,  "Programming"), true);
        library.addItem(new Book("B009", "Sapiens: A Brief History",              "Yuval Noah Harari",   "978-0062316097", 443,  "History"),     true);
        library.addItem(new Book("B010", "The Alchemist",                         "Paulo Coelho",        "978-0062315007", 208,  "Fiction"),     true);

        // ── 5 MAGAZINES ───────────────────────────────────────────────────
        library.addItem(new Magazine("M001", "National Geographic",  "National Geographic Society", 215, "March 2025",    "Science"),    true);
        library.addItem(new Magazine("M002", "TIME Magazine",        "TIME USA LLC",                198, "January 2025",  "News"),       true);
        library.addItem(new Magazine("M003", "Forbes",               "Forbes Media LLC",            310, "February 2025", "Business"),   true);
        library.addItem(new Magazine("M004", "Scientific American",  "Springer Nature",             402, "April 2025",    "Science"),    true);
        library.addItem(new Magazine("M005", "Wired",                "Conde Nast",                  287, "March 2025",    "Technology"), true);

        // ── 10 MEMBERS ────────────────────────────────────────────────────
        library.addMember(new Member("MEM001", "Ahmad Rizal",    "ahmad@email.com",   "012-3456789"), true);
        library.addMember(new Member("MEM002", "Siti Nurhaliza", "siti@email.com",    "011-9876543"), true);
        library.addMember(new Member("MEM003", "Raj Kumar",      "raj@email.com",     "013-1122334"), true);
        library.addMember(new Member("MEM004", "Aisha Mohamed",  "aisha@email.com",   "014-5566778"), true);
        library.addMember(new Member("MEM005", "James Tan",      "james@email.com",   "016-9988776"), true);
        library.addMember(new Member("MEM006", "Nurul Huda",     "nurul@email.com",   "017-3344556"), true);
        library.addMember(new Member("MEM007", "Kevin Lim",      "kevin@email.com",   "018-7788990"), true);
        library.addMember(new Member("MEM008", "Fatimah Zahra",  "fatimah@email.com", "019-2233445"), true);
        library.addMember(new Member("MEM009", "Daniel Wong",    "daniel@email.com",  "010-6677889"), true);
        library.addMember(new Member("MEM010", "Priya Sharma",   "priya@email.com",   "011-4455667"), true);
    }
}
