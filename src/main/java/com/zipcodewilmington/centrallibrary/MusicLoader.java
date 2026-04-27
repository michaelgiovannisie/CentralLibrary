package com.zipcodewilmington.centrallibrary;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.exceptions.CsvValidationException;

public class MusicLoader {
    public void loadMusic(String filePath, Library library) {
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
                String artist = parts[3].trim();
                String date = parts[4].trim();
                String genre = parts[5].trim();
                String lyrics = parts[6].trim();
                String lengthStr = parts[7].trim();
                try { 
                    int length = Integer.parseInt(lengthStr);
                    Music music = new Music(id,title,location,artist,date,genre,lyrics,length);
                    library.addItem(music);
                } catch (NumberFormatException e) {
                    // System.out.println("Invalid number in row: " + line);
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
