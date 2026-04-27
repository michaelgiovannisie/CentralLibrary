package com.zipcodewilmington.centrallibrary;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.exceptions.CsvValidationException;

public class PeriodicalLoader {

    public void loadPeriodical(String filePath, Library library) {
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
                    // System.out.println("Invalid number in row: " + line);
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}