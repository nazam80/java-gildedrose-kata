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

    private static final int NUMBER_OF_DAYS_INCREASE_QUALITY_BY_3 = 6;
    private static final int NUMBER_OF_DAYS_INCREASE_QUALITY_BY_2 = 11;

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
	    increaseQuality();
	    decreaseSellIn();
	    if (isUnderMinSellin()) {
		increaseQuality();

	    }

	    break;
	case BACKSTAGE_PASSES:
	    increaseQuality();
	    if (shouldIncreaseBackstageQualityBy2()) {
		increaseQuality();

	    }
	    if (shouldIncreaseBackstageQualityBy3()) {
		increaseQuality();
	    }

	    decreaseSellIn();
	    if (isUnderMinSellin()) {
		resetQuality();
	    }
	    break;
	case SULFURAS_HAND_OF_RAGNAROS:
	    break;
	default:
	    decreaseQuality();
	    decreaseSellIn();
	    if (isUnderMinSellin()) {
		decreaseQuality();
	    }
	}

    }

    private boolean isUnderMinSellin() {
	return item.getSellIn() < MIN_SELLIN;
    }

    private boolean shouldIncreaseBackstageQualityBy3() {
	return item.getSellIn() < NUMBER_OF_DAYS_INCREASE_QUALITY_BY_3;
    }

    private boolean shouldIncreaseBackstageQualityBy2() {
	return item.getSellIn() < NUMBER_OF_DAYS_INCREASE_QUALITY_BY_2;
    }

    private void resetQuality() {
	item.setQuality(MIN_QUALITY);
    }

    private void decreaseSellIn() {
	item.setSellIn(item.getSellIn() - SELLIN_DECREASE);
    }

    private void decreaseQuality() {
	if (canDecreaseQuality()) {
	    item.setQuality(item.getQuality() - QUALITY_TO_INCREASE_DECREASE);
	}
    }

    private boolean canDecreaseQuality() {
	return item.getQuality() > MIN_QUALITY;
    }

    private void increaseQuality() {
	if (canIncreaseQuality()) {
	    item.setQuality(item.getQuality() + QUALITY_TO_INCREASE_DECREASE);
	}
    }

    private boolean canIncreaseQuality() {
	return item.getQuality() < MAX_QUALITY;
    }
}
