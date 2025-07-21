package library.claude;
import java.util.*;

// Library class - depends on Member and LibraryItem (→ Member, → LibraryItem)

public class Library {
    private String name;
    private List<Member> members;
    private List<LibraryItem> items;

    public Library(String name) {
        this.name = name;
        this.members = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Member> getMembers() {
        return new ArrayList<>(members);
    }

    public List<LibraryItem> getItems() {
        return new ArrayList<>(items);
    }

    public void addMember(Member member) {
        if (member != null && !members.contains(member)) {
            members.add(member);
        }
    }

    public void addItem(LibraryItem item) {
        if (item != null && !items.contains(item)) {
            items.add(item);
        }
    }

    public LibraryItem findItem(String title) {
        return items.stream()
                .filter(item -> item.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    public LibraryItem findItemByISBN(String isbn) {
        return items.stream()
                .filter(item -> item.getISBN().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    public Member findMember(String memberId) {
        return members.stream()
                .filter(member -> member.getMemberId().equals(memberId))
                .findFirst()
                .orElse(null);
    }

    public boolean checkoutItem(String memberId, String itemTitle) {
        Member member = findMember(memberId);
        LibraryItem item = findItem(itemTitle);

        if (member != null && item != null && item.isAvailable()) {
            return member.borrowItem(item);
        }
        return false;
    }

    public boolean returnItem(String memberId, String itemTitle) {
        Member member = findMember(memberId);
        LibraryItem item = findItem(itemTitle);

        if (member != null && item != null) {
            return member.returnItem(item);
        }
        return false;
    }

    public List<LibraryItem> getAvailableItems() {
        return items.stream()
                .filter(LibraryItem::isAvailable)
                .collect(ArrayList::new,
                        (list, item) -> list.add(item),
                        (list1, list2) -> list1.addAll(list2));
    }

    public int getTotalItems() {
        return items.size();
    }

    public int getTotalMembers() {
        return members.size();
    }

    @Override
    public String toString() {
        return String.format("Library[name=%s, members=%d, items=%d]",
                name, members.size(), items.size());
    }
}

