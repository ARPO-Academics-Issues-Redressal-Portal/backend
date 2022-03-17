package com.arpo.backend.forum;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumRepo extends JpaRepository<Forum, String> {

}