package com.example.ITconference.builders;

import com.example.ITconference.enums.conferences.ConferenceName;
import com.example.ITconference.enums.conferences.ConferenceTopic;
import com.example.ITconference.services.dtos.ConferenceDto;

import java.time.Instant;
import java.util.UUID;

public class ConferenceDtoBuilder {
    private UUID id;
    private Instant dateBegin;
    private Instant dateFinish;
    private ConferenceName name;
    private ConferenceTopic topic;

    public ConferenceDtoBuilder withId(UUID id){
        this.id = id;
        return this;
    }

    public ConferenceDtoBuilder withDateBegin(Instant dateBegin){
        this.dateBegin = dateBegin;
        return this;
    }

    public ConferenceDtoBuilder withDateFinish(Instant dateFinish){
        this.dateFinish = dateFinish;
        return this;
    }

    public ConferenceDtoBuilder withName(ConferenceName name){
        this.name = name;
        return this;
    }

    public ConferenceDtoBuilder withTopic(ConferenceTopic topic){
        this.topic = topic;
        return this;
    }

    public ConferenceDto build(){
        var dto = new ConferenceDto();
        dto.setId(this.id);
        dto.setDateBegin(this.dateBegin);
        dto.setDateFinish(this.dateFinish);
        dto.setName(this.name);
        dto.setTopic(this.topic);
        return dto;
    }

}
