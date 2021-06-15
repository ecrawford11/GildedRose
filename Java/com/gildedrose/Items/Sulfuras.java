package com.gildedrose.Items;

import com.gildedrose.InvalidQualityException;

public class Sulfuras implements CustomizedItem {

    private final Item item;

    public Sulfuras(Item item) {
        this.item = item;
    }

    public void updateState() {
    }

    @Override
    public void checkMinAndMaxQuality() throws InvalidQualityException {
        if (item.quality != 80) {
            throw new InvalidQualityException("Sulfuras quality must equal 80");
        }
    }
}
