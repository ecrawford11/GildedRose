package com.gildedrose.Items;

public class Conjured extends Item implements CustomizedItem  {
    public Conjured(String name, int sellIn, int quality) {
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
    public  static int qualityDegradeTwiceAsFast(int quality) {
        quality = quality - 2;
        return quality;
    }
}
