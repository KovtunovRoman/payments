package ru.rvkovtunov.payments.income.service.dataaccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.rvkovtunov.payments.income.service.dataaccess.entity.NotificationEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface NotificationJpaRepository extends JpaRepository<NotificationEntity, UUID> {

    @Query(value = """
            SELECT p
            FROM NotificationEntity p
            WHERE p.id = :id
            """)
    Optional<NotificationEntity> findById(@Param("id") UUID id);

}
