package com.gildedrose.Items;

public interface CustomizedItem {


    public default void updateState(int sellIn, int quality) {
        quality = decreaseQuality(sellIn,quality);
        sellIn = decreaseSellIn(sellIn);
    }
    public default int decreaseQuality(int sellIn, int quality) {
        if (sellIn <=0&quality >0){
            quality=qualityDegradeTwiceAsFast(quality);
        } else if (quality >0){
            quality = quality - 1;}

        return quality;
    }
    public  static int qualityDegradeTwiceAsFast(int quality) {
        quality = quality - 2;
        return quality;
    }

    public default int decreaseSellIn(int sellIn) {
        sellIn = sellIn - 1;
        return sellIn;
    }
}
