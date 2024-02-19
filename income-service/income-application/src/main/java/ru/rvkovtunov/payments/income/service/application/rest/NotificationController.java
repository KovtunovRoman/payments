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

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody Notification notification){
        log.info("Начался процесс создания записи в таблице");
        final UUID notificationUUID = this.notificationService.create(notification);
        log.info("Запись создана, уникальный идентификатор обьекта: {}", notificationUUID);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }

    @GetMapping(path = "/read", params = {"uuid"})
    public ResponseEntity<Object> read(@RequestParam String id){
        log.info("Начался процесс получения записи из базы");
        final Notification notification = this.notificationService.read(id);
        log.info("Запись успешно получена, уникальный идентификатор: {}", id);
        return ResponseEntity.ok(notification);
    }

    @PutMapping(path = "/update", params = {"uuid"})
    public ResponseEntity<Object> update(@RequestParam String id, @RequestBody Notification notification){
        log.info("Начался процесс изменения записи в таблице");
        this.notificationService.update(id, notification);
        log.info("Изменение успешно завершено, идентификатор обьекта: {}", id);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }

    @DeleteMapping(path = "/delete", params = {"uuid"})
    public ResponseEntity<Object> delete(@RequestParam String id){
        log.info("Начался процесс удаления запись из таблицы");
        this.notificationService.delete(id);
        log.info("Запись успешно удалена, идентификатор удаленной записи: {}", id);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }
}
