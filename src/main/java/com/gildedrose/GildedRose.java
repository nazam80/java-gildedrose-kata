package com.gildedrose;

public class GildedRose {

    private static final String ORDINARY_ITEM = "Ordinary item";
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
	    switch (item.getName()) {
	    case AGED_BRIE:
		increaseQuality(item);
		decreaseSellIn(item);
		if (item.getSellIn() < MIN_SELLIN) {
		    increaseQuality(item);

		}

		break;
	    case BACKSTAGE_PASSES:
		increaseQuality(item);
		if (item.getSellIn() < NUMBER_OF_DAYS_INCREASE_QUALITY_BY_2) {
		    increaseQuality(item);

		}
		if (item.getSellIn() < NUMBER_OF_DAYS_INCREASE_QUALITY_BY_3) {
		    increaseQuality(item);
		}

		decreaseSellIn(item);
		if (item.getSellIn() < MIN_SELLIN) {
		    resetQuality(item);
		}
		break;
	    case SULFURAS_HAND_OF_RAGNAROS:
		break;
	    default:
		decreaseQuality(item);
		decreaseSellIn(item);
		if (item.getSellIn() < MIN_SELLIN) {
		    decreaseQuality(item);
		}
	    }

	}
    }

    private void resetQuality(Item item) {
	item.setQuality(MIN_QUALITY);
    }

    private void decreaseSellIn(Item item) {
	item.setSellIn(item.getSellIn() - SELLIN_DECREASE);
    }

    private void decreaseQuality(Item item) {
	if (item.getQuality() > MIN_QUALITY) {
	    item.setQuality(item.getQuality() - QUALITY_TO_INCREASE_DECREASE);
	}
    }

    private void increaseQuality(Item item) {
	if (item.getQuality() < MAX_QUALITY) {
	    item.setQuality(item.getQuality() + QUALITY_TO_INCREASE_DECREASE);
	}
    }
}
