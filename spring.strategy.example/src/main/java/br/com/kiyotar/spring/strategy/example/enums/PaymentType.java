package br.com.kiyotar.spring.strategy.example.enums;

import br.com.kiyotar.spring.strategy.example.handler.BadRequestException;
import lombok.Getter;

import java.util.Arrays;

import static java.lang.String.format;

@Getter
public enum PaymentType {

    PAY_PAL("PAY_PAL"),
    PIC_PAY("PIC_PAY"),
    CREDIT_CARD("CREDIT_CARD"),
    DEBIT_CARD("DEBIT_CARD");

    private String paymentType;

    PaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public static PaymentType switchPaymentType(String paymentType) {
        return Arrays.stream(PaymentType.values())
                .filter(payment -> payment.getPaymentType().equals(paymentType))
                .findAny().orElseThrow(() -> {
                    String message = "PaymentType not supported, paymentType sent: %s";
                    throw new BadRequestException(format(message, paymentType));
                });
    }
}
