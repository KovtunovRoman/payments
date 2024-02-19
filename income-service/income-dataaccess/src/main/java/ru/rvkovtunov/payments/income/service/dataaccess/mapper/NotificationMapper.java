package ru.rvkovtunov.payments.income.service.dataaccess.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.rvkovtunov.payments.income.service.dataaccess.entity.NotificationEntity;
import ru.rvkovtunov.payments.income.service.domain.core.entity.Notification;
import ru.rvkovtunov.payments.income.service.domain.core.objectsId.NotificationId;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    @Mapping(source = "entity.id", target = "id", qualifiedByName = "id")
    Notification toDomain(NotificationEntity entity);

    @Mapping(source = "id", target = "id", qualifiedByName = "id")
    NotificationEntity toEntity(Notification domain);

    @Named("id")
    default UUID getId(NotificationId id) {
        return id.getValue();
    }

    @Named("id")
    default NotificationId getId(UUID id) {
        return NotificationId.of(id);
    }
}
