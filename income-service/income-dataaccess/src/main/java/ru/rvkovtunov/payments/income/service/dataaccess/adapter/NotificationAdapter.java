package ru.rvkovtunov.payments.income.service.dataaccess.adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.rvkovtunov.payments.income.service.application.services.repository.NotificationRepository;
import ru.rvkovtunov.payments.income.service.dataaccess.mapper.NotificationMapper;
import ru.rvkovtunov.payments.income.service.dataaccess.repository.NotificationJpaRepository;
import ru.rvkovtunov.payments.income.service.domain.core.entity.Notification;
import ru.rvkovtunov.payments.income.service.domain.core.objectsId.NotificationId;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class NotificationAdapter implements NotificationRepository {

    /**
     *  Класс адаптер занимается преобразованием ДТО в сущность и наоборот
     *  и дальнейшим взаимодействием с репозиторием.
     *  Также следит, чтобы транзакция прошла успешно.
     * */

    private final NotificationJpaRepository repository;
    private final NotificationMapper mapper;

    @Override
    @Transactional
    public void createNotification(Notification notification) {
        this.repository.save(this.mapper.toEntity(notification));
    }

    @Override
    @Transactional
    public void createNotifications(List<Notification> notifications) {
        this.repository.saveAll(notifications.stream()
                .map(this.mapper::toEntity).toList());
    }

    @Override
    public Optional<Notification> getNotificationById(NotificationId notificationId) {
        return this.repository.findById(notificationId.getValue())
                .map(mapper::toDomain);
    }

    @Override
    public List<Notification> getNotificationsByIds(List<NotificationId> notificationIds) {
        List<UUID> notificationUUIDs = notificationIds.stream().map(NotificationId::getValue).toList();
        return this.repository.findAllById(notificationUUIDs)
                .stream()
                .map(this.mapper::toDomain)
                .toList();
    }

    @Override
    @Transactional
    public void updateNotification(Notification notification) {
        this.repository.save(this.mapper.toEntity(notification));
    }

    @Override
    @Transactional
    public void updateNotifications(List<Notification> notifications) {
        this.repository.saveAll(notifications.stream().map(this.mapper::toEntity).toList());
    }

    @Override
    @Transactional
    public void deleteNotificationById(NotificationId notificationId) {
        this.repository.deleteById(notificationId.getValue());
    }

    @Override
    @Transactional
    public void deleteNotificationsByIds(List<NotificationId> notificationIds) {
        this.repository.deleteAllByIdInBatch(notificationIds.stream().map(NotificationId::getValue).toList());
    }
}
