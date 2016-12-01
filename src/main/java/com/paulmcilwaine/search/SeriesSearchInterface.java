package com.paulmcilwaine.search;

import com.paulmcilwaine.model.SeriesInterface;

public interface SeriesSearchInterface {
    SeriesInterface findByName(String name);
}
