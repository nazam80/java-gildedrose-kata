package com.gildedrose;

import com.gildedrose.strategy.UpdateQualityStrategy;

public class GildedRose {

    private Item[] items;

    public GildedRose(Item[] items) {
	super();
	this.items = items;
    }

    public void updateQuality() {
	for (Item item : items) {
	    UpdateQualityStrategy strategy = UpdateQualityStrategy.create(item);
	    strategy.updateQuality(item);
	}
    }

}
