package com.gildedrose;

import com.gildedrose.decorator.UpdatableItem;

public class GildedRose {

    private static final String ORDINARY_ITEM = "Ordinary item";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String AGED_BRIE = "Aged Brie";


    private Item[] items;

    public GildedRose(Item[] items) {
	super();
	this.items = items;
    }

    public GildedRose() {
	super();
	items = new Item[] { new Item(ORDINARY_ITEM, 10, 20), new Item(AGED_BRIE, 2, 0),
		new Item(SULFURAS_HAND_OF_RAGNAROS, 0, 80), new Item(BACKSTAGE_PASSES, 15, 20) };

    }

    public void updateQuality() {
	for (Item item : items) {	    
	    decorateItem(item).update();
	}
    }

    private UpdatableItem decorateItem(Item item) {	
	return UpdatableItem.create(item);
    }

}
