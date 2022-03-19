package com.arpo.backend.announcement;

import com.arpo.backend.course_role.CourseRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.List;

public interface AnnouncementRepo extends JpaRepository<Announcement, String> {
    @Query(value = "select * from announcement a where a.course = ?1",
            nativeQuery = true)
    public List<Announcement> announcementByCourse(String course);
}