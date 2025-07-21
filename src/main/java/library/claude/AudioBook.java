package library.claude;

public class AudioBook extends Book{
    private double duration; // in hours
    private String narrator;

    public AudioBook(String title, String isbn, double duration, String narrator) {
        super(title, isbn);
        this.duration = duration;
        this.narrator = narrator;
    }

    public double getDuration() {
        return duration;
    }

    public String getNarrator() {
        return narrator;
    }

    @Override
    public String getItemType() {
        return "AudioBook";
    }

    @Override
    public String toString() {
        return String.format("AudioBook[title=%s, isbn=%s, duration=%.1fh, narrator=%s, available=%s]",
                title, isbn, duration, narrator, available);
    }
}
