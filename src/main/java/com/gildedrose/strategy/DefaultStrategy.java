package com.gildedrose.strategy;

import com.gildedrose.Item;

public class DefaultStrategy extends UpdateQualityStrategy {

    public void updateQuality(Item item) {
	decreaseQuality(item);
	decreaseSellIn(item);
	if (isUnderMinSellin(item)) {
	    decreaseQuality(item);
	}
    }
}