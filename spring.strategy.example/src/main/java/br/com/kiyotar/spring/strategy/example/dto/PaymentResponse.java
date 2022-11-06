package br.com.kiyotar.spring.strategy.example.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PaymentResponse {

    private String message;
    private String paymentType;
}
