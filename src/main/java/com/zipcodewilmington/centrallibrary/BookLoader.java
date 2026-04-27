package com.zipcodewilmington.centrallibrary;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.exceptions.CsvValidationException;

public class BookLoader {
    public void loadBooks(String filePath, Library library) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] parts;
            reader.readNext();
            while ((parts = reader.readNext()) != null) {
                if (parts.length < 7) {
                    System.out.println("Skipping invalid row: ");
                    continue;
                }
                String id = parts[0].trim();
                String title = parts[1].trim();
                String location = parts[2].trim();
                String author = parts[3].trim();
                String isbn = parts[4].trim();
                String pagesStr = parts[5].trim();
                String genre = parts[6].trim();
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
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}