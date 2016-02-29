package com.dkorniichuk.app.entity;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProductCategory {
    private int id;
    private String name;
    private String description;
    private LocalDateTime appearanceDate;

    public ProductCategory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setAppearenceDate(LocalDateTime appearenceDate) {
        this.appearanceDate = appearenceDate;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", appearanceDate=" + appearanceDate +
                '}';
    }
}
