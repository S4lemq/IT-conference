package com.example.ITconference.repositories;

import com.example.ITconference.repositories.entities.ConferenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConferenceRepository extends JpaRepository<ConferenceEntity, UUID> {
}
