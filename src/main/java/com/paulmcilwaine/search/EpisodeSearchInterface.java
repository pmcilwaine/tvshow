package com.paulmcilwaine.search;

import com.paulmcilwaine.model.EpisodeInterface;

import java.util.List;

public interface EpisodeSearchInterface {
    List<EpisodeInterface> findById(String id);
}
