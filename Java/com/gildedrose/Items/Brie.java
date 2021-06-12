package com.gildedrose.Items;

public class Brie extends Item implements CustomizedItem {

    public Brie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateState(int sellIn, int quality) {

    }

    @Override
    public int decreaseQuality(int sellIn, int quality) {
        return 0;
    }

    @Override
    public int decreaseSellIn(int sellIn) {
        return 0;
    }
}
