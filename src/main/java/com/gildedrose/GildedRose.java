package com.gildedrose;

import com.gildedrose.decorator.UpdatableItem;

public class GildedRose {

      private Item[] items;

    public GildedRose(Item[] items) {
	super();
	this.items = items;
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
