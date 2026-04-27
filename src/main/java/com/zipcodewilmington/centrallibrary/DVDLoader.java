package com.zipcodewilmington.centrallibrary;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.exceptions.CsvValidationException;

public class DVDLoader {
    public void loadDVD(String filePath, Library library) {
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
                String director = parts[3].trim();
                String durationStr = parts[4].trim();
                String rating = parts[5].trim();
                String genre = parts[6].trim();
                try { 
                    int duration = Integer.parseInt(durationStr);
                    DVD dvd = new DVD(id,title,location,director,duration,rating,genre);
                    library.addItem(dvd);
                } catch (NumberFormatException e) {
                    // System.out.println("Invalid number in row: " + line);
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
