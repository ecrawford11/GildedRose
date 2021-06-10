package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    //Why does this expect "fix_me"?
    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }
@Test
    public void systemLowersSellInAndQualityValueDaily(){
        Item[] items = new Item[] { new Item("foo", 1, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0,app.items[0].sellIn);
        assertEquals(0,app.items[0].quality);
    }
    //decreases (days after sellIn #,quality) [(1,10), (2,7),(3,5)(4,3)(5,1)]
    @Test
    public void qualityDegradestwiceAsFastAfterSellByDate(){
        Item[] items = new Item[] { new Item("foo", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        assertEquals(7,app.items[0].quality);
    }


    @Test
    public void qualityIsNeverNegative(){
        Item[] items = new Item[] { new Item("foo", 20, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        assertEquals(0,app.items[0].quality);
    }

//    //    Need to add to code & test - quality is never negative - what if start with a neg quality? - should get exception
//    @Test
//    public void exceptionThrownWhenQualityIsNegative(){
//        Item[] items = new Item[] { new Item("foo", 20, -1) };
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
////add assertion that exception was thrown because quality is negative to begin with and is not Aged Brie
//    }


    @Test
    public void agedBrieQualityIncreasesAsSellInDateDecreases(){
        Item[] items = new Item[] { new Item("Aged Brie", 15, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11,app.items[0].quality);
        assertEquals(14, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(12,app.items[0].quality);
        assertEquals(13, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(13,app.items[0].quality);
        assertEquals(12, app.items[0].sellIn);
    }

// //    Need to add to code & test - quality is never over 50 - what if start with quality over 50? - should get exception
//    @Test
//    public void itemQualityDoesNotStartAbove50(){
//        Item[] items = new Item[] { new Item("Aged Brie", 15, 60) };
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//        //add assertion that exception was thrown because starting quality was above 50
//    }
//}

@Test
public void itemQualityDoesNotIncreaseAbove50(){
    Item[] items = new Item[] { new Item("Aged Brie", 15, 50) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(50,app.items[0].quality);
    assertEquals(14, app.items[0].sellIn);
    }

    @Test
    public void sulfurasSellInAndQualityDoesNotChange(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 15, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80,app.items[0].quality);
        assertEquals(15, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(80,app.items[0].quality);
        assertEquals(15, app.items[0].sellIn);
    }
    //    Need to add to code & test - Sulfuras quality is always 80 - what if start with quality not at 80? - should get exception
//    @Test
//    public void itemQualityDoesNotStartAbove50(){
//      Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 15, 45) };
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//        //add assertion that exception was thrown because starting quality was not 80
//    }
//}


    //need to fix code so only looks for string "Backstage passes" rather than "Backstage passes to a TAFKAL80ETC concert"
    @Test
    public void backstagePassesQualityIncreaseBy2WhenSellInIsBetween10to6(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12,app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(14,app.items[0].quality);
        assertEquals(8, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(16,app.items[0].quality);
        assertEquals(7, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(18,app.items[0].quality);
        assertEquals(6, app.items[0].sellIn);
    }
    //need to fix code so only looks for string "Backstage passes" rather than "Backstage passes to a TAFKAL80ETC concert"
    @Test
    public void backstagePassesQualityIncreaseBy3WhenSellInIsBetween5to0(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 18) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21,app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(24,app.items[0].quality);
        assertEquals(3, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(27,app.items[0].quality);
        assertEquals(2, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(30,app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }

    //need to fix code so only looks for string "Backstage passes" rather than "Backstage passes to a TAFKAL80ETC concert"
    @Test
    public void backstagePassesQualityDecreasesToZeroWhenSellInIs0orLess(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0,app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(0,app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }

    //need to fix code so only looks for string "Conjured" rather than "Conjured Mana Cake"
//    @Test
//    public void conjuredItemsDecreaseInQualityTwiceAsFast(){
//        Item[] items = new Item[] { new Item("Conjured Mana Cake", 10, 30) };
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//        assertEquals(28,app.items[0].quality);
//        assertEquals(9, app.items[0].sellIn);
//        app.updateQuality();
//        assertEquals(26,app.items[0].quality);
//        assertEquals(8, app.items[0].sellIn);
//    }

    //Should test each switchcasethat items don't go above or below designated quality

}