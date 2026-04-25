package com.zipcodewilmington.centrallibrary;

public class DVD extends LibraryItem implements Reservable {

    private String director;
    private String rating;
    private String genre;
    private int duration;
    private boolean isReserved;

    public DVD(String id, String title, String location,
            String director, int duration, String rating, String genre) {
        super(id, title, location);
        this.director = director;
        this.duration = duration;
        this.rating = rating;
        this.genre = genre;
    }

    @Override
    public String toString() {
    return "ID: " + getId() + " | Title: " + getTitle() +
           " | Location: " + getLocation() +
           " | Director: " + director +
           " | Duration: " + duration + 
           " | Rating: " + rating +
           " | Genre: " + genre +
           " | " + (isAvailable() ? "Available" : "Unavailable");
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        if(rating != null && !rating.isEmpty()) {
            this.rating = rating;
        } else {
            System.out.println("Invalid Rating");
        }
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if(duration > 0) {
            this.duration = duration;
        } else {
            System.out.println("Invalid Duration");
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
                director,
                genre,
                rating
        };
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 1.0;
    }

    @Override
    public int getMaxBorrowDays() {
        return 7;
    }

    @Override
    public String getItemType() {
        return "DVD";
    }

    @Override
    public void reserve() {
        isReserved = true;
    }

    @Override
    public void cancelReserve() {
        isReserved = false;
    }

    public boolean isReserved() {
        return isReserved;
    }
}