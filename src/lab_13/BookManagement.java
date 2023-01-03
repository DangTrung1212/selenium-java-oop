package lab_13;

import helper.Input;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

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
                findBooks();
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

    public static List<Book> findBooks() {
        int isbn = Input.getIntInputValue("Please enter isbn of the book you want to search/update: ");
        List<Book> foundBooks = bookList.stream().filter(book -> book.getIsbn() == isbn)
                .collect(Collectors.toList());
        System.out.println(Library.toString(foundBooks));
        return foundBooks;
    }

    public static void writeNewBook() {
//        input information of the book
        double isbn = Input.getDoubleInputValue("Enter book isbn: ");
        boolean isExistedBook = false;
        for (Book book : bookList) {
            if (book.getIsbn() == isbn) {
                System.out.println("The book has ISBN you enter is already existed, please enter other ISBN");
                isExistedBook = true;
            }
        }
        if (!isExistedBook) {
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

    public static void updateBook() {
        List<Book> updatedBooks = findBooks();
        if (updatedBooks != null) {
            for (Book updatedBook : updatedBooks) {
                String title = Input.getStringInputValue("Enter title you want to update: ");
                title = title.equals("") ? updatedBook.getTitle() : title;
                String author = Input.getStringInputValue("Enter author you want to update: ");
                author = author.equals("") ? updatedBook.getAuthor() : author;
                int year = updatedBook.getYear();
                try {
                    year = Input.getIntInputValue("Enter year you want to update: ");
                } catch (Exception e) {
                    System.out.println("Not valid year format, using previous year");
                } finally {
                    Book editedBook = new Book(updatedBook.getIsbn(), title, author, year);
                    bookList.set(bookList.indexOf(updatedBook), editedBook);
                }
            }
            Library.saveBooksToFile(bookList);
        }


    }

    public static void deleteBook() {
        int isbn = Input.getIntInputValue("Please enter isbn of the book you want to delete: ");
        List<Book> deletedBooks = bookList.stream().filter(book -> book.getIsbn() == isbn)
                .collect(Collectors.toList());
        if (!deletedBooks.isEmpty()) {
            deletedBooks.forEach(deletedBook -> bookList.remove(deletedBook));
            Library.saveBooksToFile(bookList);
            System.out.println("The Book with ISBN = " + isbn + " is successfully deleted");

        } else {
            System.out.println("There is no book which has isbn you entered.");
        }
    }

    public static void printBookList() {
        System.out.println(new Library());
    }

}
