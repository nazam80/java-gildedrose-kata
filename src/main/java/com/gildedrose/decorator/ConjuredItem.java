package com.gildedrose.decorator;

import com.gildedrose.Item;

public class ConjuredItem extends UpdatableItem{
    

    public ConjuredItem(Item item){
        super(item);
    }
    public void update() {
	decreaseQuality();
	decreaseQuality();
	decreaseSellIn();
	if (isUnderMinSellin()) {
	    decreaseQuality();
	    decreaseQuality();
	}
    }
}