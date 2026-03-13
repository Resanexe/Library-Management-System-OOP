public class Member {

    private static final String RESET  = "\033[0m";
    private static final String BOLD   = "\033[1m";
    private static final String BLUE   = "\033[34m";
    private static final String CYAN   = "\033[36m";
    private static final String GREEN  = "\033[32m";
    private static final String RED    = "\033[31m";
    private static final String YELLOW = "\033[33m";
    private static final String WHITE  = "\033[37m";

    private String memberId;
    private String name;
    private String email;
    private String phoneNumber;
    private int borrowedCount;
    private static final int MAX_BORROW_LIMIT = 3;

    public Member(String memberId, String name, String email, String phoneNumber) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.borrowedCount = 0;
    }

    public String getMemberId()                    { return memberId; }
    public void setMemberId(String id)             { this.memberId = id; }
    public String getName()                        { return name; }
    public void setName(String name)               { this.name = name; }
    public String getEmail()                       { return email; }
    public void setEmail(String email)             { this.email = email; }
    public String getPhoneNumber()                 { return phoneNumber; }
    public void setPhoneNumber(String phone)       { this.phoneNumber = phone; }
    public int getBorrowedCount()                  { return borrowedCount; }

    public boolean canBorrow() { return borrowedCount < MAX_BORROW_LIMIT; }
    public void borrowItem()   { if (canBorrow()) borrowedCount++; }
    public void returnItem()   { if (borrowedCount > 0) borrowedCount--; }

    public void displayInfo() {
        System.out.println(BLUE + "  ┌──────────────────────────────────────┐" + RESET);
        System.out.println(BLUE + "  │  👤  " + BOLD + WHITE + "MEMBER" + RESET + BLUE + "                               │" + RESET);
        System.out.println(BLUE + "  ├──────────────────────────────────────┤" + RESET);
        System.out.println(BLUE + "  │ " + CYAN   + " ID       : " + RESET + WHITE  + memberId                                    + RESET);
        System.out.println(BLUE + "  │ " + CYAN   + " Name     : " + RESET + WHITE  + name                                        + RESET);
        System.out.println(BLUE + "  │ " + CYAN   + " Email    : " + RESET + WHITE  + email                                       + RESET);
        System.out.println(BLUE + "  │ " + CYAN   + " Phone    : " + RESET + WHITE  + phoneNumber                                 + RESET);
        System.out.println(BLUE + "  │ " + CYAN   + " Borrowed : " + RESET + YELLOW + borrowedCount + "/" + MAX_BORROW_LIMIT      + RESET);
        System.out.println(BLUE + "  └──────────────────────────────────────┘" + RESET);
    }
}
