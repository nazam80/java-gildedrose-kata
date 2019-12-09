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
            	if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);
    			}
            	item.setSellIn(item.getSellIn() - 1);
    			if (item.getSellIn() < 0) {
    				if (item.getQuality() < 50) {
                        item.setQuality(item.getQuality() + 1);
                    }
    				
    			}
    			
            }else if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert") ) {
    			if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);
    			}
    			if (item.getSellIn() < 11) {     
                	if (item.getQuality() < 50) {
                        item.setQuality(item.getQuality() + 1);
                	}
                    
                }
    			if (item.getSellIn() < 6) {      
                	if (item.getQuality() < 50) {
                        item.setQuality(item.getQuality() + 1);
                	}                	
                }
    			
    			item.setSellIn(item.getSellIn() - 1);
    			if (item.getSellIn() < 0) {
                	item.setQuality(item.getQuality()
                            - item.getQuality());
                }
    		}else if (!item.getName().equals("Sulfuras, Hand of Ragnaros")) {
                if (item.getQuality() > 0) {
                	 item.setQuality(item.getQuality() - 1);                
                }
                item.setSellIn(item.getSellIn() - 1);
                if (item.getSellIn() < 0) {
                	if (item.getQuality() > 0) {
                		item.setQuality(item.getQuality() - 1);
                	}
                }
    		}
            
        }
    }
}
