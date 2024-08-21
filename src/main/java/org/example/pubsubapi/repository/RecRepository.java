package org.example.pubsubapi.repository;

import org.example.pubsubapi.domain.Rec;
import org.example.pubsubapi.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecRepository extends JpaRepository<Rec, String> {
}
