package br.com.kiyotar.spring.strategy.example.service;

import br.com.kiyotar.spring.strategy.example.dto.PaymentRequest;
import br.com.kiyotar.spring.strategy.example.dto.PaymentResponse;
import br.com.kiyotar.spring.strategy.example.enums.PaymentType;
import org.springframework.plugin.core.Plugin;

public interface PaymentService extends Plugin<PaymentType> {

    PaymentResponse executePayment(PaymentRequest paymentRequest);
}
