package ru.rvkovtunov.payments.income.service.domain.core.shared.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum NotificationStatus {
    DRAFT("01", "Черновик"),
    AGREED("02", "Согласовано"),
    APPROVED("03", "Утверждено"),
    EMPTY("-1", "Неизвестно");

    private final String code;
    private final String nameFull;

    public static Optional<NotificationStatus> getStatusByName(String value) {
        return Arrays.stream(NotificationStatus.values()).filter(status -> status.name().equals(value)).findFirst();
    }
}
