package com.gildedrose;

import static org.junit.Assert.*;

import com.gildedrose.Items.Item;
import org.junit.Test;

public class GildedRoseTest {

    //Why did this expect "fix_me"?
    @Test
    public void foo() throws InvalidQualityException {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void systemLowersSellInAndQualityValueDaily() throws InvalidQualityException {
        Item[] items = new Item[]{new Item("foo", 1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void qualityDegradestwiceAsFastAfterSellByDate() throws InvalidQualityException {
        Item[] items = new Item[]{new Item("foo", 1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        assertEquals(7, app.items[0].quality);
    }


    @Test
    public void qualityIsNeverNegative() throws InvalidQualityException {
        Item[] items = new Item[]{new Item("foo", 20, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void exceptionThrownWhenQualityIsNegative() {
        boolean thrown = false;
        Item[] items = new Item[]{new Item("foo", 20, -1)};
        GildedRose app = new GildedRose(items);
        try {
            app.updateQuality();
        } catch (InvalidQualityException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }


    @Test
    public void agedBrieQualityIncreasesAsSellInDateDecreases() throws InvalidQualityException {
        Item[] items = new Item[]{new Item("Aged Brie", 15, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
        assertEquals(14, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
        assertEquals(13, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(13, app.items[0].quality);
        assertEquals(12, app.items[0].sellIn);
    }

    @Test
    public void agedBrieQualityIncreasesTwiceAsFastAsSellInDateDecreasesPastZero() throws InvalidQualityException {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(14, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);

    }


    @Test
    public void itemQualityStartsAbove50() {
        Item[] items = new Item[]{new Item("Foo", 15, 60)};
        GildedRose app = new GildedRose(items);
        boolean thrown = false;
        try {
            app.updateQuality();
        } catch (InvalidQualityException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void itemQualityDoesNotIncreaseAbove50() throws InvalidQualityException {
        Item[] items = new Item[]{new Item("Aged Brie", 15, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(14, app.items[0].sellIn);
    }

    @Test
    public void sulfurasSellInAndQualityDoesNotChange() throws InvalidQualityException {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 15, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(15, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
        assertEquals(15, app.items[0].sellIn);
    }

    @Test
    public void itemQualityDoesNotStartAbove50() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 15, 45)};
        GildedRose app = new GildedRose(items);
        Boolean thrown = false;
        try {
            app.updateQuality();
        } catch (InvalidQualityException e) {
            thrown = true;
        }
        assertTrue(thrown);

    }

    @Test
    public void backstagePassesQualityIncreaseBy2WhenSellInIsBetween10to6() throws InvalidQualityException {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(14, app.items[0].quality);
        assertEquals(8, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(16, app.items[0].quality);
        assertEquals(7, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(18, app.items[0].quality);
        assertEquals(6, app.items[0].sellIn);
    }


    @Test
    public void backstagePassesQualityIncreaseBy3WhenSellInIsBetween5to0() throws InvalidQualityException {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 18)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
        assertEquals(4, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(24, app.items[0].quality);
        assertEquals(3, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(27, app.items[0].quality);
        assertEquals(2, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(30, app.items[0].quality);
        assertEquals(1, app.items[0].sellIn);
    }


    @Test
    public void backstagePassesQualityDecreasesToZeroWhenSellInIs0orLess() throws InvalidQualityException {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-1, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(-2, app.items[0].sellIn);
    }


    @Test
    public void conjuredItemsDecreaseInQualityTwiceAsFast() throws InvalidQualityException {
        Item[] items = new Item[]{new Item("Conjured Mana Cake", 10, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(28, app.items[0].quality);
        assertEquals(9, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(26, app.items[0].quality);
        assertEquals(8, app.items[0].sellIn);
    }

}