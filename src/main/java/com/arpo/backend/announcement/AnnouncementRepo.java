package com.arpo.backend.announcement;

import org.springframework.data.jpa.repository.JpaRepository;
public interface AnnouncementRepo extends JpaRepository<Announcement, String> {

}