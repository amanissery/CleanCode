
package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

class GildedRose {
    private static final int SULFURAS_HAND_OF_RAGNAROS_QUALITY = 80;
	private static final String BACKSTAGE_PASSES_TO_TAFKAL_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
	private static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";
	private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
	private static final String DEXTERITY_VEST = "+5 Dexterity Vest";
	private static final String AGED_BRIE = "Aged Brie";
	private static final String NORMAL_ITEM = "Default";
	private static final int MINIMUM_QUALITY = 0;
	private static final int MAXIMUM_QUALITY = 50;
	private Map<String, Integer> itemNameQualityIndex = new HashMap<>();
	
	Item[] items;
	
    public GildedRose(Item[] items) {
        this.items = items;
    }
    
    public void updateQuality() {
    	buildItemNameQualityIndex();
        for (Item item: items) {
        	updateQuality(item);
        }
    }
    
    public void updateSellIn() {
        for (Item item: items) {
        	if(!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)){
        		item.sellIn -= 1;
        	}
        }
    }
    
    private void buildItemNameQualityIndex(){
    	itemNameQualityIndex.put(AGED_BRIE, 1);
    	itemNameQualityIndex.put(DEXTERITY_VEST, 1);
    	itemNameQualityIndex.put(SULFURAS_HAND_OF_RAGNAROS, 0);
    	itemNameQualityIndex.put(NORMAL_ITEM, -1);
    	itemNameQualityIndex.put(CONJURED_MANA_CAKE, -2);
    }
    
    private void updateQuality(Item item) {
		if(item.name.equals(BACKSTAGE_PASSES_TO_TAFKAL_CONCERT)) {
		    updateBackstagePassesToTafkalQuality(item);
		}else {
			updateNormalItemsQuality(item);
		}
	}
    
    private void updateBackstagePassesToTafkalQuality(Item item) {
		int updatedQuality = (item.sellIn < 6) ? item.quality + 3 : ((item.sellIn < 11) ? item.quality + 2 : item.quality + 1);
		item.quality = ensureQualityLimits(updatedQuality);
	}
    
    private void updateNormalItemsQuality(Item item){
    	int updatedQuality = (itemNameQualityIndex.get(item.name) == null) ? item.quality + getItemQualityIndex(NORMAL_ITEM): 
    		item.quality + getItemQualityIndex(item.name);
    	item.quality = item.name.equals(SULFURAS_HAND_OF_RAGNAROS)? SULFURAS_HAND_OF_RAGNAROS_QUALITY : ensureQualityLimits(updatedQuality);
    }

	private Integer getItemQualityIndex(String itemName) {
		return itemNameQualityIndex.get(itemName);
	}

	private int ensureQualityLimits(int updatedItemQuality) {
		return (updatedItemQuality > MAXIMUM_QUALITY) ? MAXIMUM_QUALITY : 
    			(updatedItemQuality < MINIMUM_QUALITY)? MINIMUM_QUALITY : updatedItemQuality;
	}

	
	
}