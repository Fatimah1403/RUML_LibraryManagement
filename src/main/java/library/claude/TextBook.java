package library.claude;

// TextBook class - inherits from Book

public class TextBook extends Book {
    private String subject;
    private String edition;

    public TextBook(String title, String isbn, String subject, String edition) {
        super(title, isbn);
        this.subject = subject;
        this.edition = edition;
    }

    public String getSubject() {
        return subject;
    }

    public String getEdition() {
        return edition;
    }

    @Override
    public String getItemType() {
        return "TextBook";
    }

    @Override
    public String toString() {
        return String.format("TextBook[title=%s, isbn=%s, subject=%s, edition=%s, available=%s]",
                title, isbn, subject, edition, available);
    }
}
