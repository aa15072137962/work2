package cn.javasm.entity;

public class Book {
    private Integer bid;
    private String name;
    private String author_name;

    public Book() {
    }

    public Book(Integer bid, String name, String author_name, String type) {
        this.bid = bid;
        this.name = name;
        this.author_name = author_name;
        this.type = type;
    }

    private String type;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", name='" + name + '\'' +
                ", author_name='" + author_name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
