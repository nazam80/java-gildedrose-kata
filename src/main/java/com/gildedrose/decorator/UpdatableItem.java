package com.gildedrose.decorator;

import com.gildedrose.Item;

public abstract class UpdatableItem extends Item {

    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String AGED_BRIE = "Aged Brie";

    private static final int MIN_QUALITY = 0;
    private static final int MAX_QUALITY = 50;
    private static final int QUALITY_TO_INCREASE_DECREASE = 1;

    private static final int MIN_SELLIN = 0;
    private static final int SELLIN_DECREASE = 1;

    private Item item;
    
    public static UpdatableItem create(Item item) {
	switch (item.getName()) {
	case AGED_BRIE:
	    return new AgedBrieItem(item);	    
	case BACKSTAGE_PASSES:
	    return new BackStageItem(item);	    
	case SULFURAS_HAND_OF_RAGNAROS:
	    return new SulfurasItem(item);	    
	default:
	    return new DefaultItem(item);	    
	}    
    }

    protected UpdatableItem(Item item) {
	super(item.getName(), item.getSellIn(), item.getQuality());
	this.item = item;
    }

    public String getName() {
        return  item.getName();
    }

    public void setName(String name) {
	 item.setName(name);
    }

    public int getSellIn() {
        return item.getSellIn();
    }

    public void setSellIn(int sellIn) {
	item.setSellIn(sellIn);
    }

    public int getQuality() {
 	return item.getQuality();
     }

    public void setQuality(int quality) {
	item.setQuality(quality);
    }
    
    public abstract void update();
	

    protected boolean isUnderMinSellin() {
	return getSellIn() < MIN_SELLIN;
    }

    protected void resetQuality() {
	setQuality(MIN_QUALITY);
    }

    protected void decreaseSellIn() {
	setSellIn(getSellIn() - SELLIN_DECREASE);
    }

    protected void decreaseQuality() {
	if (canDecreaseQuality()) {
	    setQuality(getQuality() - QUALITY_TO_INCREASE_DECREASE);
	}
    }

    protected boolean canDecreaseQuality() {
	return getQuality() > MIN_QUALITY;
    }

    protected void increaseQuality() {
	if (canIncreaseQuality()) {
	    setQuality(getQuality() + QUALITY_TO_INCREASE_DECREASE);
	}
    }

    protected boolean canIncreaseQuality() {
	return getQuality() < MAX_QUALITY;
    }
}
