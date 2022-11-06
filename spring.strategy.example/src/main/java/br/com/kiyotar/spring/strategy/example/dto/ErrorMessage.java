package br.com.kiyotar.spring.strategy.example.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorMessage {

    private Integer status_code;
    private String status_name;
    private String message;
    private String datetime;
}
