package com.zipcodewilmington.centrallibrary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PeriodicalLoader {

    public void loadPeriodical(String filePath, Library library) {

        try (BufferedReader buffer = new BufferedReader(new FileReader(filePath))) {
            
            String line;
            boolean firstLine = true;

            while((line = buffer.readLine()) != null) {

                if(firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] parts = line.split(",");

                if(parts.length < 8) {
                    System.out.println("Invalid Data: " + line);
                    continue;
                }

                String id = parts[0].trim();
                String title = parts[1].trim();
                String location = parts[2].trim();
                String publisher = parts[3].trim();
                String issn = parts[4].trim();
                String volumeStr = parts[5].trim();
                String issueNumberStr = parts[6].trim();
                String publicationDate = parts[7].trim();

                try { 
                    int volume = Integer.parseInt(volumeStr);
                    int issueNumber = Integer.parseInt(issueNumberStr);

                    Periodical periodical = new Periodical(id,title,location,publisher,issn,volume,issueNumber,publicationDate);

                    library.addItem(periodical);

                } catch (NumberFormatException e) {
                    System.out.println("Invalid number in row: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}