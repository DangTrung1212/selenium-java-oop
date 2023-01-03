package lab_13;

import helper.Input;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BookManagement {
    static boolean isContinue = true;
    //    get book list from database
    static List<Book> bookList = Library.bookList;

    public static void main(String[] args) {
        while (isContinue) {
            printMenu();
            int option = Input.getIntInputValue("Enter option: ");
            handleInputOption(option);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void printMenu() {
        System.out.println("======= Book Management Program (CRUD)============\n" +
                "1. New book\n" +
                "2. Find a book(ISBN)\n" +
                "3. Update a book\n" +
                "4. Delete a book\n" +
                "5. Print the book list\n" +
                "0. Exit");
    }

    public static void handleInputOption(int option) {
        switch (option) {
            case 0:
                isContinue = false;
                System.out.println("Thank for using this app. ");
                break;
            case 1:
                writeNewBook();
                break;
            case 2:
                findBook();
                break;
            case 3:
                updateBook();
                break;
            case 4:
                deleteBook();
                break;
            case 5:
                printBookList();
                break;
            default:
                System.out.println("Please enter valid option. ");
        }
    }

    public static Book findBook() {
        int isbn = Input.getIntInputValue("Please enter ISBN of the book you want to create/update/delete/: ");
        Book foundBook = null;
        for (Book book : bookList) {
            if (book.getIsbn() == isbn) {
                foundBook = book;
                break;
            }
        }
        System.out.println(Book.toString(foundBook));
        return foundBook;
    }

    public static void writeNewBook() {
//        input ISBN of the book
        double isbn = Input.getDoubleInputValue("Enter book isbn: ");
//        check if it already existed or not
        if (!isTheBookExisted(isbn)) {
            String title = Input.getStringInputValue("Enter book title: ");
            String author = Input.getStringInputValue("Enter book author: ");
            int year = Input.getIntInputValue("Enter publish year: ");
//        write book into file
            Book book = new Book(isbn, title, author, year);
            bookList.add(book);
            Library.saveBooksToFile(bookList);
            System.out.println("Book: " + book + " has successfully saved to file");
        } else {
            writeNewBook();
        }
    }

    public static boolean isTheBookExisted(double isbn) {
        boolean isExisted = false;
        for (Book book : bookList) {
            if (book.getIsbn() == isbn) {
                System.out.println("The book has ISBN you enter is already existed, please enter other ISBN");
                isExisted = true;
                break;
            }
        }
        return isExisted;
    }

    public static void updateBook() {
        Book foundBook = findBook();
        if (foundBook != null) {
            String title = Input.getStringInputValue("Enter title you want to update: ");
            title = title.equals("") ? foundBook.getTitle() : title;
            String author = Input.getStringInputValue("Enter author you want to update: ");
            author = author.equals("") ? foundBook.getAuthor() : author;
            int year = foundBook.getYear();
            try {
                year = Input.getIntInputValue("Enter year you want to update: ");
            } catch (Exception e) {
                System.out.println("Not valid year format, using previous year");
            } finally {
                Book editedBook = new Book(foundBook.getIsbn(), title, author, year);
                bookList.set(bookList.indexOf(foundBook), editedBook);
            }
        }
        Library.saveBooksToFile(bookList);


    }

    public static void deleteBook() {
        Book deletedBook = findBook();
        if (deletedBook!=null) {
            bookList.remove(deletedBook);
            Library.saveBooksToFile(bookList);
            System.out.printf("The Book with ISBN = %.0f is successfully deleted\n", deletedBook.getIsbn());

        }
    }

    public static void printBookList() {
        System.out.println(new Library());
    }

}
