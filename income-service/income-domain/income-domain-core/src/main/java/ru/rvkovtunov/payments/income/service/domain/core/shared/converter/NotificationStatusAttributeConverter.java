package ru.rvkovtunov.payments.income.service.domain.core.shared.converter;

import jakarta.persistence.AttributeConverter;
import ru.rvkovtunov.payments.income.service.domain.core.shared.enums.NotificationStatus;

public class NotificationStatusAttributeConverter implements AttributeConverter<NotificationStatus, String> {

    @Override
    public String convertToDatabaseColumn(NotificationStatus notificationClarificationStatus) {
        return notificationClarificationStatus != null ? notificationClarificationStatus.name() : null;
    }

    @Override
    public NotificationStatus convertToEntityAttribute(String s) {
        return s != null ? NotificationStatus.getStatusByName(s).orElse(null) : null;
    }
}
