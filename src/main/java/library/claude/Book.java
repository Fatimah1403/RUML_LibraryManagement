package library.claude;

 //Book class - inherits from LibraryItem (root of dependency channel)
public class Book extends LibraryItem {

    public Book(String title, String isbn) {
        super(title, isbn);
    }

    @Override
    public String getItemType() {
        return "Book";
    }

    @Override
    public String toString() {
        return String.format("Book[title=%s, isbn=%s, available=%s]",
                title, isbn, available);
    }
}
