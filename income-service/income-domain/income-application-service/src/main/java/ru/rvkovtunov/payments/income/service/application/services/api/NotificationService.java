package ru.rvkovtunov.payments.income.service.application.services.api;

import ru.rvkovtunov.payments.income.service.domain.core.entity.Notification;

import java.util.UUID;

public interface NotificationService {

    UUID create(Notification notification);

    Notification read(String id);

    UUID update(String id, Notification notification);

    UUID delete(String id);

}
