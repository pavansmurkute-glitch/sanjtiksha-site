package com.sanjtiksha.site.repository;

import com.sanjtiksha.site.entity.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {}
