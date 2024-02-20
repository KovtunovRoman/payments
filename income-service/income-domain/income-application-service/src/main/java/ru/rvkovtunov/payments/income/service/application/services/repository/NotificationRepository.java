package ru.rvkovtunov.payments.income.service.application.services.repository;

import ru.rvkovtunov.payments.income.service.domain.core.entity.Notification;
import ru.rvkovtunov.payments.income.service.domain.core.objectsId.NotificationId;

import java.util.List;
import java.util.Optional;

public interface NotificationRepository {

    void createNotification(Notification notification);

    void createNotifications(List<Notification> notifications);

    Optional<Notification> getNotificationById(NotificationId notificationId);

    List<Notification> getNotificationsByIds(List<NotificationId> notificationIds);

    void updateNotification(Notification notification);

    void updateNotifications(List<Notification> notifications);

    void deleteNotificationById(NotificationId notificationId);

    void deleteNotificationsByIds(List<NotificationId> notificationIds);
}
