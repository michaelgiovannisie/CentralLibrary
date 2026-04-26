package com.zipcodewilmington.centrallibrary;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<LibraryItem> items;
    private List<LibraryMember> members;
    private List<Librarian> librarians;

    public Library () {
        items = new ArrayList<>();
        members = new ArrayList<>();
        librarians = new ArrayList<>();
    }

    public List<LibraryMember> getMembers() {
        return members;
    }

    public List<Librarian> getLibrarian() {
        return librarians;
    }

    public List<LibraryItem> getItems() {
        return items;
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void removeItem(LibraryItem item) {
        items.remove(item);
    }

    public void addMember(LibraryMember member) {
        members.add(member);
    }

    public void addLibrarian(Librarian librarian) {
        librarians.add(librarian);
    }

    public void removeLibrarian(Librarian librarian) {
        librarians.remove(librarian);
    }

    public List<LibraryItem> search(String keyword) {
        List<LibraryItem> results = new ArrayList<>();
        for(LibraryItem item : items){
            if(item.matchesKeyword(keyword)){
            results.add(item);
            }
        }
        return results;
    }

    public void displayAllItems() {
        for (LibraryItem item : items) {
            System.out.println(item);
        }
    }

    public void generateLateFeeReport() {
        int daysLate = 3;
        
        for(LibraryMember member : members) {
            System.out.println(member.getName());
            for(LibraryItem item : member.getBorrowedItems()) {
                String type = item.getItemType();
                int maxDays = item.getMaxBorrowDays();
                double lateFees = item.calculateLateFee(daysLate);
                System.out.println(type + " | Max Days: " + maxDays + " | Fee: " + lateFees);
            }
        }
    }

    public LibraryMember findMemberById(String memberId) {
        for (LibraryMember m : members) {
            if (m.getMemberId().equals(memberId)) {
                return m;
            }
        }
        return null;
    }

    public LibraryItem findItemById(String itemId) {
        for (LibraryItem i : items) {
            if (i.getId().equals(itemId)) {
                return i;
            }
        }
        return null;
    }

    public LibraryItem findBorrowedItem(LibraryMember member, String itemId) {
        for (LibraryItem i : member.getBorrowedItems()) {
            if (i.getId().equals(itemId)) {
                return i;
            }
        }
        return null;
    }

    public boolean itemExists(String id) {
        for (LibraryItem item : items) {
            if (item.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void removeMember(LibraryMember member) {
        members.remove(member);
    }

    public Librarian findLibrarianById(String id) {
        for (Librarian l : librarians) {
            if (l.getEmployeeId().equals(id)) {
                return l;
            }
        }
        return null;
    }

}
