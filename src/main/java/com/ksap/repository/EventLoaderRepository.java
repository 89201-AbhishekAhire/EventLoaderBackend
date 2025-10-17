package com.ksap.repository;

import com.ksap.entity.EventLoader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventLoaderRepository extends JpaRepository<EventLoader, String> {
	boolean existsByStatusCode(String statusCode);
}