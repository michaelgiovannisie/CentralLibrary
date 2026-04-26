package com.zipcodewilmington.centrallibrary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DVDLoader {
    public void loadDVD(String filePath, Library library) {
        try (BufferedReader buffer = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;
            while((line = buffer.readLine()) != null) {
                if(firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if(parts.length < 7) {
                    System.out.println("Invalid Data: " + line);
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
