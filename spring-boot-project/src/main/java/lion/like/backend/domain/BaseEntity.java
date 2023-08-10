package lion.like.backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
//생성시간, 업데이트 시간
@EntityListeners(AuditingEntityListener.class)

@Getter
    @MappedSuperclass
    public class BaseEntity {

        @CreatedDate
        @Column(updatable = false)
        private LocalDateTime createdAt;

        @LastModifiedDate
        private LocalDateTime updatedAt;
    }

