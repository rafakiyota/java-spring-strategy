package br.com.kiyotar.spring.strategy.example.service.impl;

import br.com.kiyotar.spring.strategy.example.dto.PaymentRequest;
import br.com.kiyotar.spring.strategy.example.dto.PaymentResponse;
import br.com.kiyotar.spring.strategy.example.enums.PaymentType;
import br.com.kiyotar.spring.strategy.example.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentFakePicPayServiceImpl implements PaymentService {

    @Override
    public PaymentResponse executePayment(PaymentRequest paymentRequest) {
        return PaymentResponse.builder()
                .message("Payment via PicPac successfully executed.")
                .paymentType(PaymentType.PIC_PAY.getPaymentType()).build();
    }

    @Override
    public boolean supports(PaymentType paymentType) {
        return PaymentType.PIC_PAY == paymentType;
    }
}
