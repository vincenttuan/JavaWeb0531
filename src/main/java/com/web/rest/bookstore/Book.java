package com.web.rest.bookstore;

import com.google.gson.Gson;
import java.util.Base64;
import java.util.Objects;

public class Book {
    private Integer id;
    private String name;
    private Integer price;
    private Integer amount;

    public Book() {
    }

    public Book(Integer id, String name, Integer price, Integer amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.price);
        hash = 89 * hash + Objects.hashCode(this.amount);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (!Objects.equals(this.amount, other.amount)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        String json = new Gson().toJson(this);
        try {
            return Base64.getEncoder().encodeToString(json.getBytes("UTF-8"));
        } catch (Exception e) {
            return null;
        }
    }
    
}