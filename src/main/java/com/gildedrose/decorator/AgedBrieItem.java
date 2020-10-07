package com.gildedrose.decorator;

import com.gildedrose.Item;

public class AgedBrieItem extends UpdatableItem {

    public AgedBrieItem(Item item) {
	super(item);
    }

    public void update() {
	increaseQuality();
	decreaseSellIn();
	if (isUnderMinSellin()) {
	    increaseQuality();

	}
    }

}
