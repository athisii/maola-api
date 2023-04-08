package com.athisii.repository;

import com.athisii.entity.HymnVerseLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author athisii
 * @version 1.0
 * @since 05/02/23
 */
@Repository
public interface HymnVerseLineRepository extends JpaRepository<HymnVerseLine, Integer> {
}
