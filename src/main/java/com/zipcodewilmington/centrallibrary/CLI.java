package com.zipcodewilmington.centrallibrary;

import java.util.List;
import java.util.Scanner;

public class CLI{

    private Library library;
    private Scanner scanner;

    public CLI(Library library){
        this.library = library;
        this.scanner = new Scanner(System.in);
    }

    public void userInterface() {
        boolean isRunning = true;

        do {
            System.out.println("\nMichael's Library Management System");
            System.out.println("1. Search");
            System.out.println("2. Borrow");
            System.out.println("3. Return");
            System.out.println("4. View");
            System.out.println("5. Exit");
            System.out.println("Please enter your choice: ");

            int option;
            if(scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Invalid input.");
                scanner.nextLine();
                continue;
            }
            String memberId;
            String itemId;
            
            switch(option) {
                case 1: 
                    System.out.println("\nEnter search keyword: ");
                    String keyword = scanner.nextLine().trim();
                    List<LibraryItem> result = library.search(keyword);
                    if(result.isEmpty()){
                        System.out.println("No items found");
                    } else {
                        System.out.println("\nSearch result: ");
                        for(LibraryItem item    : result){
                            System.out.println(item);
                        }
                    }
                    break;
                case 2: 
                    System.out.println("\nEnter member ID to borrow: ");
                    memberId = scanner.nextLine().trim();
                    LibraryMember foundMember = null;
                    for(LibraryMember m : library.getMembers()) {
                        if(m.getMemberId().equals(memberId)) {
                            foundMember = m;
                            break;
                        }
                    }
                    if (foundMember == null) {
                        System.out.println("Member not found.");
                        break;
                    } else {
                        System.out.println("Member found: " + foundMember.getName());
                    }
                    System.out.println("\nEnter item ID: ");
                    itemId = scanner.nextLine().trim();
                    LibraryItem foundItem = null;
                    for(LibraryItem i : library.getItems()) {
                        if(i.getId().equals(itemId)) {
                            foundItem = i;
                            break;
                        }
                    }
                    if(foundItem == null) {
                        System.out.println("No items found");
                        break;
                    }
                    if (!foundItem.isAvailable()) {
                        System.out.println("Item is not available");
                        break;
                    } else {
                        foundMember.borrowItem(foundItem);
                    }
                    System.out.println("\nYou successfully borrowed: " + foundItem.getItemType() + " | " + foundItem.getId() + " | " + foundItem.getTitle());
                    break;
                case 3: 
                    System.out.println("\nEnter member ID: ");
                    memberId = scanner.nextLine().trim();
                    LibraryMember foundMember1 = null;
                    for(LibraryMember n : library.getMembers()) {
                        if(n.getMemberId().equals(memberId)) {
                            foundMember1 = n;
                            break;
                        }
                    }
                    if(foundMember1 == null) {
                        System.out.println("Member not found.");
                        break;
                    } else {
                        System.out.println("Member found: " + foundMember1.getName());
                    }
                    System.out.println("\nBooks you borrowed: ");
                    for (LibraryItem item : foundMember1.getBorrowedItems()) {
                        System.out.println(item.getId() + " | " + item.getTitle());
                    }
                    System.out.println("\nEnter item ID to return: ");
                    itemId = scanner.nextLine().trim();
                    LibraryItem foundItem1 = null;
                    for(LibraryItem i : foundMember1.getBorrowedItems()) {
                        if (i.getId().equals(itemId)) {
                            foundItem1 = i;
                            break;
                        }
                    }
                    if (foundItem1 == null) {
                        System.out.println("Item not borrowed by this member.");
                        break;
                    }
                    System.out.println("\nEnter number of days late: ");
                    int daysLate;
                    if(scanner.hasNextInt()) {
                        daysLate = scanner.nextInt();
                        scanner.nextLine();
                    } else {
                        System.out.println("Invalid input.");
                        scanner.nextLine();
                        continue;
                    }
                    if(daysLate < 0) {
                        System.out.println("Please enter positive number.");
                        break;
                    } 
                    double fee = foundItem1.calculateLateFee(daysLate);
                    foundMember1.returnItem(foundItem1, daysLate);
                    if(fee > 0) {
                        System.out.println("\nLate fees: $" + fee);
                    }
                    System.out.println("You successfully returned: " + foundItem1.getItemType() + " | " + foundItem1.getId() + " | " + foundItem1.getTitle());
                    break;
                case 4: 
                    System.out.println("\n1. View All");
                    System.out.println("2. View All Books");
                    System.out.println("3. View All DVDs");
                    System.out.println("4. View All Music"); 
                    System.out.println("5. View All Periodicals");
                    System.out.println("6. View All Members"); 
                    System.out.println("7. View All Librarians"); 
                    System.out.println("8. Back");
                    System.out.println("Please enter your choice: ");
                    int option2;
                    if(scanner.hasNextInt()) {
                        option2 = scanner.nextInt();
                        scanner.nextLine();
                    } else {
                        System.out.println("Invalid input.");
                        scanner.nextLine();
                        continue;
                    }
                    switch (option2) {
                        case 1:
                            System.out.println("\nALL LIBRARY ITEMS: ");
                            if (library.getItems().isEmpty()) {
                                System.out.println("No Items found.");
                            } else {
                                library.displayAllItems();
                            }
                            break;
                        case 2:
                            System.out.println("\nALL LIBRARY Books: ");
                            boolean found1 = false;
                            for (LibraryItem item : library.getItems()) {
                                if (item instanceof Book) {
                                    System.out.println(item);
                                    found1 = true;
                                }
                            }
                            if (!found1) {
                                System.out.println("No Books found.");
                            }
                            break;
                        case 3:
                            System.out.println("\nALL LIBRARY DVDs: ");
                            boolean found2 = false;
                            for (LibraryItem item : library.getItems()) {
                                if (item instanceof DVD) {
                                    System.out.println(item);
                                    found2 = true;
                                }
                            }
                            if (!found2) {
                                System.out.println("No DVDs found.");
                            }
                            break;
                        case 4:
                            System.out.println("\nALL LIBRARY Music: ");
                            boolean found3 = false;
                            for (LibraryItem item : library.getItems()) {
                                if (item instanceof Music) {
                                    System.out.println(item);
                                    found3 = true;
                                }
                            }
                            if (!found3) {
                                System.out.println("No Music found.");
                            }
                            break;
                        case 5:
                            System.out.println("\nALL LIBRARY Periodical: ");
                            boolean found4 = false;
                            for (LibraryItem item : library.getItems()) {
                                if (item instanceof Periodical) {
                                    System.out.println(item);
                                    found4 = true;
                                }
                            }
                            if (!found4) {
                                System.out.println("No Periodicals found.");
                            }
                            break;
                        case 6:
                            System.out.println("\nALL LIBRARY MEMBERS: ");
                            if (library.getMembers().isEmpty()) {
                                System.out.println("No members found.");
                            } else {
                                for(LibraryMember members : library.getMembers()) {
                                    System.out.println(members);
                                }
                            }
                            break;
                        case 7:
                            System.out.println("\nALL LIBRARY LIBRARIANS: ");
                            if (library.getLibrarian().isEmpty()) {
                                System.out.println("No librarians found.");
                            } else {
                                for(Librarian librarians : library.getLibrarian()) {
                                    System.out.println(librarians);
                                }
                            }
                            break;
                        case 8:
                            break;
                        default:
                            System.out.println("Invalid Option"); break;
                    }
                    break;
                case 5: System.out.println("GoodBye!"); isRunning = false; break;
                default: System.out.println("Invalid Option"); break;
            }
        } while (isRunning);
    }
}