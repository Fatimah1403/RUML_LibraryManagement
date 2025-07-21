package library.grok;
import java.util.ArrayList;
import java.util.List;
public class LibrarySystemWhole {


    public interface LibraryItem {
        boolean isAvailable();
        String getItemId();
        String getType();
    }

    public abstract class Book implements LibraryItem {
        private String title;
        private String isbn;
        private boolean available;
        private String itemId;
        private String type;

        public Book(String itemId, String title, String isbn, String type) {
            this.itemId = itemId;
            this.title = title;
            this.isbn = isbn;
            this.available = true;
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public String getISBN() {
            return isbn;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }

        @Override
        public String getItemId() {
            return itemId;
        }

        @Override
        public String getType() {
            return type;
        }
    }

    public class TextBook extends Book {
        private String subject;
        private int edition;

        public TextBook(String itemId, String title, String isbn, String subject, int edition) {
            super(itemId, title, isbn, "TextBook");
            this.subject = subject;
            this.edition = edition;
        }

        public String getSubject() {
            return subject;
        }

        public int getEdition() {
            return edition;
        }
    }

    public class AudioBook extends Book {
        private int duration;
        private String narrator;

        public AudioBook(String itemId, String title, String isbn, int duration, String narrator) {
            super(itemId, title, isbn, "AudioBook");
            this.duration = duration;
            this.narrator = narrator;
        }

        public int getDuration() {
            return duration;
        }

        public String getNarrator() {
            return narrator;
        }
    }

    public class Member {
        private String memberId;
        private String name;
        private List<LibraryItem> borrowedItems;

        public Member(String memberId, String name) {
            this.memberId = memberId;
            this.name = name;
            this.borrowedItems = new ArrayList<>();
        }

        public void borrowItem(LibraryItem item) {
            if (item.isAvailable()) {
                borrowedItems.add(item);
                if (item instanceof Book) {
                    ((Book) item).setAvailable(false);
                }
            }
        }

        public void returnItem(LibraryItem item) {
            if (borrowedItems.remove(item) && item instanceof Book) {
                ((Book) item).setAvailable(true);
            }
        }

        public List<LibraryItem> getBorrowedItems() {
            return new ArrayList<>(borrowedItems); // Return a copy to protect encapsulation
        }

        public String getMemberId() {
            return memberId;
        }

        public String getName() {
            return name;
        }
    }

    public class Library {
        private List<Member> members;
        private List<LibraryItem> items;
        private String name;

        public Library(String name) {
            this.name = name;
            this.members = new ArrayList<>();
            this.items = new ArrayList<>();
        }

        public void addMember(Member member) {
            members.add(member);
        }

        public void addItem(LibraryItem item) {
            items.add(item);
        }

        public LibraryItem findItem(String itemId) {
            for (LibraryItem item : items) {
                if (item.getItemId().equals(itemId)) {
                    return item;
                }
            }
            return null;
        }

        public boolean checkoutItem(Member member, LibraryItem item) {
            if (item.isAvailable() && members.contains(member)) {
                member.borrowItem(item);
                return true;
            }
            return false;
        }

        public String getName() {
            return name;
        }

        public List<Member> getMembers() {
            return new ArrayList<>(members); // Return a copy to protect encapsulation
        }

        public List<LibraryItem> getItems() {
            return new ArrayList<>(items); // Return a copy to protect encapsulation
        }
    }
}
