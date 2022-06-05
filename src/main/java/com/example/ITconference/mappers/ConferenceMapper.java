package com.example.ITconference.mappers;

import com.example.ITconference.builders.ConferenceDtoBuilder;
import com.example.ITconference.builders.ConferenceEntityBuilder;
import com.example.ITconference.repositories.entities.ConferenceEntity;
import com.example.ITconference.repositories.entities.UserEntity;
import com.example.ITconference.services.dtos.ConferenceDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ConferenceMapper {

    public ConferenceEntity fromDtoToEntity(ConferenceDto dto, UserEntity user){
        if(Objects.isNull(dto)){
            return null;
        }

        var entityBuilder = new ConferenceEntityBuilder();

        if(Objects.nonNull(dto.getId())){
            entityBuilder.withId(dto.getId());
        }

        if(Objects.nonNull(dto.getDateBegin())){
            entityBuilder.withDateBegin(dto.getDateBegin());
        }

        if(Objects.nonNull(dto.getDateFinish())){
            entityBuilder.withDateFinish(dto.getDateFinish());
        }

        if(Objects.nonNull(dto.getName())){
            entityBuilder.withName(dto.getName());
        }

        if(Objects.nonNull(dto.getTopic())){
            entityBuilder.withTopic(dto.getTopic());
        }

        if(Objects.nonNull(user)){
            entityBuilder.withUser(user);
        }

        return entityBuilder.build();
    }

    public ConferenceDto fromEntityToDto(ConferenceEntity entity){
        if(Objects.isNull(entity)){
            return null;
        }

        var dtoBuilder = new ConferenceDtoBuilder();

        if(Objects.nonNull(entity.getId())){
            dtoBuilder.withId(entity.getId());
        }

        if(Objects.nonNull(entity.getDateBegin())){
            dtoBuilder.withDateBegin(entity.getDateBegin());
        }

        if(Objects.nonNull(entity.getDateFinish())){
            dtoBuilder.withDateFinish(entity.getDateFinish());
        }

        if(Objects.nonNull(entity.getName())){
            dtoBuilder.withName(entity.getName());
        }

        if(Objects.nonNull(entity.getTopic())){
            dtoBuilder.withTopic(entity.getTopic());
        }

        return dtoBuilder.build();
    }

}
