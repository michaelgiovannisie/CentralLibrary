package com.zipcodewilmington.centrallibrary;

import java.util.ArrayList;
import java.util.List;

public class LibraryMember extends Person {
    private String memberId;
    private String membershipDate;
    private List <LibraryItem> borrowedItems;
    private double outstandingFees;
    private Address address;

    public LibraryMember(String name, int age, String email, String phoneNumber, String memberId, String membershipDate, Address address) {
        super(name, age, email, phoneNumber);
        this.memberId = memberId;
        this.membershipDate = membershipDate;
        this.address = address;
        this.borrowedItems = new ArrayList<>();
        this.outstandingFees = 0.0;
    }
    
    public String getMemberId() { return memberId; }
    public double getOutstandingFees() { return outstandingFees; }

    public List<LibraryItem> getBorrowedItems() {
        return new ArrayList<>(borrowedItems); 
    }

    public void borrowItem(LibraryItem item) {
        if (item.isAvailable()) {
            item.checkOut();
            borrowedItems.add(item);
        }
    }

    public void returnItem(LibraryItem item, int daysLate) {
        if (borrowedItems.contains(item)) {
            item.checkIn();
            borrowedItems.remove(item);

            double fee = item.calculateLateFee(daysLate);
            outstandingFees += fee;
        }
    }

    public void payFees(double amount) {
        if (amount > 0) {
            outstandingFees -= amount;
            if (outstandingFees < 0) {
                outstandingFees = 0;
            }
        }
    }
}