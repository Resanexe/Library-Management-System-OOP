import java.util.Scanner;

// Main class - Entry point of the application
// Demonstrates control structures, Scanner input, and menu-driven flow
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create a Library object
        Library library = new Library("City University Library");

        // Pre-load some sample data so the system isn't empty on start
        preloadData(library);

        System.out.println("=========================================");
        System.out.println("   Welcome to " + library.getLibraryName());
        System.out.println("=========================================");

        boolean running = true;

        while (running) {
            printMainMenu();
            System.out.print("Enter your choice: ");
            int choice = getIntInput(scanner);

            switch (choice) {
                case 1:
                    addBookMenu(scanner, library);
                    break;
                case 2:
                    addMagazineMenu(scanner, library);
                    break;
                case 3:
                    addMemberMenu(scanner, library);
                    break;
                case 4:
                    library.displayAllItems();
                    break;
                case 5:
                    library.displayAllMembers();
                    break;
                case 6:
                    borrowItemMenu(scanner, library);
                    break;
                case 7:
                    returnItemMenu(scanner, library);
                    break;
                case 8:
                    searchMenu(scanner, library);
                    break;
                case 0:
                    System.out.println("Thank you for using the Library System. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // ---- MENU DISPLAY ----

    static void printMainMenu() {
        System.out.println("\n========= MAIN MENU =========");
        System.out.println(" 1. Add New Book");
        System.out.println(" 2. Add New Magazine");
        System.out.println(" 3. Register New Member");
        System.out.println(" 4. Display All Items");
        System.out.println(" 5. Display All Members");
        System.out.println(" 6. Borrow Item");
        System.out.println(" 7. Return Item");
        System.out.println(" 8. Search Item by Title");
        System.out.println(" 0. Exit");
        System.out.println("=============================");
    }

    // ---- ADD BOOK ----

    static void addBookMenu(Scanner scanner, Library library) {
        System.out.println("\n--- Add New Book ---");
        System.out.print("Book ID   : ");
        String id = scanner.nextLine();
        System.out.print("Title     : ");
        String title = scanner.nextLine();
        System.out.print("Author    : ");
        String author = scanner.nextLine();
        System.out.print("ISBN      : ");
        String isbn = scanner.nextLine();
        System.out.print("Pages     : ");
        int pages = getIntInput(scanner);
        System.out.print("Genre     : ");
        String genre = scanner.nextLine();

        Book book = new Book(id, title, author, isbn, pages, genre);
        library.addItem(book);
    }

    // ---- ADD MAGAZINE ----

    static void addMagazineMenu(Scanner scanner, Library library) {
        System.out.println("\n--- Add New Magazine ---");
        System.out.print("Magazine ID : ");
        String id = scanner.nextLine();
        System.out.print("Title       : ");
        String title = scanner.nextLine();
        System.out.print("Publisher   : ");
        String publisher = scanner.nextLine();
        System.out.print("Issue No.   : ");
        int issue = getIntInput(scanner);
        System.out.print("Month       : ");
        String month = scanner.nextLine();
        System.out.print("Category    : ");
        String category = scanner.nextLine();

        Magazine magazine = new Magazine(id, title, publisher, issue, month, category);
        library.addItem(magazine);
    }

    // ---- ADD MEMBER ----

    static void addMemberMenu(Scanner scanner, Library library) {
        System.out.println("\n--- Register New Member ---");
        System.out.print("Member ID : ");
        String id = scanner.nextLine();
        System.out.print("Name      : ");
        String name = scanner.nextLine();
        System.out.print("Email     : ");
        String email = scanner.nextLine();
        System.out.print("Phone     : ");
        String phone = scanner.nextLine();

        Member member = new Member(id, name, email, phone);
        library.addMember(member);
    }

    // ---- BORROW ----

    static void borrowItemMenu(Scanner scanner, Library library) {
        System.out.println("\n--- Borrow Item ---");
        System.out.print("Enter Member ID : ");
        String memberId = scanner.nextLine();
        System.out.print("Enter Item ID   : ");
        String itemId = scanner.nextLine();
        library.borrowItem(memberId, itemId);
    }

    // ---- RETURN ----

    static void returnItemMenu(Scanner scanner, Library library) {
        System.out.println("\n--- Return Item ---");
        System.out.print("Enter Member ID : ");
        String memberId = scanner.nextLine();
        System.out.print("Enter Item ID   : ");
        String itemId = scanner.nextLine();
        library.returnItem(memberId, itemId);
    }

    // ---- SEARCH ----

    static void searchMenu(Scanner scanner, Library library) {
        System.out.println("\n--- Search Item ---");
        System.out.print("Enter title keyword: ");
        String keyword = scanner.nextLine();
        library.searchItemByTitle(keyword);
    }

    // ---- HELPER: safe int input ----

    static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                int val = Integer.parseInt(scanner.nextLine());
                return val;
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    // ---- PRE-LOAD SAMPLE DATA ----

    static void preloadData(Library library) {
        // Sample Books
        library.addItem(new Book("B001", "Clean Code", "Robert C. Martin", "978-0132350884", 431, "Programming"));
        library.addItem(new Book("B002", "The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565", 180, "Fiction"));
        library.addItem(new Book("B003", "Introduction to Java", "Herbert Schildt", "978-1260440232", 1312, "Education"));

        // Sample Magazines
        library.addItem(new Magazine("M001", "National Geographic", "National Geographic Society", 215, "March 2025", "Science"));
        library.addItem(new Magazine("M002", "TIME Magazine", "TIME USA LLC", 198, "January 2025", "News"));

        // Sample Members
        library.addMember(new Member("MEM001", "Ahmad Rizal", "ahmad@email.com", "012-3456789"));
        library.addMember(new Member("MEM002", "Siti Nurhaliza", "siti@email.com", "011-9876543"));
    }
}
