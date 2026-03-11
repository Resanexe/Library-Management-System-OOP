import java.util.ArrayList;

// Library class - manages all items and members
// Uses ArrayList to store collections of objects
public class Library {

    private String libraryName;
    private ArrayList<LibraryItem> items;   // Can store Book OR Magazine (Polymorphism)
    private ArrayList<Member> members;

    // Constructor
    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public String getLibraryName() { return libraryName; }

    // ---- ITEM MANAGEMENT ----

    // Add any LibraryItem (Book or Magazine) - Polymorphism in action
    public void addItem(LibraryItem item) {
        items.add(item);
        System.out.println("✔ Item added: " + item.getTitle());
    }

    // Display all items
    public void displayAllItems() {
        if (items.isEmpty()) {
            System.out.println("No items in the library.");
            return;
        }
        System.out.println("\n===== ALL LIBRARY ITEMS =====");
        for (LibraryItem item : items) {
            item.displayInfo(); // POLYMORPHISM - calls the correct displayInfo() at runtime
        }
    }

    // Search item by ID
    public LibraryItem findItemById(String itemId) {
        for (LibraryItem item : items) {
            if (item.getItemId().equalsIgnoreCase(itemId)) {
                return item;
            }
        }
        return null;
    }

    // Search item by title (partial match)
    public void searchItemByTitle(String keyword) {
        boolean found = false;
        System.out.println("\n===== SEARCH RESULTS =====");
        for (LibraryItem item : items) {
            if (item.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                item.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No items found with keyword: " + keyword);
        }
    }

    // ---- MEMBER MANAGEMENT ----

    public void addMember(Member member) {
        members.add(member);
        System.out.println("✔ Member registered: " + member.getName());
    }

    public void displayAllMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }
        System.out.println("\n===== ALL MEMBERS =====");
        for (Member member : members) {
            member.displayInfo();
        }
    }

    public Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equalsIgnoreCase(memberId)) {
                return member;
            }
        }
        return null;
    }

    // ---- BORROW & RETURN ----

    public void borrowItem(String memberId, String itemId) {
        Member member = findMemberById(memberId);
        LibraryItem item = findItemById(itemId);

        if (member == null) {
            System.out.println("✘ Member not found.");
            return;
        }
        if (item == null) {
            System.out.println("✘ Item not found.");
            return;
        }
        if (!item.isAvailable()) {
            System.out.println("✘ Item is currently borrowed.");
            return;
        }
        if (!member.canBorrow()) {
            System.out.println("✘ Member has reached the borrow limit (3 items).");
            return;
        }

        item.setAvailable(false);
        member.borrowItem();
        System.out.println("✔ " + member.getName() + " successfully borrowed: " + item.getTitle());
    }

    public void returnItem(String memberId, String itemId) {
        Member member = findMemberById(memberId);
        LibraryItem item = findItemById(itemId);

        if (member == null) {
            System.out.println("✘ Member not found.");
            return;
        }
        if (item == null) {
            System.out.println("✘ Item not found.");
            return;
        }
        if (item.isAvailable()) {
            System.out.println("✘ This item was not marked as borrowed.");
            return;
        }

        item.setAvailable(true);
        member.returnItem();
        System.out.println("✔ " + member.getName() + " successfully returned: " + item.getTitle());
    }
}
