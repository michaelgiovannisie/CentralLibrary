package com.zipcodewilmington.centrallibrary;

public interface Searchable {
    boolean matchesKeyword(String keyword);

    String[] getSearchableFields();
}
