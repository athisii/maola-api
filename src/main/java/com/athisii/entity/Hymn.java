package com.athisii.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
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
public class Hymn {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    //    @Column(nullable = false)
    //    boolean favorite
    //    @Column(nullable = false)
    //    boolean englishVersionAvailable
    @Column(unique = true, nullable = false)
    @JsonProperty("hn")
    short hymnNumber;
    @Column(unique = true, nullable = false, length = 100)
    @JsonProperty("mt")
    String maolaTitle;
    @Column(unique = true, length = 100)
    @JsonProperty("et")
    String englishTitle;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hymn", fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonProperty("hVs")
    List<HymnVerse> hymnVerses;
}
