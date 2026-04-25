package com.zipcodewilmington.centrallibrary;

public abstract class LibraryItem implements Searchable {
    private String id;
    private String title;
    private String location;
    private boolean isAvailable;

    public LibraryItem(String id, String title, String location) {
        this.id = id; 
        this.title = title; 
        this.location = location; 
        this.isAvailable = true; 
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null && !id.isEmpty()) {
            this.id = id;
        } else {
            System.out.println("Invalid ID");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        } else {
            System.out.println("Invalid Title");
        }
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        if (location != null && !location.isEmpty()) {
            this.location = location;
        } else {
            System.out.println("Invalid Location");
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void checkIn() {
        isAvailable = true;
    }

    public void checkOut() {
        isAvailable = false;
    }

    @Override
    public boolean matchesKeyword(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return false;
        }
        //String[] fields = getSearchableFields();
        for (String field : getSearchableFields()) {
            if (field != null && field.toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public abstract String[] getSearchableFields();

    public abstract double calculateLateFee(int daysLate);

    public abstract int getMaxBorrowDays();

    public abstract String getItemType();

    
    }

