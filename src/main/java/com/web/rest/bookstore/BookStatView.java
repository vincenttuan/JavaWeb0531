package com.web.rest.bookstore;

import com.google.gson.Gson;
import java.util.Base64;
import java.util.Objects;

public class BookStatView {
    private String name;
    private Integer amount;
    private Integer subtotal;
    private Integer avgprice;

    public BookStatView() {
    }

    public BookStatView(String name, Integer amount, Integer subtotal, Integer avgprice) {
        this.name = name;
        this.amount = amount;
        this.subtotal = subtotal;
        this.avgprice = avgprice;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getAvgprice() {
        return avgprice;
    }

    public void setAvgprice(Integer avgprice) {
        this.avgprice = avgprice;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.amount);
        hash = 79 * hash + Objects.hashCode(this.subtotal);
        hash = 79 * hash + Objects.hashCode(this.avgprice);
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
        final BookStatView other = (BookStatView) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.amount, other.amount)) {
            return false;
        }
        if (!Objects.equals(this.subtotal, other.subtotal)) {
            return false;
        }
        if (!Objects.equals(this.avgprice, other.avgprice)) {
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
