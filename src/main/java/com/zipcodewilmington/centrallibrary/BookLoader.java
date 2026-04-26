package com.zipcodewilmington.centrallibrary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BookLoader {
    public void loadBooks(String filePath, Library library) {
        try (BufferedReader buffer = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;
            while ((line = buffer.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if (parts.length < 7) {
                    System.out.println("Skipping invalid row: " + line);
                    continue;
                }
                String id = parts[0].trim();
                String title = parts[1].trim();
                String location = parts[2].trim();
                String author = parts[3].replace("\"", "").trim();
                String isbn = parts[4].trim();
                String pagesStr = parts[5].trim();
                String genre = parts[6].replace("\"", "").trim();
                String[] genreParts = genre.split(";");
                String genreClean = genreParts[0].trim();
                try {
                    int pages = Integer.parseInt(pagesStr);
                    Book book = new Book(id,title,location,author,isbn,pages,genreClean);
                    library.addItem(book);
                } catch (NumberFormatException e) {
                    // System.out.println("Invalid number in row: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}