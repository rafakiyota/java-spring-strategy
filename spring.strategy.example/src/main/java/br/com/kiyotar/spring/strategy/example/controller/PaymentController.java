package br.com.kiyotar.spring.strategy.example.controller;

import br.com.kiyotar.spring.strategy.example.dto.PaymentRequest;
import br.com.kiyotar.spring.strategy.example.dto.PaymentResponse;
import br.com.kiyotar.spring.strategy.example.enums.PaymentType;
import br.com.kiyotar.spring.strategy.example.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PluginRegistry<PaymentService, PaymentType> plugin;

    @PostMapping
    public PaymentResponse executePayment(@RequestBody PaymentRequest paymentRequest) {
        PaymentType paymentType = PaymentType.switchPaymentType(paymentRequest.getPaymentType());
        return plugin.getRequiredPluginFor(paymentType).executePayment(paymentRequest);
    }
}
