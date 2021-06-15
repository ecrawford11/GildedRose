package com.gildedrose.Items;

import com.gildedrose.InvalidQualityException;

public interface CustomizedItem {

    void updateState() throws InvalidQualityException;

    void checkMinAndMaxQuality() throws InvalidQualityException;
}
