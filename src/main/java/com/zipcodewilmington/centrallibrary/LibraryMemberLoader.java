package com.zipcodewilmington.centrallibrary;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.exceptions.CsvValidationException;

public class LibraryMemberLoader {
    public void loadLibraryMember(String filePath, Library library) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] parts;
            reader.readNext();
            while ((parts = reader.readNext()) != null) {
                if (parts.length < 7) {
                    System.out.println("Skipping invalid row: ");
                    continue;
                }
                String name = parts[0].trim();
                String ageStr = parts[1].trim();
                String email = parts[2].trim();
                String phoneNumber = parts[3].trim();
                String memberId = parts[4].trim();
                String membershipDate = parts[5].trim();
                String addressStr = parts[6].trim();
                String[] addressParts = addressStr.split("'");
                String street = addressParts[0].trim();
                String city = addressParts[1].trim();
                String state = addressParts[2].trim();
                String zip = addressParts[3].trim();
                Address address = new Address(street, city, state, zip);
                try {
                    int age = Integer.parseInt(ageStr);
                    LibraryMember libraryMember = new LibraryMember(name,age,email,phoneNumber,memberId,membershipDate,address);
                    library.addMember(libraryMember);
                } catch (NumberFormatException e) {
                    // System.out.println("Invalid number in row: " + line);
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}  
