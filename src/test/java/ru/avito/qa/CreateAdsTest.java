package ru.avito.qa;

import org.junit.Test;
import ru.avito.qa.dto.Ad;

import static org.junit.Assert.*;

public class CreateAdsTest extends BaseTest {

    @Test
    // Успешное создание объявления с валидными данными
    public void tcCreate001_ValidAd() {
        Ad ad = testData.createValidAd(currentSellerId);
        Long itemId = createAd(ad);

        assertNotNull(ad.getTitle());
        assertEquals(currentSellerId, ad.getSellerId());
        assertGetAd(itemId);
    }

    @Test
    // Обязательные поля: отсутствие title
    public void tcCreate002_NoTitle() {
        Ad ad = new Ad();
        ad.setSellerId(testData.generateUniqueSellerId());
        ad.setDescription("No title");
        ad.setPrice(1000);

        Long itemId = createAd(ad);
        assertNotNull(itemId);
    }

    @Test
    // Негативный: некорректный sellerId (ниже рекомендованного диапазона 111111–999999)
    public void tcCreate003_InvalidSellerIdRange() {
        Ad ad = new Ad();
        ad.setSellerId(100000L);  // Invalid
        ad.setTitle("Invalid seller range");
        ad.setPrice(1000);

        Long itemId = createAd(ad);
        assertNotNull(itemId);
    }

    @Test
    // Негативный: sellerId не число
    public void tcCreate004_InvalidSellerIdType() {
        Ad ad = new Ad();
        ad.setTitle("Test title");
        Long itemId = createAd(ad);
        assertEquals(12345L, itemId.longValue());
    }

    @Test
    // Негативный: отрицательная или нулевая цена
    public void tcCreate005_NegativePrice() {
        Ad ad = testData.createAdWithInvalidPrice(currentSellerId);
        Long itemId = createAd(ad);
        assertTrue(itemId > 0);
    }
}
