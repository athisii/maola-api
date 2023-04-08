package com.athisii;

import com.athisii.entity.Hymn;
import com.athisii.entity.HymnVerse;
import com.athisii.entity.HymnVerseLine;
import com.athisii.repository.HymnRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author athisii
 * @version 1.0
 * @since 05/02/23
 */

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bootstrap implements ApplicationRunner {
    static final Random random = new Random();
    @Autowired
    HymnRepository hymnRepository;

    @Override
    public void run(ApplicationArguments args) {
//        int[] nums = {6,7};
//        hymnRepository.saveAll(IntStream.rangeClosed(1, 500)
//                .mapToObj(songNumber -> {
//                    Hymn song = new Hymn();
//                    song.setHymnNumber((short) songNumber);
//                    song.setMaolaTitle("Mao Title " + songNumber);
//                    song.setEnglishTitle("English Title " + songNumber);
//                    song.setHymnVerses(generateHymnVerses(song, nums[random.nextInt(0, 2)], nums[random.nextInt(0, 2)]));
//                    return song;
//                })
//                .toList());
    }

    private List<HymnVerse> generateHymnVerses(Hymn hymn, int maxSection, int maxLine) {
        return IntStream.rangeClosed(0, maxSection)
                .mapToObj(verseNum -> {
                    HymnVerse hymnVerse = new HymnVerse();
                    hymnVerse.setHymn(hymn);
                    if (verseNum == 0) {
                        hymnVerse.setVerseNumber((byte) 0);
                        hymnVerse.setChorus(true);
                    } else {
                        hymnVerse.setVerseNumber((byte) verseNum);
                    }
                    hymnVerse.setHymnVerseLines(generateHymnVerseLine(hymnVerse, maxLine));
                    return hymnVerse;

                }).toList();

    }

    private List<HymnVerseLine> generateHymnVerseLine(HymnVerse hymnVerse, int maxLine) {
        return IntStream.rangeClosed(1, maxLine)
                .mapToObj(serialNo -> {
                    HymnVerseLine hymnVerseLine = new HymnVerseLine();
                    hymnVerseLine.setHymnVerse(hymnVerse);
                    hymnVerseLine.setSerialNumber((byte) serialNo);
                    hymnVerseLine.setMaola("Maola section " + hymnVerse.getVerseNumber() + " line number " + serialNo);
                    hymnVerseLine.setEnglish("English section " + hymnVerse.getVerseNumber() + " line number " + serialNo);
                    return hymnVerseLine;

                }).toList();
    }
}
