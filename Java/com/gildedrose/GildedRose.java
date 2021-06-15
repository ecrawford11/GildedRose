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


    public void updateQuality() throws InvalidQualityException {

        for (Item item : items) {

            switch (item.name) {
                case sulfras:
                    Sulfuras sulfuras = new Sulfuras(item);

                    sulfuras.checkMinAndMaxQuality();
                    sulfuras.updateState();

                    break;

                case conjured:
                    Conjured conjured = new Conjured(item);

                    conjured.checkMinAndMaxQuality();

                    conjured.updateState();
                    break;

                case agedBrie:
                    Brie agedBrie = new Brie(item);

                    agedBrie.checkMinAndMaxQuality();

                    agedBrie.updateState();
                    break;

                case backstagePasses:
                    BackstagePasses backstagePasses = new BackstagePasses(item);

                    backstagePasses.checkMinAndMaxQuality();

                    backstagePasses.updateState();
                    break;

                default:
                    BasicItem basicItem = new BasicItem(item);

                    basicItem.checkMinAndMaxQuality();

                    basicItem.updateState();
                    break;
            }

        }
    }

}


