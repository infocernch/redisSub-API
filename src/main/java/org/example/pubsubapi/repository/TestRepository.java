package org.example.pubsubapi.repository;

import org.example.pubsubapi.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
