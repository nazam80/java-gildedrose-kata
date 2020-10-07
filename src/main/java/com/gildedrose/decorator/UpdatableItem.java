package com.gildedrose.decorator;

import com.gildedrose.Item;

public class UpdatableItem extends Item {

    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String AGED_BRIE = "Aged Brie";

    private static final int MIN_QUALITY = 0;
    private static final int MAX_QUALITY = 50;
    private static final int QUALITY_TO_INCREASE_DECREASE = 1;

    private static final int MIN_SELLIN = 0;
    private static final int SELLIN_DECREASE = 1;

    private Item item;

    public UpdatableItem(Item item) {
	super(item.getName(), item.getSellIn(), item.getQuality());
	this.item = item;
    }

    public String getName() {
	return item.getName();
    }

    public int getSellIn() {
	return item.getSellIn();
    }

    public int getQuality() {
	return item.getQuality();
    }

    public void update() {
	switch (item.getName()) {
	case AGED_BRIE:
	    new AgedBrieItem(item).update();
	    break;
	case BACKSTAGE_PASSES:
	    new BackStageItem(item).update();
	    break;
	case SULFURAS_HAND_OF_RAGNAROS:
	    new SulfurasItem(item).update();
	    break;
	default:
	    new DefaultItem(item).update();	    
	}

    }

    protected boolean isUnderMinSellin() {
	return item.getSellIn() < MIN_SELLIN;
    }

    protected void resetQuality() {
	item.setQuality(MIN_QUALITY);
    }

    protected void decreaseSellIn() {
	item.setSellIn(item.getSellIn() - SELLIN_DECREASE);
    }

    protected void decreaseQuality() {
	if (canDecreaseQuality()) {
	    item.setQuality(item.getQuality() - QUALITY_TO_INCREASE_DECREASE);
	}
    }

    protected boolean canDecreaseQuality() {
	return item.getQuality() > MIN_QUALITY;
    }

    protected void increaseQuality() {
	if (canIncreaseQuality()) {
	    item.setQuality(item.getQuality() + QUALITY_TO_INCREASE_DECREASE);
	}
    }

    protected boolean canIncreaseQuality() {
	return item.getQuality() < MAX_QUALITY;
    }
}
