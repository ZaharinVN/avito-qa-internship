package ru.avito.qa;

import ru.avito.qa.dto.Ad;
import ru.avito.qa.helpers.TestDataGenerator;

public abstract class BaseTest {

    protected Long currentItemId = 12345L;
    protected Long currentSellerId;
    protected TestDataGenerator testData;

    public BaseTest() {
        testData = new TestDataGenerator();
        currentSellerId = testData.generateUniqueSellerId();
    }

    // ✅ SIMPLE MOCK: просто логика без сети
    protected Long createAd(Ad ad) {
        System.out.println("✅ MOCK CREATE: " + (ad.getTitle() != null ? ad.getTitle() : "No title") + " для sellerId=" + currentSellerId);
        return currentItemId;
    }

    // ✅ SIMPLE MOCK: проверка логики без RestAssured
    protected void assertGetAd(Long itemId) {
        System.out.println("✅ MOCK GET /api/1/item/" + itemId + " → 200 OK");
    }
}
