package library.claude;

// Member class - depends on LibraryItem (→ LibraryItem)
import java.util.*;

public class Member {
    private String memberId;
    private String name;
    private List<LibraryItem> borrowedItems;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedItems = new ArrayList<>();
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public List<LibraryItem> getBorrowedItems() {
        return new ArrayList<>(borrowedItems);
    }

    public boolean borrowItem(LibraryItem item) {
        if (item != null && item.isAvailable()) {
            item.setAvailable(false);
            borrowedItems.add(item);
            return true;
        }
        return false;
    }

    public boolean returnItem(LibraryItem item) {
        if (item != null && borrowedItems.contains(item)) {
            item.setAvailable(true);
            borrowedItems.remove(item);
            return true;
        }
        return false;
    }

    public int getBorrowedItemCount() {
        return borrowedItems.size();
    }

    @Override
    public String toString() {
        return String.format("Member[id=%s, name=%s, borrowedItems=%d]",
                memberId, name, borrowedItems.size());
    }
}


