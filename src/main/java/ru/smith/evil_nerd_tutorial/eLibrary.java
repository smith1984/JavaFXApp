package ru.smith.evil_nerd_tutorial;

public class eLibrary {

    private String nameAuthor, workTitle;
    private double price;

    public eLibrary(String nameAuthor, String workTitle, double price) {
        this.nameAuthor = nameAuthor;
        this.workTitle = workTitle;
        this.price = price;
    }

    public eLibrary() {
        this.nameAuthor = "";
        this.workTitle = "";
        this.price = 0;

    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getWorkTitle() {
        return workTitle;
    }

    public void setWorkTitle(String workTitle) {
        this.workTitle = workTitle;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
