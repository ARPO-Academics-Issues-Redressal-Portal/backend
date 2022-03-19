package com.arpo.backend.profile;

import com.arpo.backend.announcement.Announcement;
import com.arpo.backend.course_role.CourseRole;
import com.arpo.backend.profile.Profile;
import com.arpo.backend.profile.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    ProfileService profileService;

    @GetMapping("")
    public List<Profile> list(){
        return profileService.listAllProfile();
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Profile> get(@PathVariable String uuid){
        try {
            Profile profile = profileService.getProfile(uuid);
            return new ResponseEntity<Profile>(profile, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Profile>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Profile profile){
        profileService.saveProfile(profile);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<?> update(@RequestBody Profile profile, @PathVariable String uuid){
        try {
            Profile existProfile = profileService.getProfile(uuid);
            profile.setUuid(uuid);
            profileService.saveProfile(profile);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("profileByloginAndPassword")
    public ResponseEntity<?> findProfileID(@RequestParam String login_id, @RequestParam String password)
    {
        try{
            Profile profile = profileService.findProfileID(login_id,password);
            return new ResponseEntity<Profile>(profile, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<Profile>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable String uuid) {
        profileService.deleteProfile(uuid);
    }

    @GetMapping("/profiles/{profile_id}")
    public ResponseEntity<?> getProfiles(@PathVariable Integer profile_id){
        try{
            Profile profile = profileService.profileByProfileID(profile_id);
            return new ResponseEntity<Profile>(profile, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<Profile>(HttpStatus.NOT_FOUND);
        }
    }
}