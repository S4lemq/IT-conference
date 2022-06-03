package com.example.ITconference.repositories.entities;

import com.example.ITconference.enums.conferences.ConferenceName;
import com.example.ITconference.enums.conferences.ConferenceTopic;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "conferences")
public class ConferenceEntity {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Enumerated(EnumType.STRING)
    private ConferenceName name;

    private Instant dateBegin;

    private Instant dateFinish;

    @Enumerated(EnumType.STRING)
    private ConferenceTopic topic;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity userEntity;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ConferenceName getName() {
        return name;
    }

    public void setName(ConferenceName name) {
        this.name = name;
    }

    public Instant getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Instant dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Instant getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Instant dateFinish) {
        this.dateFinish = dateFinish;
    }

    public ConferenceTopic getTopic() {
        return topic;
    }

    public void setTopic(ConferenceTopic topic) {
        this.topic = topic;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConferenceEntity that = (ConferenceEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(userEntity, that.userEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userEntity);
    }

    @Override
    public String toString() {
        return "ConferenceEntity{" +
                "id=" + id +
                ", name=" + name +
                ", dateBegin=" + dateBegin +
                ", dateFinish=" + dateFinish +
                ", topic=" + topic +
                ", userEntity=" + userEntity +
                '}';
    }
}
