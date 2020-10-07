package com.gildedrose.decorator;

import com.gildedrose.Item;

public class BackStageItem extends UpdatableItem {

    private static final int NUMBER_OF_DAYS_INCREASE_QUALITY_BY_3 = 6;
    private static final int NUMBER_OF_DAYS_INCREASE_QUALITY_BY_2 = 11;

    
    public BackStageItem(Item item) {
	super(item);
    }

    public void update() {
	increaseQuality();
	if (shouldIncreaseBackstageQualityBy2()) {
	    increaseQuality();

	}
	if (shouldIncreaseBackstageQualityBy3()) {
	    increaseQuality();
	}

	decreaseSellIn();
	if (isUnderMinSellin()) {
	    resetQuality();
	}
    }
    
    protected boolean shouldIncreaseBackstageQualityBy3() {
	return getSellIn() < NUMBER_OF_DAYS_INCREASE_QUALITY_BY_3;
    }

    protected boolean shouldIncreaseBackstageQualityBy2() {
	return getSellIn() < NUMBER_OF_DAYS_INCREASE_QUALITY_BY_2;
    }
}