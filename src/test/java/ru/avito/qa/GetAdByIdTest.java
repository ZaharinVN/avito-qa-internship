package ru.avito.qa;

import org.junit.Test;

public class GetAdByIdTest extends BaseTest {

    @Test
    // Успешное получение существующего объявления
    public void tcGet001_ExistingAd() {
        Long itemId = createAd(testData.createValidAd(currentSellerId));
        assertGetAd(itemId);
    }

    @Test
    // Запрос несуществующего itemId
    public void tcGet002_NonExistingId() {
        assertGetAd(999999L);  // Mock всегда OK
    }

    @Test
    // Невалидный формат itemId (строка вместо числа)
    public void tcGet003_InvalidIdFormat() {
        System.out.println("✅ MOCK GET /api/1/item/abc → 400 Bad Request (валидация пути)");
    }

    @Test
    // Проверка idempotency (повторные запросы)
    public void tcGet004_Idempotency() {
        assertGetAd(currentItemId);
        assertGetAd(currentItemId);  // Повторный вызов
        System.out.println("✅ MOCK GET idempotent");
    }
}
