package com.gildedrose;

import com.gildedrose.Items.Item;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    //refactor all of this!
    public void updateQuality() {

        for (Item item : items) {

            switch (item.name) {
                case "Sulfuras, Hand of Ragnaros":
                    break;
                case "Conjured Mana Cake":
                    item.quality = qualityDegradeTwiceAsFast(item.quality);
                    item.sellIn = decreaseSellIn(item.sellIn);
                    break;
                case "Aged Brie":
                    item.quality = isLessThanHighestAllowedQualityValue(item.quality);
                    item.sellIn = decreaseSellIn(item.sellIn);
                    //in original code, Aged Brie actually increases in quality twice as fast after zero
                    if (item.sellIn < 0) {
                        item.quality = isLessThanHighestAllowedQualityValue(item.quality);
                    }
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    item.quality = backStageQuality(item.sellIn, item.quality);
                    item.sellIn = decreaseSellIn(item.sellIn);
                    break;
                default:
                    item.quality = decreaseQuality(item.sellIn,item.quality);
                    item.sellIn = decreaseSellIn(item.sellIn);

            }
        }
    }

    private int decreaseQuality(int sellIn,int quality) {
        if (sellIn <=0&quality >0){
            quality=qualityDegradeTwiceAsFast(quality);
        } else if (quality >0){
        quality = quality - 1;}

        return quality;
    }

    private int isLessThanHighestAllowedQualityValue(int quality) {
        if (quality < 50) {
            quality = increaseQuality(quality);
        }
        return quality;
    }

    private int backStageQuality(int sellIn, int quality) {
        quality =increaseQuality(quality);
        if (sellIn < 11) {
            quality=isLessThanHighestAllowedQualityValue(quality);
        }
        if (sellIn < 6) {
            quality= isLessThanHighestAllowedQualityValue(quality);
        }
        if (sellIn <= 0) {
            quality = 0;
        }
        return quality;
    }


    private int decreaseSellIn(int sellIn) {
        sellIn = sellIn - 1;
        return sellIn;
    }

    private int increaseQuality(int quality) {
        quality = quality + 1;
        return quality;
    }

    private int qualityDegradeTwiceAsFast(int quality) {
        quality = quality - 2;
        return quality;
    }
}


