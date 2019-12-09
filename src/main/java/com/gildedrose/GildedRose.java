package com.gildedrose;


public class GildedRose {
	private Item[] items;

    public GildedRose(Item[] items) {
        super();
        this.items = items;
    }

    public GildedRose() {
        super();
        items = new Item[]{
            new Item("Ordinary item", 10, 20),
            new Item("Aged Brie", 2, 0),            
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)            
        };

    }

    public void updateQuality() {
    	for (Item item : items) {    		
            if (item.getName().equals("Aged Brie") ) {
            	increaseQuality(item);
            	decreaseSellIn(item);
    			if (item.getSellIn() < 0) {
    				increaseQuality(item);
    				
    			}
    			
            }else if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert") ) {
    			increaseQuality(item);
    			if (item.getSellIn() < 11) {     
                	increaseQuality(item);
                    
                }
    			if (item.getSellIn() < 6) {      
                	increaseQuality(item);                	
                }
    			
    			decreaseSellIn(item);
    			if (item.getSellIn() < 0) {
                	resetQuality(item);
                }
    		}else if (!item.getName().equals("Sulfuras, Hand of Ragnaros")) {
                decreaseQuality(item);
                decreaseSellIn(item);
                if (item.getSellIn() < 0) {
                	decreaseQuality(item);
                }
    		}
            
        }
    }

	private void resetQuality(Item item) {
		item.setQuality(0);
	}

	private void decreaseSellIn(Item item) {
		item.setSellIn(item.getSellIn() - 1);
	}

	private void decreaseQuality(Item item) {
		if (item.getQuality() > 0) {
			 item.setQuality(item.getQuality() - 1);                
		}
	}

	private void increaseQuality(Item item) {
		if (item.getQuality() < 50) {
		    item.setQuality(item.getQuality() + 1);
		}
	}
}
