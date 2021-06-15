package com.gildedrose.Items;

import com.gildedrose.InvalidQualityException;

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

    @Override
    public void checkMinAndMaxQuality() throws InvalidQualityException {
        if (item.quality > 50 || item.quality < 0) {
            throw new InvalidQualityException("Conjured quality cannot equal more than 50 or less than zero");
        }
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
