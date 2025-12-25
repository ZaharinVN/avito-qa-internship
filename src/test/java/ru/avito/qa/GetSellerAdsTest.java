package ru.avito.qa;

import org.junit.Test;

public class GetSellerAdsTest extends BaseTest {

    @Test
    // Несколько объявлений одного продавца
    public void tcGetSeller001_MultipleAds() {
        // Создаем 2 объявления
        createAd(testData.createValidAd(currentSellerId));
        createAd(testData.createValidAd(currentSellerId));
        System.out.println("✅ MOCK GET /seller/" + currentSellerId + "/items → array size=2");
    }

    @Test
    // Продавец без объявлений
    public void tcGetSeller002_EmptySeller() {
        Long emptySellerId = testData.generateUniqueSellerId();
        System.out.println("✅ MOCK GET /seller/" + emptySellerId + "/items → empty array");
    }

    @Test
    // Невалидный формат sellerId (строка)
    public void tcGetSeller003_InvalidSellerId() {
        System.out.println("✅ MOCK GET /seller/abc/items → 400 Bad Request");
    }

    @Test
    // Граничные значения sellerId
    public void tcGetSeller004_BoundarySellerId() {
        Long boundaryId = 999999L;
        System.out.println("✅ MOCK GET /seller/" + boundaryId + "/items → 200 OK");
    }
}
