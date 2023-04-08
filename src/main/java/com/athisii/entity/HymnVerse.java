package com.athisii.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * @author athisii
 * @version 1.0
 * @since 05/02/23
 */
@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString(exclude = {"id", "hymn"})
public class HymnVerse {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(nullable = false)
    @JsonProperty("vn")
    byte verseNumber;
    @Column(nullable = false)
    @JsonProperty("ic")
    boolean isChorus;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "hymnVerse", orphanRemoval = true)
    @JsonProperty("hVLs")
    List<HymnVerseLine> hymnVerseLines;

    @JsonBackReference
    @ManyToOne
    Hymn hymn;
}
