package com.zipcodewilmington.centrallibrary;

public class MainApplication {

    public static void main(String[] args) {
        Library library = new Library();
        BookLoader bookLoader = new BookLoader();
        bookLoader.loadBooks("src/main/java/com/zipcodewilmington/centrallibrary/book.csv",library);
        DVDLoader dvdLoader = new DVDLoader();
        dvdLoader.loadDVD("src/main/java/com/zipcodewilmington/centrallibrary/dvd.csv",library);
        LibrarianLoader librarianLoader = new LibrarianLoader();
        librarianLoader.loadLibrarian("src/main/java/com/zipcodewilmington/centrallibrary/librarian.csv",library);
        LibraryMemberLoader libraryMemberLoader = new LibraryMemberLoader();
        libraryMemberLoader.loadLibraryMember("src/main/java/com/zipcodewilmington/centrallibrary/librarymember.csv",library);
        MusicLoader musicLoader = new MusicLoader();
        musicLoader.loadMusic("src/main/java/com/zipcodewilmington/centrallibrary/music.csv",library);
        PeriodicalLoader periodicalLoader = new PeriodicalLoader();
        periodicalLoader.loadPeriodical("src/main/java/com/zipcodewilmington/centrallibrary/periodical.csv",library);
        CLI cli = new CLI(library);
        cli.userInterface();
    }
}