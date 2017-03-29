package com.gildedrose;

import org.junit.Test;

import junit.framework.Assert;

public class GildedRoseTest {
	

	private Item[] items;
	private GildedRose gildedRose;
	
	private Item item(String name, int sellIn, int quality) {
		return new Item(name, sellIn, quality);
	}
	
	private void updateQuality() {
		gildedRose = new GildedRose(items);
    	gildedRose.updateQuality();
	}
	
    @Test
    public void updateQualityForAgedBrie(){
    	items = new Item[]{item("Aged Brie", 2, 10)};
    	updateQuality();
    	Assert.assertEquals(11, gildedRose.items[0].quality);
    }
    
    @Test
    public void updateQualityForDexterityVest(){
    	items = new Item[]{item("+5 Dexterity Vest", 2, 10)};
    	updateQuality();
    	Assert.assertEquals(11, gildedRose.items[0].quality);
    }
    
    @Test
    public void updateQualityForNormalItems(){
    	items = new Item[]{item("Elixir of the Mongoose", 5, 7)};
    	updateQuality();
    	Assert.assertEquals(6, gildedRose.items[0].quality);
    }
    
    @Test
    public void dontChangeQualityForSulfuras(){
    	items = new Item[]{item("Sulfuras, Hand of Ragnaros", 5 , 80)};
    	updateQuality();
    	Assert.assertEquals(80, gildedRose.items[0].quality);
    }
    
    @Test
    public void increaseQualityBy1ForBackstagePassesToATafkalConcertWhenSellInGreaterThan10(){
    	items = new Item[]{item("Backstage passes to a TAFKAL80ETC concert", 11 , 45)};
    	updateQuality();
    	Assert.assertEquals(46, gildedRose.items[0].quality);
    }
    
    @Test
    public void increaseQualityBy2ForBackstagePassesToATafkalConcertWhenSellInBetween6and10(){
    	items = new Item[]{item("Backstage passes to a TAFKAL80ETC concert", 6 , 45)};
    	updateQuality();
    	Assert.assertEquals(47, gildedRose.items[0].quality);
    }
    
    @Test
    public void increaseQualityBy3ForBackstagePassesToATafkalConcertWhenSellInIs5DaysOrLess(){
    	items = new Item[]{item("Backstage passes to a TAFKAL80ETC concert", 5 , 45)};
    	updateQuality();
    	Assert.assertEquals(48, gildedRose.items[0].quality);
    }
    
    @Test
    public void degradeQualityTwiceFastForConjured(){
    	items = new Item[]{item("Conjured Mana Cake", 10 , 20)};
    	updateQuality();
    	Assert.assertEquals(18, gildedRose.items[0].quality);
    }
    
    @Test
    public void qualityNeverBecomesNegative(){
    	items = new Item[]{item("Elixir of the Mongoose", 5, 0)};
    	updateQuality();
    	Assert.assertEquals(0, gildedRose.items[0].quality);
    }
    
    @Test
    public void qualityNeverGoBeyond50(){
    		items = new Item[]{item("Aged Brie", 5, 50)};
    	updateQuality();
    	Assert.assertEquals(50, gildedRose.items[0].quality);
    }
    
    @Test
    public void dontChangeSellInForSulfuras(){
    	items = new Item[]{item("Sulfuras, Hand of Ragnaros", 5, 50),
    				item("Sulfuras, Hand of Ragnaros", 90, 80)};
		updateSellIn();
    	Assert.assertEquals(5, gildedRose.items[0].sellIn);
    	Assert.assertEquals(90, gildedRose.items[1].sellIn);
    }
    
    @Test
    public void updateSellInForNormalItems(){
    	items = new Item[]{item("Aged Brie", 5, 50),
    				item("Elixir of the Mongoose", 35, 0)};
		updateSellIn();
    	Assert.assertEquals(4, gildedRose.items[0].sellIn);
    	Assert.assertEquals(34, gildedRose.items[1].sellIn);
    }
    
    private void updateSellIn() {
		gildedRose = new GildedRose(items);
    	gildedRose.updateSellIn();
	}
    
}