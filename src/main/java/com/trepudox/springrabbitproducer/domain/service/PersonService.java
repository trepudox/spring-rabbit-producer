package com.trepudox.springrabbitproducer.domain.service;

import com.trepudox.springrabbitproducer.application.queue.RabbitClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonService {

    private final RabbitClient rabbitClient;

}
