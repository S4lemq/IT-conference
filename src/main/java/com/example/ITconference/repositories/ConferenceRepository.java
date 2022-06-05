package com.example.ITconference.repositories;

import com.example.ITconference.repositories.entities.ConferenceEntity;
import com.example.ITconference.repositories.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ConferenceRepository extends JpaRepository<ConferenceEntity, UUID> {

    List<ConferenceEntity> getConferenceEntitiesByUser(UserEntity userEntity);

}
