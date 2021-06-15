package com.gildedrose.Items;

public class Conjured implements CustomizedItem {

    private final Item item;

    public Conjured(Item item) {
        this.item = item;
    }

    @Override
    public void updateState() {
        item.quality = qualityDegradeTwiceAsFast(item.quality);
        item.sellIn = decreaseSellIn(item.sellIn);
    }
    private int qualityDegradeTwiceAsFast(int quality) {
        quality = quality - 2;
        return quality;
    }
    private int decreaseSellIn(int sellIn) {
        sellIn = sellIn - 1;
        return sellIn;
    }
}
