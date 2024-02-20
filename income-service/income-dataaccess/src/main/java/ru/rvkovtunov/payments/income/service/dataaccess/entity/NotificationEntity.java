package ru.rvkovtunov.payments.income.service.dataaccess.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.rvkovtunov.payments.income.service.domain.core.shared.converter.NotificationStatusAttributeConverter;
import ru.rvkovtunov.payments.income.service.domain.core.shared.enums.NotificationStatus;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notification")
public class NotificationEntity {

    @Id
    @GeneratedValue
    private UUID id;
    private String notificationNumber;
    @Convert(converter = NotificationStatusAttributeConverter.class)
    private NotificationStatus status;
    private LocalDate modifyDate;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final NotificationEntity that = (NotificationEntity) o;
        return this.id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

}
