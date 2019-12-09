package com.gildedrose;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class GildedRoseTest {

	@Test
    public void should_never_change_quailty_of_Sulfuras() throws Exception {
		
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);

        GildedRose gildedRose = new GildedRose((Item[]) Arrays.asList(new Item("Sulfuras, Hand of Ragnaros", 0, 80)).toArray());

        gildedRose.updateQuality();

        assertEquals(80, sulfuras.getQuality());
    }

    @Test
    public void should_never_change_sellIn_of_Sulfuras() throws Exception {
    	
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);

        GildedRose gildedRose = new GildedRose((Item[]) Arrays.asList(sulfuras).toArray());

        gildedRose.updateQuality();

        assertEquals(0, sulfuras.getSellIn());
    }

    @Test
    public void should_lower_the_sellIn_by_one_for_ordinary_items() throws Exception {
    	
        Item ordinaryItem = new Item("Ordinary item", 10, 20);

        GildedRose gildedRose = new GildedRose((Item[]) Arrays.asList(ordinaryItem).toArray());

        gildedRose.updateQuality();

        assertEquals(9, ordinaryItem.getSellIn());
    }

    @Test
    public void should_lower_the_quality_by_one_for_ordinary_items() throws Exception {
    	
        Item ordinaryItem = new Item("Ordinary item", 10, 20);

        GildedRose gildedRose = new GildedRose((Item[]) Arrays.asList(ordinaryItem).toArray());

        gildedRose.updateQuality();

        assertEquals(19, ordinaryItem.getQuality());
    }

    @Test
    public void should_not_lower_the_quality_below_zero() throws Exception {
    	
        Item ordinaryItem = new Item("Ordinary item", 10, 0);

        GildedRose gildedRose = new GildedRose((Item[]) Arrays.asList(ordinaryItem).toArray());

        gildedRose.updateQuality();

        assertEquals(0, ordinaryItem.getQuality());
    }

    @Test
    public void should_lower_the_quality_twice_as_fast_once_the_sell_in_date_has_passed() throws Exception {
        
    	Item ordinaryItem = new Item("Ordinary item", -1, 25);

        GildedRose gildedRose = new GildedRose((Item[]) Arrays.asList(ordinaryItem).toArray());

        gildedRose.updateQuality();

        assertEquals(23, ordinaryItem.getQuality());
    }

    @Test
    public void should_increase_the_quality_of_aged_brie_as_it_gets_older() throws Exception {
    	
        Item agedBrie = new Item("Aged Brie", 10, 25);

        GildedRose gildedRose = new GildedRose((Item[]) Arrays.asList(agedBrie).toArray());

        gildedRose.updateQuality();

        assertEquals(26, agedBrie.getQuality());
    }

    @Test
    public void should_not_increase_the_quality_of_aged_brie_over_50() throws Exception {
    	
        Item agedBrie = new Item("Aged Brie", 10, 50);

        GildedRose gildedRose = new GildedRose((Item[]) Arrays.asList(agedBrie).toArray());

        gildedRose.updateQuality();

        assertEquals(50, agedBrie.getQuality());
    }

    @Test
    public void should_lower_backstage_passes_to_zero_quality_once_event_has_happened() throws Exception {
    	
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20);

        GildedRose gildedRose = new GildedRose((Item[]) Arrays.asList(backstagePass).toArray());

        gildedRose.updateQuality();

        assertEquals(0, backstagePass.getQuality());
    }

    @Test
    public void should_increase_backstage_passes_quality_by_1_when_the_event_is_more_than_10_days_away() throws Exception {
        
    	Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20);

        GildedRose gildedRose = new GildedRose((Item[]) Arrays.asList(backstagePass).toArray());

        gildedRose.updateQuality();

        assertEquals(21, backstagePass.getQuality());
    }

    @Test
    public void should_increase_backstage_passes_quality_by_2_when_the_event_is_10_days_or_less_away() throws Exception {
       
    	Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 27);

        GildedRose gildedRose = new GildedRose((Item[]) Arrays.asList(backstagePass).toArray());

        gildedRose.updateQuality();

        assertEquals(29, backstagePass.getQuality());
    }

    @Test
    public void should_increase_backstage_passes_quality_by_3_when_the_event_is_5_days_or_less_away() throws Exception {
        
    	Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 44);

        GildedRose gildedRose = new GildedRose((Item[]) Arrays.asList(backstagePass).toArray());

        gildedRose.updateQuality();

        assertEquals(47, backstagePass.getQuality());
    }

    @Test
    public void should_not_increase_backstage_passes_above_a_quality_of_50() throws Exception {
        
    	Item backstagePassMoreThan10DaysAway = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50);

        Item backstagePass10DaysAway = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        Item backstagePass5DaysAway = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48);

        GildedRose gildedRose = new GildedRose((Item[]) Arrays.asList(backstagePassMoreThan10DaysAway, 
        		backstagePass10DaysAway, backstagePass5DaysAway).toArray());

        gildedRose.updateQuality();

        assertEquals(50, backstagePassMoreThan10DaysAway.getQuality());
        assertEquals(50, backstagePass10DaysAway.getQuality());
        assertEquals(50, backstagePass5DaysAway.getQuality());
    }
    
    @Test
    public void should_reset_quality_when_0_sellIn_of_backstage_passes() throws Exception {
    	
        Item backstagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 80);

        GildedRose gildedRose = new GildedRose((Item[]) Arrays.asList(backstagePass).toArray());

        gildedRose.updateQuality();

        assertEquals(-1, backstagePass.getSellIn());
        assertEquals(0, backstagePass.getQuality());
    }
    
    @Test
    public void should_not_change_quality_when_0_sellIn_of_aged_brie() throws Exception {
    	
        Item agedBrie = new Item("Aged Brie", 0, 80);

        GildedRose gildedRose = new GildedRose((Item[]) Arrays.asList(agedBrie).toArray());

        gildedRose.updateQuality();

        assertEquals(-1, agedBrie.getSellIn());
        assertEquals(80, agedBrie.getQuality());
    }

}