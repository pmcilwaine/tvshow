package com.paulmcilwaine.search;

import com.paulmcilwaine.model.SeasonInterface;

import java.util.List;

public interface SeasonSearchInterface {
    List<SeasonInterface> findById(String id);
}
