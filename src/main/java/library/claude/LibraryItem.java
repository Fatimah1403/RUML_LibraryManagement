package library.claude;

public abstract class LibraryItem {
        protected String title;
        protected String isbn;
        protected boolean available;

        public LibraryItem(String title, String isbn) {
            this.title = title;
            this.isbn = isbn;
            this.available = true;
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

        // Abstract method to be implemented by subclasses
        public abstract String getItemType();

}
