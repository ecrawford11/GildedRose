package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    //refactor all of this!
    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {

            switch (items[i].name) {
                case "Sulfuras, Hand of Ragnaros":
                    break;
                case "Conjured Mana Cake":
                    items[i].quality = qualityDegradeTwiceAsFast(items[i].quality);
                    items[i].sellIn = decreaseSellIn(items[i].sellIn);
                    break;
                case "Aged Brie":
                    items[i].quality = qualityLessThan50(items[i].quality);
                    items[i].sellIn = decreaseSellIn(items[i].sellIn);
                    //in original code, Aged Brie actually increases in quality twice as fast after zero
                    if (items[i].sellIn < 0) {
                        items[i].quality = qualityLessThan50(items[i].quality);
                    }
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    items[i].quality = backStageQuality(items[i].sellIn, items[i].quality);
                    items[i].sellIn = decreaseSellIn(items[i].sellIn);
                    break;
                default:
                    items[i].quality = decreaseQuality(items[i].sellIn,items[i].quality);
                    items[i].sellIn = decreaseSellIn(items[i].sellIn);

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

    private int qualityLessThan50(int quality) {
        if (quality < 50) {
            quality = increaseQuality(quality);
        }
        return quality;
    }

    private int backStageQuality(int sellIn, int quality) {
        quality =increaseQuality(quality);
        if (sellIn < 11) {
            quality=qualityLessThan50(quality);
        }
        if (sellIn < 6) {
            quality= qualityLessThan50(quality);
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


