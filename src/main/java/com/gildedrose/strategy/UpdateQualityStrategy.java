package com.gildedrose.strategy;

import com.gildedrose.Item;

public abstract class UpdateQualityStrategy {
    
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String AGED_BRIE = "Aged Brie";

    private static final int MIN_QUALITY = 0;
    private static final int MAX_QUALITY = 50;
    private static final int QUALITY_TO_INCREASE_DECREASE = 1;

    private static final int MIN_SELLIN = 0;
    private static final int SELLIN_DECREASE = 1;


    public static UpdateQualityStrategy create(Item item) {
	switch (item.getName()) {
	case AGED_BRIE:
	    return new AgedBrieStrategy();	    
	case BACKSTAGE_PASSES:
	    return new BackStageStrategy();	    
	case SULFURAS_HAND_OF_RAGNAROS:
	    return new SulfurasStrategy();	    
	default:
	    return new DefaultStrategy();	    
	}    
    }
    

    public abstract void updateQuality(Item item) ;
    
    protected boolean isUnderMinSellin(Item item) {
	return item.getSellIn() < MIN_SELLIN;
    }


    protected void resetQuality(Item item) {
	item.setQuality(MIN_QUALITY);
    }

    protected void decreaseSellIn(Item item) {
	item.setSellIn(item.getSellIn() - SELLIN_DECREASE);
    }

    protected void decreaseQuality(Item item) {
	if (canDecreaseQuality(item)) {
	    item.setQuality(item.getQuality() - QUALITY_TO_INCREASE_DECREASE);
	}
    }

    protected boolean canDecreaseQuality(Item item) {
	return item.getQuality() > MIN_QUALITY;
    }

    protected void increaseQuality(Item item) {
	if (canIncreaseQuality(item)) {
	    item.setQuality(item.getQuality() + QUALITY_TO_INCREASE_DECREASE);
	}
    }

    protected boolean canIncreaseQuality(Item item) {
	return item.getQuality() < MAX_QUALITY;
    }
}
