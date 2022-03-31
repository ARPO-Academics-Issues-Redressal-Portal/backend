package com.arpo.backend.profile;

import com.arpo.backend.APIResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
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
            if(Objects.isNull(profile)){
                throw new NoSuchElementException();
            }
            return new ResponseEntity<Profile>(profile, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Profile>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Profile profile){
        try {
            try {
                profileService.saveProfile(profile);
            } catch (Exception e) {
                throw new Exception();
            }
        }
        catch (Exception e){
            return new ResponseEntity(APIResponses.BAD_REQUEST_BODY,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(APIResponses.ELEMENT_ADDED, HttpStatus.OK);
    }

    @PutMapping("/update/{uuid}")
    public ResponseEntity<?> update(@RequestBody Profile profile, @PathVariable int uuid){
        Profile existProfile;
        try {
            existProfile = profileService.getProfile(uuid);
            if(Objects.isNull(existProfile)){
                throw new NoSuchElementException();
            }
        }
        catch (NoSuchElementException e){
            return new ResponseEntity(APIResponses.ELEMENT_NOT_FOUND,HttpStatus.BAD_REQUEST);
        }
        try {
            profile.setUuid(uuid);
            profileService.saveProfile(profile);
            return new ResponseEntity(profile,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(APIResponses.BAD_REQUEST_BODY, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity delete(@PathVariable int uuid) {
        try {
            profileService.deleteProfile(uuid);
        }
        catch (Exception e) {
            return new ResponseEntity(APIResponses.ELEMENT_NOT_DELETED, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(APIResponses.ELEMENT_DELETED, HttpStatus.OK);
    }

    @GetMapping("/profileByLoginAndPassword")
    public ResponseEntity<?> findProfileID(@RequestParam String login_id, @RequestParam String password)
    {
        try{
            Profile profile = profileService.findProfileID(login_id,password);
            if(Objects.isNull(profile)){
                throw new NoSuchElementException();
            }
            return new ResponseEntity<Profile>(profile, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<Profile>( HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/profiles/{profile_id}")
    public ResponseEntity<?> getProfiles(@PathVariable Integer profile_id){
        try{
            Profile profile = profileService.profileByProfileID(profile_id);
            if(Objects.isNull(profile)){
                throw new NoSuchElementException();
            }
            return new ResponseEntity<Profile>(profile, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<Profile>(HttpStatus.NOT_FOUND);
        }
    }

}