package com.bakulin.messenger.repository;

import com.bakulin.messenger.model.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Messages,Long> {
}
