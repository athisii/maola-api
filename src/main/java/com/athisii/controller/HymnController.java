package com.athisii.controller;

import com.athisii.dto.ResponseDto;
import com.athisii.service.HymnService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * @author athisii
 * @version 1.0
 * @since 05/02/23
 */

@RestController
@RequestMapping("/api/v1/hymn")
@FieldDefaults(level = AccessLevel.PRIVATE)
@CrossOrigin(origins = "*")
public class HymnController {
    private static final String MESSAGE = "Songs fetched successfully.";
    @Autowired
    HymnService hymnService;

    @GetMapping
    public ResponseDto<Object> getHymnsByPage(Pageable pageable) {
        return ResponseDto.onSuccess(MESSAGE, hymnService.getHymnsByPage(pageable));
    }

    @GetMapping("/all")
    public ResponseDto<Object> getAllHymns() {
        return ResponseDto.onSuccess(MESSAGE, hymnService.getAllHymns());
    }

    @GetMapping("/all-page")
    public ResponseDto<Object> getAllHymnsByPage() {
        return ResponseDto.onSuccess(MESSAGE, hymnService.getAllHymnsByPage());
    }


}
