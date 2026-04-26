package com.zipcodewilmington.centrallibrary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LibrarianLoader {
    public void loadLibrarian(String filePath, Library library) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
