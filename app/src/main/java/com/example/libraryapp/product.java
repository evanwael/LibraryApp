package com.example.libraryapp;

public class product {
    private String Book Name ;
    private String Author Name ;
    private int Pages Number ;
    private double Release Year;
    private int image ;
    private int category ;

    public product(String book, String author, int pages, double release, int image, int category) {
        Book = book;
        Author = author;
        Pages = pages;
        Release = release;
        this.image = image;
        this.category = category;
    }

    public String getBook() {
        return Book;
    }

    public void setBook(String book) {
        Book = book;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getPages() {
        return Pages;
    }

    public void setPages(int pages) {
        Pages = pages;
    }

    public double getRelease() {
        return Release;
    }

    public void setRelease(double release) {
        Release = release;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
