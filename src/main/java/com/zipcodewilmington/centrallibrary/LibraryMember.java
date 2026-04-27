package com.zipcodewilmington.centrallibrary;

import java.util.ArrayList;
import java.util.List;

public class LibraryMember extends Person {
    private String memberId;
    private String membershipDate;
    private List <LibraryItem> borrowedItems;
    private double outstandingFees;
    private Address address;
    private List <LibraryItem> reservedItems;
    public LibraryMember(String name, int age, String email, String phoneNumber, String memberId, String membershipDate, Address address) {
        super(name, age, email, phoneNumber);
        this.memberId = memberId;
        this.membershipDate = membershipDate;
        this.address = address;
        this.borrowedItems = new ArrayList<>();
        this.outstandingFees = 0.0;
        this.reservedItems = new ArrayList<>();
    }
    @Override
    public String toString() {
    return "Name: " + getName() + " | Age: " + getAge() + 
    " | Email: " + getEmail() + " | Phone Number: " + getPhoneNumber() + 
    " | Member ID: " + memberId + " | Membership Date: " + membershipDate + 
    " | Address: " + address;
    }
    public String getMemberId() { return memberId; }
    public double getOutstandingFees() { return outstandingFees; }
    public List<LibraryItem> getBorrowedItems() {
        return new ArrayList<>(borrowedItems); 
    }
    public List<LibraryItem> getReservedItems() {
        return new ArrayList<>(reservedItems);
    }
    public void borrowItem(LibraryItem item) {
        if (borrowedItems.contains(item)) {
            return;
        }
        if (item.isAvailable()) {
            if (item.isReserved() && item.getReservedBy() != null &&
                !item.getReservedBy().getMemberId().equals(this.memberId)) {
                return;
            }
            item.checkOut();
            if (!borrowedItems.contains(item)) {
                borrowedItems.add(item);
            }
            if (isReservedByMe(item)) {
                reservedItems.remove(item);
                item.cancelReserve(this);
            }
        }
    }
    public void addReservedItem(LibraryItem item) {
        if (!reservedItems.contains(item)) {
            reservedItems.add(item);
        }
    }
    public void removeReservedItem(LibraryItem item) {
        reservedItems.remove(item);
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
    private boolean isReservedByMe(LibraryItem item) {
        return item.isReserved() &&
            item.getReservedBy() != null &&
            item.getReservedBy().getMemberId().equals(this.memberId);
    }
}