package com.gildedrose.Items;

public class Brie implements CustomizedItem {

private final Item item;

    public Brie(Item item) {
        this.item = item;
    }

    public void updateState() {
        item.quality = UpdateBrieQuality();
        item.sellIn = decreaseSellIn();
        //in original code, Aged Brie actually increases in quality twice as fast after zero
        if (item.sellIn < 0) {
            item.quality = isLessThanHighestAllowedQualityValue(item.quality);
        }
    }
    public  int UpdateBrieQuality() {
        item.quality = isLessThanHighestAllowedQualityValue(item.quality);

        return item.quality;
    }

    private int isLessThanHighestAllowedQualityValue(int quality) {
        if (quality < 50) {
            quality = increaseQuality(quality);
        }
        return quality;
    }

    private int increaseQuality(int quality) {
        quality = quality + 1;
        return quality;
    }
    public  int decreaseSellIn() {
        item.sellIn = item.sellIn - 1;
        return item.sellIn;
    }
}
