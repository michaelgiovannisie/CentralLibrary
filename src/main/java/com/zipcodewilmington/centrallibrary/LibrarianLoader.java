package com.zipcodewilmington.centrallibrary;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.exceptions.CsvValidationException;

public class LibrarianLoader {
    public void loadLibrarian(String filePath, Library library) {
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
                String employeeId = parts[4].trim();
                String department = parts[5].trim();
                String salaryStr = parts[6].trim();
                try {
                    int age = Integer.parseInt(ageStr);
                    double salary = Double.parseDouble(salaryStr);
                    Librarian librarian = new Librarian(name,age,email,phoneNumber,employeeId,department,salary);
                    library.addLibrarian(librarian);
                } catch (NumberFormatException e) {
                    // System.out.println("Invalid number in row: " + line);
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
