package ru.rvkovtunov.payments.income.service.application.services.api;

import ru.rvkovtunov.payments.income.service.domain.core.entity.Notification;

import java.util.List;
import java.util.UUID;

public interface NotificationService {

    UUID create(Notification notification);

    List<UUID> createAll(List<Notification> notifications);

    Notification read(String id);

    List<Notification> readAll(List<String> ids);

    UUID update(String id, Notification notification);

    List<UUID> updateAll(List<String> ids, List<Notification> notifications);

    UUID delete(String id);

    List<UUID> deleteAll(List<String> ids);

}
