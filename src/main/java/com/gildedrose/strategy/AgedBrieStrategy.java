package com.gildedrose.strategy;

import com.gildedrose.Item;

public class AgedBrieStrategy extends UpdateQualityStrategy {

    public void updateQuality(Item item) {
	increaseQuality(item);
	decreaseSellIn(item);
	if (isUnderMinSellin(item)) {
	    increaseQuality(item);

	}
    }

}
