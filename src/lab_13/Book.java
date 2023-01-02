package lab_13;

public class Book {
    private final double isbn;
    private final String title;
    private final String author;
    private final int year;

    public Book(double iSBN, String title, String author, int year) {
        this.isbn = iSBN;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public double getIsbn() {
        return isbn;
    }


    public String getTitle() {
        return title;
    }


    public String getAuthor() {
        return author;
    }


    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format("%.0f", isbn) + "," + title + "," + author + "," + year;
    }
}
