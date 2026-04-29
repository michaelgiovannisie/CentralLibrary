package com.zipcodewilmington.centrallibrary;

public class Music extends LibraryItem {
    private String artist;
    private String date;
    private String genre;
    private String lyrics;
    private int length;

    public Music(String id, String title, String location, String artist, 
            String date, String genre, String lyrics, int length) {
        super(id, title, location); 
        this.artist = artist;
        this.date = date;
        this.genre = genre;
        this.lyrics = lyrics;
        this.length = length;
    }
    @Override
    public String toString() {
        return getItemType() + " | ID: " + getId() + " | Title: " + getTitle() + 
        " | Location" + getLocation() + " | " + artist + " | Date: " + date +
        " | " + genre + " | " + length + " sec";
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        if(date != null && !date.isEmpty()) {
            this.date = date;
        } else {
            System.out.println("Invalid Date");
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
    public String getLyrics() {
        return lyrics;
    }
    public void setLyrics(String lyrics) {
        if(lyrics != null && !lyrics.isEmpty()) {
            this.lyrics = lyrics;
        } else {
            System.out.println("Invalid Lyrics");
        }
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        if(length > 0) {
            this.length = length;
        } else {
            System.out.println("Invalid Length");
        }
    }
    @Override
    public String[] getSearchableFields() {
        return new String[] {
        getTitle(),
        artist,
        genre,
        lyrics
        };
    }
    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 0.2;
    }
    @Override
    public int getMaxBorrowDays() {
        return 20;
    }
    @Override
    public String getItemType() {
        return "Music";
    }
}