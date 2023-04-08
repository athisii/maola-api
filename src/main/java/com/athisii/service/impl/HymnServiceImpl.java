package com.athisii.service.impl;

import com.athisii.entity.Hymn;
import com.athisii.exception.GenericException;
import com.athisii.repository.HymnRepository;
import com.athisii.service.HymnService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @author athisii
 * @version 1.0
 * @since 05/02/23
 */
@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HymnServiceImpl implements HymnService {
    private static final int TOTAL_PAGE = 4;
    private static final int PAGE_SIZE = 250;
    @Autowired
    HymnRepository hymnRepository;

    @Override
    public List<Hymn> getAllHymns() {
        return hymnRepository.findAll();
    }

    @Override
    public List<Hymn> getHymnsByPage(Pageable pageable) {
        return hymnRepository.findAll(pageable).getContent();
    }


    @Override
    public List<Hymn> getAllHymnsByPage() {
        List<Hymn> hymns = new ArrayList<>();
        List<ForkJoinTask<Boolean>> tasks = new ArrayList<>();
        for (int i = 0; i < TOTAL_PAGE; i++) {
            tasks.add(fetchSongsFromDb(i, hymns));
        }
        for (var task : tasks) {
            task.join();
        }
        return hymns;
    }

    private ForkJoinTask<Boolean> fetchSongsFromDb(int page, List<Hymn> hymns) {
        return ForkJoinPool.commonPool().submit(() -> hymns.addAll(hymnRepository.findAll(PageRequest.of(page, HymnServiceImpl.PAGE_SIZE)).getContent()));

    }
}
