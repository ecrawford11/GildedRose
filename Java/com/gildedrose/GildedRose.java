package com.gildedrose;

import com.gildedrose.Items.*;

class GildedRose {

    Item[] items;
    final String sulfras = "Sulfuras, Hand of Ragnaros";
    final String conjured = "Conjured Mana Cake";
    final String agedBrie = "Aged Brie";
    final String backstagePasses = "Backstage passes to a TAFKAL80ETC concert";


    public GildedRose(Item[] items) {
        this.items = items;
    }


    public void updateQuality() {

        for (Item item : items) {
//checkMinAndMaxQuality(item);
            switch (item.name) {
                case sulfras:
                    new Sulfuras().updateState();
                    break;

                case conjured:
                    new Conjured(item).updateState();
                    break;
                case agedBrie:
                    new Brie(item).updateState();
                    break;

                case backstagePasses:
                    new BackstagePasses(item).updateState();
                    break;
                default:
                    new BasicItem(item).updateState();
                    break;
            }

        }
    }
}


