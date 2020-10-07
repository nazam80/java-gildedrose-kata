package com.gildedrose.strategy;

import com.gildedrose.Item;

public class ConjuredtStrategy extends UpdateQualityStrategy {

    public void updateQuality(Item item) {
	decreaseQuality(item);
	decreaseQuality(item);
	decreaseSellIn(item);
	if (isUnderMinSellin(item)) {
	    decreaseQuality(item);
	    decreaseQuality(item);
	}
    }
}