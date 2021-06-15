package com.gildedrose.Items;

public class BackstagePasses implements CustomizedItem {

    private final Item item;

    public BackstagePasses(Item item) {
        this.item = item;
    }

    @Override
    public void updateState() {
        item.quality = backStageQuality();
        item.sellIn = decreaseSellIn();
    }

    private int backStageQuality() {
        item.quality = increaseQuality();
        if (item.sellIn < 11) {
            item.quality = isLessThanHighestAllowedQualityValue();
        }
        if (item.sellIn < 6) {
            item.quality = isLessThanHighestAllowedQualityValue();
        }
        if (item.sellIn <= 0) {
            item.quality = 0;
        }
        return item.quality;
    }

    private int increaseQuality() {
        item.quality = item.quality + 1;
        return item.quality;
    }

    private int isLessThanHighestAllowedQualityValue() {
        if (item.quality < 50) {
            item.quality = increaseQuality();
        }
        return item.quality;
    }
    public  int decreaseSellIn() {
        item.sellIn = item.sellIn - 1;
        return item.sellIn;
    }
}
