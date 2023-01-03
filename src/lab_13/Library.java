package lab_13;

import helper.Input;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {
    private static final String relativePath = "\\src\\lab_13\\BookData.txt";
    public static String path = System.getProperty("user.dir") + relativePath;
    static List<Book> bookList = Library.readBooksFromFile();

    public static List<Book> readBooksFromFile() {
        List<Book> bookList = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(path);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
//            Loop all line
            String dataLine = bufferedReader.readLine();
            if (dataLine != null) {
                while (dataLine != null) {
                    String[] dataLineArray = dataLine.split(",");
                    System.out.println(Arrays.toString(dataLineArray));
                    int isbn = Integer.parseInt(dataLineArray[0]);
                    String title = dataLineArray[1];
                    String author = dataLineArray[2];
                    int year = Integer.parseInt(dataLineArray[3]);
                    bookList.add(new Book(isbn, title, author, year));
                    dataLine = bufferedReader.readLine();
                }
            }
            return bookList;
        } catch (Exception e) {
            e.printStackTrace();
            String path = Input.getStringInputValue("Please provide new path: ");
            Library.setPath(path);
            return readBooksFromFile();
        }
    }

    public static void saveBooksToFile(List<Book> bookList) {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(path);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)
        ) {
            for (Book book : bookList) {
                bufferedWriter.write(book.toString());
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setPath(String path) {
        Library.path = System.getProperty("user.dir") + path;
    }

    @Override
    public String toString() {
        if (!bookList.isEmpty()) {
            StringBuilder bookListString = new StringBuilder();
            for (int i = 0; i < bookList.size(); i++) {
                String bookString = String.format("Book %2d: %s\n" +
                                "    ISBN: %.0f\n" +
                                "    author: %s\n" +
                                "    year: %d\n", i + 1,
                        bookList.get(i).getTitle(),
                        bookList.get(i).getIsbn(),
                        bookList.get(i).getAuthor(),
                        bookList.get(i).getYear());
                bookListString.append(bookString);
            }
            return bookListString.toString();
        } else {
            return "The book list is empty";
        }
    }

}
