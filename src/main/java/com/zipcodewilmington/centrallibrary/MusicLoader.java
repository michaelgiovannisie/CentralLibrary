package com.zipcodewilmington.centrallibrary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MusicLoader {
    public void loadMusic(String filePath, Library library) {
        try (BufferedReader buffer = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;
            while((line = buffer.readLine()) != null) {
                if(firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                if(parts.length < 8) {
                    System.out.println("Invalid Data: " + line);
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
