package ru.avito.qa.helpers;

import java.util.concurrent.atomic.AtomicLong;

public class TestDataGenerator {
    private static final AtomicLong sellerIdCounter = new AtomicLong(111111);
    private static final long MIN_SELLER_ID = 111111;
    private static final long MAX_SELLER_ID = 999999;

    public Long generateUniqueSellerId() {
        return sellerIdCounter.getAndIncrement();
    }

    public ru.avito.qa.dto.Ad createValidAd(Long sellerId) {
        return ru.avito.qa.dto.Ad.builder()
                .sellerId(sellerId)
                .title("Test Ad - " + System.currentTimeMillis())
                .description("Test description for automation")
                .price(1000 + (int)(Math.random() * 9000))
                .build();
    }

    public ru.avito.qa.dto.Ad createAdWithInvalidPrice(Long sellerId) {
        return ru.avito.qa.dto.Ad.builder()
                .sellerId(sellerId)
                .title("Invalid Price Ad")
                .description("Price is negative")
                .price(-100)
                .build();
    }
}
