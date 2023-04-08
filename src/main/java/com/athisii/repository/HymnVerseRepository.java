package com.athisii.repository;

import com.athisii.entity.HymnVerse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author athisii
 * @version 1.0
 * @since 05/02/23
 */
@Repository
public interface HymnVerseRepository extends JpaRepository<HymnVerse, Integer> {
}
