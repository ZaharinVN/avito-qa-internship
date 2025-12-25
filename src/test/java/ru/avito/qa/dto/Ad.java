package ru.avito.qa.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ad {

    @JsonProperty("id")
    private Long itemId;

    @JsonProperty("sellerId")
    private Long sellerId;

    private String title;
    private String description;
    private Integer price;

    public Ad() {
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

