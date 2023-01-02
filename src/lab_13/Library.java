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
        try (FileInputStream fileInputStream = new FileInputStream(path);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ) {
            List<Book> bookList = new ArrayList<>();
//            Loop all line
            String dataLine = bufferedReader.readLine();
            while (dataLine != null) {
                String[] dataLineArr = dataLine.split(",");
                System.out.println(Arrays.toString(dataLineArr));
                int isbn = Integer.parseInt(dataLineArr[0]);
                String title = dataLineArr[1];
                String author = dataLineArr[2];
                int year = Integer.parseInt(dataLineArr[3]);
                bookList.add(new Book(isbn, title, author, year));
                dataLine = bufferedReader.readLine();
            }
            return bookList;
        } catch (Exception e) {
            System.out.println("Cant found file from the path" + e);
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
    }
}
