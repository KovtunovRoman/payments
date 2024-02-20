package ru.rvkovtunov.payments.income.service.application.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rvkovtunov.payments.income.service.application.services.api.NotificationService;
import ru.rvkovtunov.payments.income.service.domain.core.entity.Notification;
import ru.rvkovtunov.payments.income.service.domain.core.objectsId.NotificationId;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/income/notification")
public class NotificationController {

    /**
     * Класс контроллер с реализацией CRUD операций над объектами.
     * Param ( notification ) -> Объект, который нам будет приходить с клиента;
     * Param ( id ) -> UUID объекта, над которым хотим провести манипуляции;
     * Return ( ResponseEntity ) -> в случае с get -> объект, в случае с остальными -> ok.
     * */

    private final NotificationService notificationService;

    @PostMapping("/create")
    public ResponseEntity<Object> createNotification(@RequestBody Notification notification) {
        log.info("Начался процесс создания записи в таблице");
        final UUID notificationUUID = this.notificationService.create(notification);
        log.info("Запись создана, уникальный идентификатор объекта: {}", notificationUUID);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }

    @PostMapping("/createAll")
    public ResponseEntity<Object> createAllNotifications(@RequestBody List<Notification> notifications) {
        log.info("Начался процесс создания записей в таблице");
        final List<UUID> notificationUUIDs = this.notificationService.createAll(notifications);
        log.info("Записи создана, уникальные идентификаторы объектов: {}", notificationUUIDs);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }

    @GetMapping(path = "/read", params = {"id"})
    public ResponseEntity<Object> readNotification(@RequestParam String id) {
        log.info("Начался процесс получения записи из базы");
        final Notification notification = this.notificationService.read(id);
        log.info("Запись успешно получена, уникальный идентификатор: {}", notification.getId().getValue());
        return ResponseEntity.ok(notification);
    }

    @GetMapping(path = "/readAll", params = {"ids"})
    public ResponseEntity<Object> readAllNotifications(@RequestParam List<String> ids) {
        log.info("Начался процесс получения записей из базы");
        final List<Notification> notifications = this.notificationService.readAll(ids);
        final List<UUID> notificationIds = notifications.stream().map(Notification::getId).map(NotificationId::getValue).toList();
        log.info("Записи успешно получены, уникальные идентификаторы: {}", notificationIds);
        return ResponseEntity.ok(notifications);
    }

    @PutMapping(path = "/update", params = {"id"})
    public ResponseEntity<Object> updateNotification(@RequestParam String id, @RequestBody Notification notification) {
        log.info("Начался процесс изменения записи в таблице");
        final UUID notificationIds = this.notificationService.update(id, notification);
        log.info("Изменение успешно завершено, идентификатор объекта: {}", notificationIds);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }

    @PutMapping(path = "/updateAll", params = {"ids"})
    public ResponseEntity<Object> updateAllNotifications(@RequestParam List<String> ids, @RequestBody List<Notification> notifications) {
        log.info("Начался процесс изменения записей в таблице");
        final List<UUID> notificationsIds = this.notificationService.updateAll(ids, notifications);
        log.info("Изменения успешно завершены, идентификаторы объектов: {}", notificationsIds);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }

    @DeleteMapping(path = "/delete", params = {"id"})
    public ResponseEntity<Object> deleteNotification(@RequestParam String id) {
        log.info("Начался процесс удаления записи из таблицы");
        final UUID notificationId = this.notificationService.delete(id);
        log.info("Запись успешно удалена, идентификатор удаленной записи: {}", notificationId);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }

    @DeleteMapping(path = "/deleteAll", params = {"ids"})
    public ResponseEntity<Object> deleteAllNotifications(@RequestParam List<String> ids) {
        log.info("Начался процесс удаления записей из таблицы");
        final List<UUID> notificationIds = this.notificationService.deleteAll(ids);
        log.info("Записи успешно удалены, идентификаторы удаленных записей: {}", notificationIds);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }
}
