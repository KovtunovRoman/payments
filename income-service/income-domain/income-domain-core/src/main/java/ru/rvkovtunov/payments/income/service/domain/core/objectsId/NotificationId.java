package ru.rvkovtunov.payments.income.service.domain.core.objectsId;

import ru.rvkovtunov.payments.BaseId;

import java.util.UUID;

public class NotificationId extends BaseId<UUID> {
    protected NotificationId(final UUID value) {
        super(value);
    }

    public static NotificationId newInstance() {
        return new NotificationId(UUID.randomUUID());
    }

    public static NotificationId of(final UUID value) {
        return new NotificationId(value);
    }

}
