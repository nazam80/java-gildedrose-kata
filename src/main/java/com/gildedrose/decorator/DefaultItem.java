package com.gildedrose.decorator;

import com.gildedrose.Item;

public class DefaultItem extends UpdatableItem{
    

    public DefaultItem(Item item){
        super(item);
    }

    public void update() {
	decreaseQuality();
	decreaseSellIn();
	if (isUnderMinSellin()) {
	    decreaseQuality();
	}
    }
}