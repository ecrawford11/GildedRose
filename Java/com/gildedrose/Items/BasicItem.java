package com.gildedrose.Items;

public class BasicItem implements CustomizedItem {

    private final Item item;

    public BasicItem(Item item) {
        this.item = item;
    }

    public void updateState() {
        item.quality = updateQuality();
        item.sellIn = decreaseSellIn();
    }

    public int updateQuality() {
        if (item.sellIn <= 0 & item.quality > 0) {
            item.quality = qualityDegradeTwiceAsFast();
        } else if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        return item.quality;
    }

    public int qualityDegradeTwiceAsFast() {
        item.quality = item.quality - 2;
        return item.quality;
    }

    public int decreaseSellIn() {
        item.sellIn = item.sellIn - 1;
        return item.sellIn;
    }
}
