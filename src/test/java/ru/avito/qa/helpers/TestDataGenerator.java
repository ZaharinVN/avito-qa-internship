package ru.avito.qa.helpers;

import ru.avito.qa.dto.Ad;

import java.util.concurrent.atomic.AtomicLong;

public class TestDataGenerator {
    private static final AtomicLong sellerIdCounter = new AtomicLong(111111);
    private static final long MIN_SELLER_ID = 111111;
    private static final long MAX_SELLER_ID = 999999;

    public Long generateUniqueSellerId() {
        long nextId = sellerIdCounter.getAndIncrement();
        if (nextId > MAX_SELLER_ID) {
            sellerIdCounter.set(MIN_SELLER_ID);
            return MIN_SELLER_ID;
        }
        return nextId;
    }

    public Ad createValidAd(Long sellerId) {
        Ad ad = new Ad();
        ad.setSellerId(sellerId);
        ad.setTitle("Test Ad - " + System.currentTimeMillis());
        ad.setDescription("Test description for automation");
        ad.setPrice(1000 + (int) (Math.random() * 9000));
        return ad;
    }

    public Ad createAdWithInvalidPrice(Long sellerId) {
        Ad ad = new Ad();
        ad.setSellerId(sellerId);
        ad.setTitle("Invalid Price Ad");
        ad.setDescription("Price is negative");
        ad.setPrice(-100);
        return ad;
    }
}

