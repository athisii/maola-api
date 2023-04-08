package com.athisii.dto;

/**
 * @author athisii
 * @version 1.0
 * @since 05/02/23
 */

public record ResponseDto<T>(boolean status, String message, T data) {
    public static <T> ResponseDto<T> onFail(String message) {
        return new ResponseDto<>(false, message, null);
    }

    public static <T> ResponseDto<T> onSuccess(String message, T data) {
        return new ResponseDto<>(true, message, data);
    }
}
