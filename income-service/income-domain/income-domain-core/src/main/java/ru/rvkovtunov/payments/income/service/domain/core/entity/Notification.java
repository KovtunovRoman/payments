package ru.rvkovtunov.payments.income.service.domain.core.entity;

import lombok.Getter;
import lombok.Setter;
import ru.rvkovtunov.payments.AggregateRoot;
import ru.rvkovtunov.payments.income.service.domain.core.objectsId.NotificationId;
import ru.rvkovtunov.payments.income.service.domain.core.shared.enums.NotificationStatus;

import java.time.LocalDate;

@Getter
@Setter
public class Notification extends AggregateRoot<NotificationId> {

    private String notificationNumber;
    private NotificationStatus status;
    private LocalDate createDate;
}
