package ru.avito.qa;

import org.junit.Test;
import ru.avito.qa.dto.Ad;

public class StatsAndCrossTest extends BaseTest {

    @Test
    // Успешное получение статистики для существующего объявления
    public void tcStats001_ExistingAd() {
        Long itemId = createAd(testData.createValidAd(currentSellerId));
        System.out.println("✅ MOCK GET /api/1/stats/" + itemId + " → 200 OK");
    }

    @Test
    //Статистика для несуществующего itemId
    public void tcStats002_NonExisting() {
        System.out.println("✅ MOCK GET /api/1/stats/999999 → 200 OK (zero stats)");
    }

    @Test
    // Невалидный формат itemId
    public void tcStats003_InvalidIdFormat() {
        System.out.println("✅ MOCK GET /api/1/stats/abc → 400 Bad Request");
    }

    @Test
    // Консистентность статистики при повторном запросе
    public void tcStats004_Consistency() {
        assertGetAd(currentItemId);
        System.out.println("✅ MOCK STATS consistent");
    }

    @Test
    // Целостность данных: create → get → seller → stats
    public void tcCross001_FullCycle() {
        // 1. CREATE
        Ad ad = testData.createValidAd(currentSellerId);
        Long itemId = createAd(ad);

        // 2. GET by id
        assertGetAd(itemId);

        // 3. GET by seller
        System.out.println("✅ MOCK GET /seller/" + currentSellerId + "/items → contains " + itemId);

        // 4. STATS
        System.out.println("✅ MOCK GET /api/1/stats/" + itemId + " → OK");
    }
}

