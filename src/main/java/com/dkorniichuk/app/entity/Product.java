package com.dkorniichuk.app.entity;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Product  {
    private int Id;
    private ProductCategory productCategory;
    private String name;
    private double price;
    private byte[] image;
    private String description;
    private LocalDateTime appearanceDate;
    private int availableAmount;
    private LocalDateTime lastModifiedDate;

    public Product() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getAppearanceDate() {
        return appearanceDate;
    }

    public void setAppearanceDate(LocalDateTime appearanceDate) {
        this.appearanceDate = appearanceDate;
    }

    public int getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(int availableAmount) {
        this.availableAmount = availableAmount;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Id=" + Id +
                ", productCategory=" + productCategory +
                ", name='" + name + '\'' +
                ", price=" + price +
               // ", image=" + Arrays.toString(image) +
                ", description='" + description + '\'' +
                ", appearanceDate=" + appearanceDate +
                ", availableAmount=" + availableAmount +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}