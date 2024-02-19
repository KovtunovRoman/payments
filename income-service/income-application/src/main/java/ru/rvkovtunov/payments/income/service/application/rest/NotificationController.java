package ru.rvkovtunov.payments.income.service.application.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/income/notification")
public class NotificationController {

    @PutMapping("/create")
    public ResponseEntity<Object> create(){
        return null;
    }

    @GetMapping("/read")
    public ResponseEntity<Object> read(){
        return null;
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(){
        return null;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Object> delete(){
        return null;
    }
}
