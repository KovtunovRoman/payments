package ru.rvkovtunov.payments.income.service.application.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rvkovtunov.payments.income.service.application.services.api.NotificationService;
import ru.rvkovtunov.payments.income.service.application.services.repository.NotificationRepository;
import ru.rvkovtunov.payments.income.service.domain.core.entity.Notification;
import ru.rvkovtunov.payments.income.service.domain.core.objectsId.NotificationId;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository repository;

    @Override
    public UUID create(Notification notification) {
        notification.setId(NotificationId.newInstance());
        notification.setModifyDate(LocalDate.now());

        this.repository.createNotification(notification);

        return notification.getId().getValue();
    }

    @Override
    public List<UUID> createAll(List<Notification> notifications) {
        notifications.forEach(notification -> {
            notification.setId(NotificationId.newInstance());
            notification.setModifyDate(LocalDate.now());
        });

        this.repository.createNotifications(notifications);

        return notifications.stream().map(Notification::getId).map(NotificationId::getValue).toList();
    }

    @Override
    public Notification read(String id) {
        UUID notificationUUID = UUID.fromString(id);
        NotificationId notificationId = NotificationId.of(notificationUUID);

        return this.repository.getNotificationById(notificationId).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Notification> readAll(List<String> ids) {
        List<UUID> notificationUUIDs = ids.stream().map(UUID::fromString).toList();
        List<NotificationId> notificationIds = notificationUUIDs.stream().map(NotificationId::of).toList();

        return this.repository.getNotificationsByIds(notificationIds);
    }

    @Override
    public UUID update(String id, Notification notification) {
        UUID notificationUUID = UUID.fromString(id);
        NotificationId notificationId = NotificationId.of(notificationUUID);
        notification.setId(notificationId);

        this.repository.updateNotification(notification);

        return notificationUUID;
    }

    @Override
    public List<UUID> updateAll(List<String> ids, List<Notification> notifications) {
        List<UUID> notificationUUIDs = ids.stream().map(UUID::fromString).toList();
        List<NotificationId> notificationIds = notificationUUIDs.stream().map(NotificationId::of).toList();
        notifications.forEach(notification -> {
            notification.setId(NotificationId.newInstance());
            notification.setModifyDate(LocalDate.now());
        });

        this.repository.updateNotifications(notifications);

        return notificationIds.stream().map(NotificationId::getValue).toList();
    }

    @Override
    public UUID delete(String id) {
        UUID notificationUUID = UUID.fromString(id);
        NotificationId notificationId = NotificationId.of(notificationUUID);

        this.repository.deleteNotificationById(notificationId);
        return notificationId.getValue();
    }

    @Override
    public List<UUID> deleteAll(List<String> ids) {
        List<UUID> notificationUUIDs = ids.stream().map(UUID::fromString).toList();
        List<NotificationId> notificationIds = notificationUUIDs.stream().map(NotificationId::of).toList();

        this.repository.deleteNotificationsByIds(notificationIds);
        return notificationIds.stream().map(NotificationId::getValue).toList();
    }
}
