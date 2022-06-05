package com.example.ITconference.services;

import com.example.ITconference.mappers.ConferenceMapper;
import com.example.ITconference.repositories.ConferenceRepository;
import com.example.ITconference.repositories.entities.UserEntity;
import com.example.ITconference.services.dtos.ConferenceDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConferenceService {

    private final ConferenceRepository conferenceRepository;
    private final ConferenceMapper conferenceMapper;
    private final UserLogInfoService userLogInfoService;

    public ConferenceService(ConferenceRepository conferenceRepository,
                             ConferenceMapper conferenceMapper,
                             UserLogInfoService userLogInfoService) {
        this.conferenceRepository = conferenceRepository;
        this.conferenceMapper = conferenceMapper;
        this.userLogInfoService = userLogInfoService;
    }

    public void setConference(ConferenceDto dto){
        UserEntity user = getUserEntity();
        var conferenceEntity = conferenceMapper.fromDtoToEntity(dto, user);
        conferenceRepository.save(conferenceEntity);
    }

    public List<ConferenceDto> getAllConferences(){
        UserEntity user = getUserEntity();
        return conferenceRepository.getConferenceEntitiesByUser(user)
                .stream()
                .map(conferenceMapper::fromEntityToDto)
                .collect(Collectors.toList());
    }




    private UserEntity getUserEntity(){
        return userLogInfoService.getLoggedUserEntity();
    }


}
