package library.chatgpt;

public class LIbSystemChat {

    // ==============================
// Interface: LibraryItem
// ==============================
    public interface LibraryItem {
        boolean isAvailable();
        void setAvailable(boolean available);
    }

    // ==============================
// Class: Book
// ==============================
    public class Book implements LibraryItem {
        protected String title;
        private boolean available;

        public Book(String title) {
            this.title = title;
            this.available = true;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public boolean isAvailable() {
            return available;
        }

        @Override
        public void setAvailable(boolean available) {
            this.available = available;
        }
    }

    // ==============================
// Class: TextBook
// ==============================
    public class TextBook extends Book {
        public TextBook(String title) {
            super(title);
        }
    }

    // ==============================
// Class: AudioBook
// ==============================
    public class AudioBook extends Book {
        private String isbn;

        public AudioBook(String title, String isbn) {
            super(title);
            this.isbn = isbn;
        }

        public String getISBN() {
            return isbn;
        }
    }

    // ==============================
// Class: Member
// ==============================
    public class Member {
        private String memberId;
        private String name;

        public Member(String memberId, String name) {
            this.memberId = memberId;
            this.name = name;
        }

        public void borrowItem(LibraryItem item) {
            if (item.isAvailable()) {
                item.setAvailable(false);
                System.out.println(name + " borrowed an item.");
            } else {
                System.out.println("Item is not available.");
            }
        }

        public void returnItem(LibraryItem item) {
            item.setAvailable(true);
            System.out.println(name + " returned an item.");
        }
    }

    // ==============================
// Class: Library
// ==============================
    public class Library {
        public void registerMember(Member member) {
            System.out.println("Member registered: " + member);
        }
    }

}
