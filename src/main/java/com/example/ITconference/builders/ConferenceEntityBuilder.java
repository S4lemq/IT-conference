package com.example.ITconference.builders;

import com.example.ITconference.enums.conferences.ConferenceName;
import com.example.ITconference.enums.conferences.ConferenceTopic;
import com.example.ITconference.repositories.entities.ConferenceEntity;
import com.example.ITconference.repositories.entities.UserEntity;

import java.time.Instant;
import java.util.UUID;

public class ConferenceEntityBuilder {
    private UUID id;
    private Instant dateBegin;
    private Instant dateFinish;
    private ConferenceName name;
    private ConferenceTopic topic;
    private UserEntity user;

    public ConferenceEntityBuilder withId(UUID id){
        this.id = id;
        return this;
    }

    public ConferenceEntityBuilder withDateBegin(Instant dateBegin){
        this.dateBegin = dateBegin;
        return this;
    }

    public ConferenceEntityBuilder withDateFinish(Instant dateFinish){
        this.dateFinish = dateFinish;
        return this;
    }

    public ConferenceEntityBuilder withName(ConferenceName name){
        this.name = name;
        return this;
    }

    public ConferenceEntityBuilder withTopic(ConferenceTopic topic){
        this.topic = topic;
        return this;
    }

    public ConferenceEntityBuilder withUser(UserEntity user){
        this.user = user;
        return this;
    }

    public ConferenceEntity build(){
        var entity = new ConferenceEntity();
        entity.setId(this.id);
        entity.setDateBegin(this.dateBegin);
        entity.setDateFinish(this.dateFinish);
        entity.setName(this.name);
        entity.setTopic(this.topic);
        entity.setUserEntity(this.user);
        return entity;
    }
}
