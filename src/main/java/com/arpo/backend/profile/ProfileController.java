package com.arpo.backend.profile;

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
    public ResponseEntity<Profile> get(@PathVariable int uuid){
        try {
            Profile profile = profileService.getProfile(uuid);
            return new ResponseEntity<Profile>(profile, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Profile>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("add/")
    public void add(@RequestBody Profile profile){
        profileService.saveProfile(profile);
    }

    @PutMapping("update/{uuid}")
    public ResponseEntity<?> update(@RequestBody Profile profile, @PathVariable int uuid){
        try {
            Profile existProfile = profileService.getProfile(uuid);
            profile.setUuid(uuid);
            profileService.saveProfile(profile);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete/{uuid}")
    public void delete(@PathVariable int uuid) {
        profileService.deleteProfile(uuid);
    }

    @GetMapping("profileByLoginAndPassword")
    public ResponseEntity<?> findProfileID(@RequestParam String login_id, @RequestParam String password)
    {
        try{
            Profile profile = profileService.findProfileID(login_id,password);
            return new ResponseEntity<Profile>(profile, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<Profile>( HttpStatus.NOT_FOUND);
        }
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