package com.study.spring.mylibraryinfo.entity;

public class Book {
    private Integer cod;
    private String  name;
    private String  isbn;
    private Genres  genre;

    public Book() {
    }

    public Book(Integer cod, String name, String isbn, Genres genre) {
        super();
        this.cod = cod;
        this.name = name;
        this.isbn = isbn;
        this.genre = genre;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Genres getGenre() {
        return genre;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "book: " + this.name + " isbn:" + this.isbn;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cod == null) ? 0 : cod.hashCode());
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (cod == null) {
            if (other.cod != null)
                return false;
        } else if (!cod.equals(other.cod))
            return false;
        if (isbn == null) {
            if (other.isbn != null)
                return false;
        } else if (!isbn.equals(other.isbn))
            return false;
        return true;
    }

    public enum Genres {
        ACTION("action"),
        ROMANCE("romance"),
        DETECTIVE_STORY("detective story"),
        FANTASY("fantasy");

        private Genres(String description) {
            this.description = description;
        }

        String description;
    }
}
