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


/**
 * @author athisii
 * @version 1.0
 * @since 05/02/23
 */
@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString(exclude = {"id", "hymnVerse"})
public class HymnVerseLine {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @JsonProperty("sn")
    byte serialNumber;
    @Column(nullable = false, length = 100)
    @JsonProperty("m")
    String maola;
    @Column(length = 100)
    @JsonProperty("e")
    String english;

    @JsonBackReference
    @ManyToOne
    HymnVerse hymnVerse;
}
