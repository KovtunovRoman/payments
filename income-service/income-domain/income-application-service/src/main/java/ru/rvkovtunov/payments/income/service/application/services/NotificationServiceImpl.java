package ru.rvkovtunov.payments.income.service.application.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rvkovtunov.payments.income.service.application.services.api.NotificationService;
import ru.rvkovtunov.payments.income.service.application.services.repository.NotificationRepository;
import ru.rvkovtunov.payments.income.service.domain.core.entity.Notification;
import ru.rvkovtunov.payments.income.service.domain.core.objectsId.NotificationId;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository repository;

    @Override
    public UUID create() {
        return this.repository.createNotification();
    }

    @Override
    public Notification read(String uuid) {
        UUID notificationUUID = UUID.fromString(uuid);
        NotificationId notificationId = NotificationId.of(notificationUUID);
        return this.repository.getNotificationById(notificationId).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public UUID update(String uuid, Notification notification) {
        UUID notificationUUID = UUID.fromString(uuid);
        NotificationId notificationId = NotificationId.of(notificationUUID);
        notification.setId(notificationId);
        this.repository.updateNotification(notification);
        return notificationUUID;
    }

    @Override
    public UUID delete(String uuid) {
        UUID notificationUUID = UUID.fromString(uuid);
        NotificationId notificationId = NotificationId.of(notificationUUID);
        this.repository.deleteNotificationById(notificationId);
        return notificationUUID;
    }
}