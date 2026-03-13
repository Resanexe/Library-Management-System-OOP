import java.util.ArrayList;

public class Library {

    private static final String RESET   = "\033[0m";
    private static final String BOLD    = "\033[1m";
    private static final String RED     = "\033[31m";
    private static final String GREEN   = "\033[32m";
    private static final String YELLOW  = "\033[33m";
    private static final String BLUE    = "\033[34m";
    private static final String PURPLE  = "\033[35m";
    private static final String CYAN    = "\033[36m";
    private static final String WHITE   = "\033[37m";

    private String libraryName;
    private ArrayList<LibraryItem> items;
    private ArrayList<Member> members;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.items   = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public String getLibraryName() { return libraryName; }

    // ── ITEM MANAGEMENT ──────────────────────────────────────────────────

    public void addItem(LibraryItem item, boolean silent) {
        items.add(item);
        if (!silent) {
            System.out.println(BOLD + GREEN + "  ✔ Item added: " + WHITE + item.getTitle() + RESET);
        }
    }

    public void addItem(LibraryItem item) { addItem(item, false); }

    public void deleteItem(String itemId) {
        LibraryItem item = findItemById(itemId);
        if (item == null) {
            System.out.println(BOLD + RED + "  ✘ Item not found." + RESET);
            return;
        }
        if (!item.isAvailable()) {
            System.out.println(BOLD + RED + "  ✘ Cannot delete an item that is currently borrowed." + RESET);
            return;
        }
        items.remove(item);
        System.out.println(BOLD + RED + "  🗑  Item deleted: " + WHITE + item.getTitle() + RESET);
    }

    public void displayAllItems() {
        if (items.isEmpty()) {
            System.out.println(YELLOW + "  ⚠ No items in the library." + RESET);
            return;
        }
        System.out.println("\n" + BOLD + YELLOW + "  ═══════════  ALL LIBRARY ITEMS  ═══════════" + RESET);
        for (LibraryItem item : items) {
            item.displayInfo(); // POLYMORPHISM - calls correct displayInfo() at runtime
        }
    }

    public LibraryItem findItemById(String itemId) {
        for (LibraryItem item : items)
            if (item.getItemId().equalsIgnoreCase(itemId)) return item;
        return null;
    }

    public void searchItemByTitle(String keyword) {
        boolean found = false;
        System.out.println("\n" + BOLD + PURPLE + "  ══════════  SEARCH RESULTS  ══════════" + RESET);
        for (LibraryItem item : items) {
            if (item.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                item.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println(YELLOW + "  ⚠ No items found with keyword: \"" + keyword + "\"" + RESET);
        }
    }

    // ── MEMBER MANAGEMENT ────────────────────────────────────────────────

    public void addMember(Member member, boolean silent) {
        members.add(member);
        if (!silent) {
            System.out.println(BOLD + GREEN + "  ✔ Member registered: " + WHITE + member.getName() + RESET);
        }
    }

    public void addMember(Member member) { addMember(member, false); }

    public void deleteMember(String memberId) {
        Member member = findMemberById(memberId);
        if (member == null) {
            System.out.println(BOLD + RED + "  ✘ Member not found." + RESET);
            return;
        }
        if (member.getBorrowedCount() > 0) {
            System.out.println(BOLD + RED + "  ✘ Cannot delete a member who still has borrowed items." + RESET);
            return;
        }
        members.remove(member);
        System.out.println(BOLD + RED + "  🗑  Member deleted: " + WHITE + member.getName() + RESET);
    }

    public void displayAllMembers() {
        if (members.isEmpty()) {
            System.out.println(YELLOW + "  ⚠ No members registered." + RESET);
            return;
        }
        System.out.println("\n" + BOLD + CYAN + "  ═══════════  ALL MEMBERS  ═══════════" + RESET);
        for (Member member : members) {
            member.displayInfo();
        }
    }

    public Member findMemberById(String memberId) {
        for (Member member : members)
            if (member.getMemberId().equalsIgnoreCase(memberId)) return member;
        return null;
    }

    // ── BORROW & RETURN ──────────────────────────────────────────────────

    public void borrowItem(String memberId, String itemId) {
        Member member = findMemberById(memberId);
        LibraryItem item = findItemById(itemId);
        if (member == null)       { System.out.println(BOLD + RED + "  ✘ Member not found." + RESET);                                             return; }
        if (item == null)         { System.out.println(BOLD + RED + "  ✘ Item not found." + RESET);                                               return; }
        if (!item.isAvailable())  { System.out.println(BOLD + RED + "  ✘ Item is currently borrowed by someone else." + RESET);                   return; }
        if (!member.canBorrow())  { System.out.println(BOLD + RED + "  ✘ " + member.getName() + " has reached the borrow limit (3 items)." + RESET); return; }
        item.setAvailable(false);
        member.borrowItem();
        System.out.println(BOLD + GREEN + "  ✔ " + WHITE + member.getName() + CYAN + " borrowed → " + WHITE + item.getTitle() + RESET);
    }

    public void returnItem(String memberId, String itemId) {
        Member member = findMemberById(memberId);
        LibraryItem item = findItemById(itemId);
        if (member == null)      { System.out.println(BOLD + RED + "  ✘ Member not found." + RESET);                    return; }
        if (item == null)        { System.out.println(BOLD + RED + "  ✘ Item not found." + RESET);                      return; }
        if (item.isAvailable())  { System.out.println(BOLD + RED + "  ✘ This item is not currently borrowed." + RESET); return; }
        item.setAvailable(true);
        member.returnItem();
        System.out.println(BOLD + GREEN + "  ✔ " + WHITE + member.getName() + CYAN + " returned → " + WHITE + item.getTitle() + RESET);
    }
}
