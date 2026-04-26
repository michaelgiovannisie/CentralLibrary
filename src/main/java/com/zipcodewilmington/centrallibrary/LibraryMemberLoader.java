package com.zipcodewilmington.centrallibrary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LibraryMemberLoader {
    public void loadLibraryMember(String filePath, Library library) {
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
                String name = parts[0].trim();
                String ageStr = parts[1].trim();
                String email = parts[2].trim();
                String phoneNumber = parts[3].trim();
                String memberId = parts[4].trim();
                String membershipDate = parts[5].trim();
                String addressStr = parts[6].trim();
                String cleanAddress = addressStr.replaceAll("^\"|\"$", ""); 
                String[] addressParts = cleanAddress.split(",");
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}  
