package com.gildedrose;

import java.util.ArrayList;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
//refactor all of this!
    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }

//should solve to just use the category rather than the entire name.
    public void getCategoryModifier(){
        for (Item item:items
             ) {
            switch(item.name){
                case "Conjured Mana Cake":
                    qualityDegradeTwiceAsFast();
                case "Sulfuras, Hand of Ragnaros":
                    doNothing();
                case "Aged Brie":
                    increaseQuality();
                case "Backstage passes to a TAFKAL80ETC concert":
                    addQualityAndSaleInQualifier();
                default:
            }

        }

        }

    private void addQualityAndSaleInQualifier() {
    }

    private void increaseQuality() {
    }

    private void doNothing() {
    }

    private void qualityDegradeTwiceAsFast() {
    }
}

