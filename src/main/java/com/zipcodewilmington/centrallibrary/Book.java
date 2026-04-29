package com.zipcodewilmington.centrallibrary;

public class Book extends LibraryItem {
    private String author;
    private String isbn;
    private int pages;
    private String genre;
    private boolean isReserved;

    public Book(String id, String title, String location,
            String author, String isbn, int pages, String genre) {
        super(id, title, location); 
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
        this.genre = genre;
    }
    
    @Override
    public String toString() {
    return getItemType() + " | ID: " + getId() + " | Title: " + getTitle() + 
    " | Location: " + getLocation() + " | Author: " + author + 
    " | ISBN: " + isbn + " | Pages: " + pages + " | Genre: " + genre + 
    " | " + (isAvailable() ? "Available" : "Unavailable");
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if(author != null && !author.isEmpty()) {
            this.author = author;
        } else {
            System.out.println("Invalid Author");
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if(isbn != null && !isbn.isEmpty()) {
            this.isbn = isbn;
        } else {
            System.out.println("Invalid ISBN");
        }
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        if(pages > 0) {
            this.pages = pages;
        } else {
            System.out.println("Invalid Pages");
        }
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        if(genre != null && !genre.isEmpty()) {
            this.genre = genre;
        } else {
            System.out.println("Invalid Genre");
        }
    }
 
    @Override
    public String[] getSearchableFields() {
        return new String[] {
        getTitle(),
        author,
        genre,
        isbn
        };
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 0.5;
    }

    @Override
    public int getMaxBorrowDays() {
        return 14;
    }

    @Override
    public String getItemType() {
        return "Book";
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }
}