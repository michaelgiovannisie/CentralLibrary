package com.zipcodewilmington.centrallibrary;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CLI{

    private Library library;
    private Scanner scanner;
    private String memberId;
    private String itemId;

    public CLI(Library library){
        this.library = library;
        this.scanner = new Scanner(System.in);
    }

    public void LMS() {
        boolean isRunning = true;

        do {
            printMainMenu();
            int option = getPositiveInt("Please enter your choice:");
            switch(option) {
                case 1: 
                    handleSearch();
                    break;
                case 2:
                    printBorrowReturnMenu();
                    int option2 = getPositiveInt("Please enter your choice:");
                    switch (option2) {
                        case 1 :
                            handleBorrow();
                            break;
                        case 2 :
                            handleReturn();
                            break;
                        case 3:
                            handleReserve();
                            break;
                        case 4:
                            handlecancelReservedItems();
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Invalid Option"); break;
                    }
                    break;
                case 3: 
                    printViewMenu();
                    int option3 = getPositiveInt("Please enter your choice:");
                    switch (option3) {
                        case 1:
                            handleDisplayAll();
                            break;
                        case 2:
                            handleDisplayBook();
                            break;
                        case 3:
                            handleDisplayDVD();
                            break;
                        case 4:
                            handleDisplayMusic();
                            break;
                        case 5:
                            handleDisplayPeriodical();
                            break;
                        case 6:
                            handleDisplayMember();
                            break;
                        case 7:
                            handleDisplayLibrarian();
                            break;
                        case 8:
                            break;
                        default:
                            System.out.println("Invalid Option");
                            break;
                    }
                    break;
                case 4: 
                    printTransactionMenu();
                    int option4 = getPositiveInt("Please enter your choice:");
                    switch (option4) {
                        case 1 :
                            handlePayFees();
                            break;
                        case 2 :
                            handleLateFeeReport();
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Invalid Option"); break;
                    }
                    break;
                case 5: 
                    printAddRemoveItemMenu();
                    int option5 = getPositiveInt("Please enter your choice:");
                    switch (option5) {
                        case 1 :
                            printAddItemMenu();
                            int option5a = getPositiveInt("Please enter your choice:");
                            switch (option5a) {
                                case 1:
                                    handleAddBook();
                                    break;
                                case 2:
                                    handleAddDVD();
                                    break;
                                case 3:
                                    handleAddMusic();
                                    break;
                                case 4:
                                    handleAddPeriodical();
                                    break;
                                case 5:
                                    break;
                                default:
                                System.out.println("Invalid Option"); break;
                            }
                            break;
                        case 2 :
                            handleRemoveItem();
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Invalid Option"); break;
                    }
                    break;
                case 6:  
                    printAddRemoveMemberMenu();
                    int option6 = getPositiveInt("Please enter your choice:");
                    switch (option6) {
                        case 1 :
                            handleAddMember();
                            break;
                        case 2 :
                            handleRemoveMember();
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Invalid Option"); break;
                    }
                    break;
                case 7: 
                    printAddRemoveLibrarianMenu();
                    int option7 = getPositiveInt("Please enter your choice:");
                    switch (option7) {
                        case 1 :
                            handleAddLibrarian();
                            break;
                        case 2 :
                            handleRemoveLibrarian();
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Invalid Option"); break;
                    }
                    break;
                case 8: System.out.println("GoodBye!"); isRunning = false; break;
                default: System.out.println("Invalid Option"); break;
            }
        } while (isRunning);
    }

    private int getPositiveInt(String prompt) {
        System.out.println(prompt);
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private double getPositiveDouble(String prompt) {
        System.out.println(prompt);
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public void printMainMenu() {
        System.out.println("\nMichael's Library Management System");
            System.out.println("1. Search");
            System.out.println("2. Borrow / Return / Reserve");
            System.out.println("3. View Data");
            System.out.println("4. Transaction");
            System.out.println("5. Add / Remove Item");
            System.out.println("6. Add / Remove Member");
            System.out.println("7. Add / Remove Librarian");
            System.out.println("8. Exit");
    }

    public void printBorrowReturnMenu() {
            System.out.println("\n1. Borrow");
            System.out.println("2. Return"); 
            System.out.println("3. Reserve"); 
            System.out.println("4. Cancel Reserve"); 
            System.out.println("5. Back"); 
    }

    public void printViewMenu() {
            System.out.println("\n1. View All");
            System.out.println("2. View All Books");
            System.out.println("3. View All DVDs");
            System.out.println("4. View All Music"); 
            System.out.println("5. View All Periodicals");
            System.out.println("6. View All Members"); 
            System.out.println("7. View All Librarians"); 
            System.out.println("8. Back");
    }

    public void printTransactionMenu() {
            System.out.println("\n1. Pay Fees");
            System.out.println("2. Late Fee Report");
            System.out.println("3. Back"); 
    }

    public void printAddRemoveItemMenu() {
            System.out.println("\n1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Back");
    }

    public void printAddItemMenu() {
            System.out.println("\n1. Book");
            System.out.println("2. DVD");
            System.out.println("3. Music");
            System.out.println("4. Periodical");
            System.out.println("5. Back");
    }

    public void printAddRemoveMemberMenu() {
            System.out.println("\n1. Add Member");
            System.out.println("2. Remove Member");
            System.out.println("3. Back");
    }

    public void printAddRemoveLibrarianMenu() {
            System.out.println("\n1. Add Librarian");
            System.out.println("2. Remove Librarian");
            System.out.println("3. Back"); 
    }

    public void printBorrowedItems(LibraryMember member) {
        if (member.getBorrowedItems().isEmpty()) {
            System.out.println("No items borrowed.");
            return;
        }

        for (LibraryItem item : member.getBorrowedItems()) {
            System.out.println(item.getItemType() + " | ID: " + item.getId() + " | Title: " + item.getTitle());
        }
    }

    private String getNonEmptyInput(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input cannot be empty.");
        }
    }

    public void handleSearch () {
        System.out.println("\nEnter search keyword: ");
        String keyword = scanner.nextLine().trim();
        List<LibraryItem> result = library.search(keyword);
        if(result.isEmpty()){
            System.out.println("No items found");
        } else {
            System.out.println("\nSearch result: ");
            for(LibraryItem item : result){
                System.out.println(item);
            }
        }
    }

    public void handleBorrow() {
        System.out.println("\nEnter member ID to borrow: ");
        memberId = scanner.nextLine().trim();
        LibraryMember foundMember = library.findMemberById(memberId);
        if (foundMember == null) {
            System.out.println("Member not found.");
            return;
        } else {
            System.out.println("Member found: Name: " + foundMember.getName());
        }
        System.out.println("\nEnter item ID: ");
        itemId = scanner.nextLine().trim();
        LibraryItem foundItem = library.findItemById(itemId);
        if(foundItem == null) {
            System.out.println("No items found");
            return;
        }
        if (!foundItem.isAvailable()) {
            if(foundItem.isReserved() &&
                foundItem.getReservedBy() != null &&
                !foundItem.getReservedBy().getMemberId().equals(foundMember.getMemberId())) {
                System.out.println("Item is reserved by other member.");
            }
            System.out.println(foundItem.getItemType() + " | " + foundItem.getId() + " | " + foundItem.getTitle());
            System.out.println("Item is not available. You may reserve it.");
            return;
        }
        foundMember.borrowItem(foundItem);
        System.out.println("\nItem successfully borrowed: " + foundItem.getItemType() + 
        " | ID: " + foundItem.getId() + " | Title: " + foundItem.getTitle());
    }

    public void handleReturn() {
        System.out.println("\nEnter member ID: ");
        memberId = scanner.nextLine().trim();
        LibraryMember foundMember1 = library.findMemberById(memberId);
        if(foundMember1 == null) {
            System.out.println("Member not found.");
            return;
        } else {
            System.out.println("Member found: Name:" + foundMember1.getName());
        }
        System.out.println("\nItems you borrowed: ");
        printBorrowedItems(foundMember1);
        System.out.println("\nEnter item ID to return: ");
        itemId = scanner.nextLine().trim();
        LibraryItem foundItem1 = library.findBorrowedItem(foundMember1, itemId);
        if (foundItem1 == null) {
            System.out.println("Item not borrowed by this member.");
            return;
        }
        System.out.println("\nEnter number of days borrowed: ");
        int daysBorrowed = getPositiveInt("Enter days borrowed:");
        int maxDays = foundItem1.getMaxBorrowDays();
        int daysLate = Math.max(0, daysBorrowed - maxDays);
        double fee = foundItem1.calculateLateFee(daysLate);
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        foundMember1.returnItem(foundItem1, daysLate);
        if(fee > 0) {
            System.out.println("\nLate fees: " + formatter.format(fee));
        }
        System.out.println("Item successfully returned: " + foundItem1.getItemType() + 
        " | ID: " + foundItem1.getId() + " | Title: " + foundItem1.getTitle());
    }

    public void handleDisplayAll() {
        System.out.println("\nALL LIBRARY ITEMS: ");
        if (library.getItems().isEmpty()) {
            System.out.println("No Items found.");
        } else {
            library.displayAllItems();
        }
    }

    public void handleDisplayBook() {
        System.out.println("\nALL LIBRARY BOOKS: ");
        boolean foundBooks = false;
        for (LibraryItem item : library.getItems()) {
            if (item instanceof Book) {
                System.out.println(item);
                foundBooks = true;
            }
        }
        if (!foundBooks) {
            System.out.println("No Books found.");
        }
    }

    public void handleDisplayDVD () {
        System.out.println("\nALL LIBRARY DVDs: ");
        boolean foundDVD = false;
        for (LibraryItem item : library.getItems()) {
            if (item instanceof DVD) {
                System.out.println(item);
                foundDVD = true;
            }
        }
        if (!foundDVD) {
            System.out.println("No DVDs found.");
        }
    }

    public void handleDisplayMusic () {
        System.out.println("\nALL LIBRARY MUSIC: ");
        boolean foundMusic = false;
        for (LibraryItem item : library.getItems()) {
            if (item instanceof Music) {
                System.out.println(item);
                foundMusic = true;
            }
        }
        if (!foundMusic) {
            System.out.println("No Music found.");
        }
    }

    public void handleDisplayPeriodical () {
        System.out.println("\nALL LIBRARY PERIODICALS: ");
        boolean foundPeriodical = false;
        for (LibraryItem item : library.getItems()) {
            if (item instanceof Periodical) {
                System.out.println(item);
                foundPeriodical = true;
            }
        }
        if (!foundPeriodical) {
            System.out.println("No Periodicals found.");
        }
    }

    public void handleDisplayMember() {
        System.out.println("\nALL LIBRARY MEMBERS: ");
        if (library.getMembers().isEmpty()) {
            System.out.println("No members found.");
        } else {
            for (LibraryMember m : library.getMembers()) {
                System.out.println(m);
            }
        }
    }

    public void handleDisplayLibrarian() {
        System.out.println("\nALL LIBRARY LIBRARIANS: ");
        if (library.getLibrarian().isEmpty()) {
            System.out.println("No librarians found.");
        } else {
            for (Librarian l : library.getLibrarian()) {
                System.out.println(l);
            }
        }
    }

    public void handleAddBook() {
        String id = getNonEmptyInput("Enter ID: ");
        if (library.itemExists(id)) {
        System.out.println("Item with this ID already exists.");
            return;
        }
        String title = getNonEmptyInput("Enter Title: ");
        String location = getNonEmptyInput("Enter Location: ");
        String author = getNonEmptyInput("Enter Author: ");
        String isbn = getNonEmptyInput("Enter ISBN: ");
        int pages = getPositiveInt("Enter Pages: ");
        String genre = getNonEmptyInput("Enter genre: ");
        Book newBook = new Book(id, title, location, author, isbn, pages, genre);
        library.addItem(newBook);
        System.out.println("Book added: ID: " + id + " | Title: " + title);
    }

    public void handleAddDVD() {
        String id = getNonEmptyInput("Enter ID: ");
        if (library.itemExists(id)) {
        System.out.println("Item with this ID already exists.");
            return;
        }
        String title = getNonEmptyInput("Enter Title: ");
        String location = getNonEmptyInput("Enter Location: ");
        String director = getNonEmptyInput("Enter Director: ");
        int duration = getPositiveInt("Enter Duration (minutes): ");
        String rating = getNonEmptyInput("Enter Rating: ");
        String genre = getNonEmptyInput("Enter genre: ");
        DVD newDVD = new DVD(id, title, location, director, duration, rating, genre);
        library.addItem(newDVD);
        System.out.println("DVD added: ID: " + id + " | Title: " + title);
    }

    public void handleAddMusic() {
        String id = getNonEmptyInput("Enter ID: ");
        if (library.itemExists(id)) {
        System.out.println("Item with this ID already exists.");
            return;
        }
        String title = getNonEmptyInput("Enter Title: ");
        String location = getNonEmptyInput("Enter Location: ");
        String artist = getNonEmptyInput("Enter Artist: ");
        String date = getNonEmptyInput("Enter Date: ");
        String genre = getNonEmptyInput("Enter Genre: ");
        String lyrics = getNonEmptyInput("Enter Lyrics: ");
        int length = getPositiveInt("Enter Length (seconds): ");
        Music newMusic = new Music(id, title, location, artist, date, genre, lyrics, length);
        library.addItem(newMusic);
        System.out.println("Music added: ID: " + id + " | Title: " + title);
    }

    public void handleAddPeriodical() {
        String id = getNonEmptyInput("Enter ID: ");
        if (library.itemExists(id)) {
        System.out.println("Item with this ID already exists.");
            return;
        }
        String title = getNonEmptyInput("Enter Title: ");
        String location = getNonEmptyInput("Enter Location: ");
        String publisher = getNonEmptyInput("Enter Publisher: ");
        String issn = getNonEmptyInput("Enter ISSN: ");
        int volume = getPositiveInt("Enter Volume: ");
        int issueNumber = getPositiveInt("Enter Issue Number: ");
        String publicationDate = getNonEmptyInput("Enter Publication Date: ");
        Periodical newPeriodical = new Periodical(id, title, location, publisher, issn, 
            volume, issueNumber, publicationDate);
        library.addItem(newPeriodical);
        System.out.println("Periodical added: ID: " + id + " | Title: " + title);
    }

    public void handleRemoveItem() {
        System.out.println("\nEnter item ID to remove: ");
        String removeI = scanner.nextLine().trim();
        LibraryItem removedItem = library.findItemById(removeI);
        if (removedItem == null) {
            System.out.println("Item doesn't exist.");
            return;
        }
        library.removeItem(removedItem);
        System.out.println("Item successfully removed: "
            + removedItem.getItemType() + " | ID: "
            + removedItem.getId() + " | Title: "
            + removedItem.getTitle());
    }

    public void handleAddMember() {
        String name = getNonEmptyInput("Enter Name: ");
        int age = getPositiveInt("Enter Age: ");
        String email = getNonEmptyInput("Enter Email: ");
        String phone = getNonEmptyInput("Enter Phone Number: ");
        String memberId = getNonEmptyInput("Enter Member ID: ");
        String membershipDate = getNonEmptyInput("Enter Membership Date (YYYY-MM-DD): ");
        String street = getNonEmptyInput("Enter Street: ");
        String city = getNonEmptyInput("Enter City: ");
        String state = getNonEmptyInput("Enter State: ");
        String zip = getNonEmptyInput("Enter Zip Code: ");
        Address address = new Address(street, city, state, zip);
        LibraryMember member = new LibraryMember(
            name, age, email, phone, memberId, membershipDate, address
        );
        library.addMember(member);
        System.out.println("Member added: ID: " + memberId + " | Name: " + name);
    }

    public void handleRemoveMember() {
        String memberId = getNonEmptyInput("Enter Member ID: ");
        LibraryMember member = library.findMemberById(memberId);
        if (member == null) {
            System.out.println("Member not found.");
            return;
        }
        library.removeMember(member);
        System.out.println("Member removed: ID: " + memberId + " | Name: " + member.getName());
    }

    public void handleAddLibrarian() {
        String name = getNonEmptyInput("Enter Name: ");
        int age = getPositiveInt("Enter Age: ");
        String email = getNonEmptyInput("Enter Email: ");
        String phoneNumber = getNonEmptyInput("Enter Phone Number: ");
        String employeeId = getNonEmptyInput("Enter Librarian ID: ");
        String department = getNonEmptyInput("Enter Department: ");
        double salary = getPositiveDouble("Enter Salary: ");
        Librarian librarian = new Librarian(name, age, email, phoneNumber, employeeId, department, salary);
        library.addLibrarian(librarian);
        System.out.println("Librarian added: ID: " + employeeId + " | Name: " + name);
    }

    public void handleRemoveLibrarian() {
        String id = getNonEmptyInput("Enter Librarian ID: ");
        Librarian librarian = library.findLibrarianById(id);
        if (librarian == null) {
            System.out.println("Librarian not found.");
            return;
        }
        library.removeLibrarian(librarian);
        System.out.println("Librarian removed: ID: " + id + " | Name: " + librarian.getName());
    }

    public void handlePayFees() {
        memberId = getNonEmptyInput("Enter Member ID: ");
        LibraryMember member = library.findMemberById(memberId);
        if (member == null) {
            System.out.println("Member not found.");
            return;
        }
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Outstanding fees: " + formatter.format(member.getOutstandingFees()));
        double amount = getPositiveDouble("Enter payment amount: ");
        member.payFees(amount);
        System.out.println("Payment successful.");
        System.out.println("Remaining balance: " + formatter.format(member.getOutstandingFees()));
    }

    public void handleLateFeeReport() {
        System.out.println("\nLATE FEE REPORT:");
        library.generateLateFeeReport();
    }

    public void handleReserve() {
        String memberId = getNonEmptyInput("Enter member ID: ");
        LibraryMember member = library.findMemberById(memberId);
        if(member == null) {
            System.out.println("Member not found.");
            return;
        }
        String itemId = getNonEmptyInput("Enter item ID: ");
        LibraryItem item =library.findItemById(itemId);
        if(item == null) {
            System.out.println("Item not found.");
            return;
        }
        if (item.isAvailable()) {
            System.out.println(item.getItemType() + " | " + item.getId() + " | " + item.getTitle());
            System.out.println("Item is available to borrow.");
            return;
        }
        if (item.isReserved()) {
            System.out.println(item.getItemType() + " | " + item.getId() + " | " + item.getTitle());
            System.out.println("Item is already reserved.");
            return;
        }
        item.reserve(member);
        member.addReservedItem(item);
        System.out.println("You have successfully reserved: " + item.getItemType() + " | " + 
                            item.getId() + " | " + item.getTitle());
    }

    public void printReservedItems(LibraryMember member) {
        if (member.getReservedItems().isEmpty()) {
            System.out.println("No items reserved.");
            return;
        }

        for (LibraryItem item : member.getReservedItems()) {
            System.out.println(item.getItemType() + " | ID: " + item.getId() + " | Title: " + item.getTitle());
        }
    }

    public void handlecancelReservedItems() {
        String memberId = getNonEmptyInput("Enter member ID: ");
        LibraryMember member = library.findMemberById(memberId);
        if(member == null) {
            System.out.println("Member not found.");
            return;
        }
        System.out.println("Items you reserved:");
        printReservedItems(member);
        String itemId = getNonEmptyInput("Enter item ID: ");
        LibraryItem item =library.findItemById(itemId);
        if(item == null) {
            System.out.println("Item not found.");
            return;
        }
        if(!item.isReserved() || item.getReservedBy() == null || !item.getReservedBy().getMemberId().equals(member.getMemberId())) {
            System.out.println("You have no reservation for this item.");
            return;     
        }
        item.cancelReserve(member);
        member.removeReservedItem(item);
        System.out.println("Reservation cancelled.");
    }

}