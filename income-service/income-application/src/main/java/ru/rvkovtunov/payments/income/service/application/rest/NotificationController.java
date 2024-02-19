package ru.rvkovtunov.payments.income.service.application.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rvkovtunov.payments.income.service.application.services.api.NotificationService;
import ru.rvkovtunov.payments.income.service.domain.core.entity.Notification;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/income/notification")
public class NotificationController {

    private final NotificationService notificationService;

    @PutMapping("/create")
    public ResponseEntity<Object> create(){
        log.info("Начался процесс создания записи в таблице");
        final UUID notificationUUID = this.notificationService.create();
        log.info("Запись создана, уникальный идентификатор обьекта: {}", notificationUUID);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }

    @GetMapping(path = "/read", params = {"uuid"})
    public ResponseEntity<Object> read(@RequestParam String uuid){
        final Notification notification = this.notificationService.read(uuid);
        return ResponseEntity.ok(notification);
    }

    @PostMapping(path = "/update", params = {"uuid"})
    public ResponseEntity<Object> update(@RequestParam String uuid, @RequestBody Notification notification){
        log.info("Начался процесс изменения записи в таблице");
        this.notificationService.update(uuid, notification);
        log.info("Изменение успешно завершено, идентификатор обьекта: {}", uuid);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }

    @DeleteMapping(path = "/delete", params = {"uuid"})
    public ResponseEntity<Object> delete(@RequestParam String uuid){
        log.info("Начался процесс удаления запись из таблицы");
        this.notificationService.delete(uuid);
        log.info("Запись успешно удалена, идентификатор удаленной записи: {}", uuid);
        return null;
    }
}
