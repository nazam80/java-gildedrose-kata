package com.gildedrose.strategy;

import com.gildedrose.Item;

public class BackStageStrategy extends UpdateQualityStrategy {

    private static final int NUMBER_OF_DAYS_INCREASE_QUALITY_BY_3 = 6;
    private static final int NUMBER_OF_DAYS_INCREASE_QUALITY_BY_2 = 11;
    

    public void updateQuality(Item item) {
	increaseQuality(item);
	if (shouldIncreaseQualityBy2(item)) {
	    increaseQuality(item);

	}
	if (shouldIncreaseQualityBy3(item)) {
	    increaseQuality(item);
	}

	decreaseSellIn(item);
	if (isUnderMinSellin(item)) {
	    resetQuality(item);
	}

    }
    
    protected boolean shouldIncreaseQualityBy3(Item item) {
	return item.getSellIn() < NUMBER_OF_DAYS_INCREASE_QUALITY_BY_3;
    }

    protected boolean shouldIncreaseQualityBy2(Item item) {
	return item.getSellIn() < NUMBER_OF_DAYS_INCREASE_QUALITY_BY_2;
    }
}