package ru.rvkovtunov.payments.income.service.application.services.repository;

import ru.rvkovtunov.payments.income.service.domain.core.entity.Notification;
import ru.rvkovtunov.payments.income.service.domain.core.objectsId.NotificationId;

import java.util.Optional;
import java.util.UUID;

public interface NotificationRepository {

    UUID createNotification(Notification notification);

    public Optional<Notification> getNotificationById(NotificationId notificationId);

    void updateNotification(Notification notification);

    void deleteNotificationById(NotificationId notificationId);
}
