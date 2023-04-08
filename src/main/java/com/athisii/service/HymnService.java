package com.athisii.service;

import com.athisii.entity.Hymn;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author athisii
 * @version 1.0
 * @since 05/02/23
 */

public interface HymnService {
    List<Hymn> getAllHymns();

    List<Hymn> getHymnsByPage(Pageable pageable);

    List<Hymn> getAllHymnsByPage();
}
