package ru.rvkovtunov.payments.income.service.dataaccess.adapter;

import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.rvkovtunov.payments.income.service.application.services.repository.NotificationRepository;
import ru.rvkovtunov.payments.income.service.dataaccess.mapper.NotificationMapper;
import ru.rvkovtunov.payments.income.service.dataaccess.repository.NotificationJpaRepository;
import ru.rvkovtunov.payments.income.service.domain.core.entity.Notification;
import ru.rvkovtunov.payments.income.service.domain.core.objectsId.NotificationId;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class NotificationAdapter implements NotificationRepository {

    private final NotificationJpaRepository repository;
    private final NotificationMapper mapper;

    @Override
    @Transactional
    public UUID createNotification(Notification notification) {
        this.repository.save(this.mapper.toEntity(notification));
        return notification.getId().getValue();
    }

    @Override
    public Optional<Notification> getNotificationById(NotificationId notificationId) {
        return this.repository.findById(notificationId.getValue()).map(mapper::toDomain);
    }

    @Override
    @Transactional
    public void updateNotification(Notification notification) {
        this.repository.save(this.mapper.toEntity(notification));
    }

    @Override
    @Transactional
    public void deleteNotificationById(NotificationId notificationId) {
        this.repository.deleteById(notificationId.getValue());
    }
}
