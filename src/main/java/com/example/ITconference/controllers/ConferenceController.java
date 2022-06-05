package com.example.ITconference.controllers;

import com.example.ITconference.services.ConferenceService;
import com.example.ITconference.services.dtos.ConferenceDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conference")
public class ConferenceController {

    private final ConferenceService conferenceService;

    public ConferenceController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @GetMapping
    public List<ConferenceDto> getConferences(){
        return conferenceService.getAllConferences();
    }

    @PostMapping
    public void setConference(@RequestBody ConferenceDto dto){
        conferenceService.setConference(dto);
    }
}
