package com.trepudox.springrabbitproducer.application.controller;

import com.trepudox.springrabbitproducer.application.mapper.PersonMapper;
import com.trepudox.springrabbitproducer.application.queue.RabbitClient;
import com.trepudox.springrabbitproducer.domain.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {

    private final RabbitClient rabbitClient;

    @PostMapping
    public ResponseEntity<?> postMessage(@RequestBody Person person) {
        String personJson = PersonMapper.INSTANCE.personToJson(person);
        rabbitClient.sendMessage(personJson);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
