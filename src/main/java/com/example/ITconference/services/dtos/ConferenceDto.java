package com.example.ITconference.services.dtos;

import com.example.ITconference.enums.conferences.ConferenceName;
import com.example.ITconference.enums.conferences.ConferenceTopic;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public class ConferenceDto {
    private UUID id;
    private Instant dateBegin;
    private Instant dateFinish;
    private ConferenceName name;
    private ConferenceTopic topic;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public ConferenceName getName() {
        return name;
    }

    public void setName(ConferenceName name) {
        this.name = name;
    }

    public ConferenceTopic getTopic() {
        return topic;
    }

    public void setTopic(ConferenceTopic topic) {
        this.topic = topic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConferenceDto that = (ConferenceDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ConferenceDto{" +
                "id=" + id +
                ", dateBegin=" + dateBegin +
                ", dateFinish=" + dateFinish +
                ", name=" + name +
                ", topic=" + topic +
                '}';
    }
}
