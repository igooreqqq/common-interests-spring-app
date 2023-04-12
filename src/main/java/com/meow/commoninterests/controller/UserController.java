package com.meow.commoninterests.controller;

import com.meow.commoninterests.entity.Interests;
import com.meow.commoninterests.entity.User;
import com.meow.commoninterests.repository.InterestsRepository;
import com.meow.commoninterests.repository.UserRepository;
import com.meow.commoninterests.request.AddInterest;
import com.meow.commoninterests.request.AddUser;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;
    private InterestsRepository interestsRepository;

    public UserController(UserRepository userRepository, InterestsRepository interestsRepository) {
        this.userRepository = userRepository;
        this.interestsRepository = interestsRepository;
    }

    @PostMapping("/users")
    public List<User> fetchUsersList() {
        return userRepository.findAll();
    }

    @PostMapping("/users/{userId}")
    public User getUserByI(@PathVariable Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
    }

    @PostMapping
    public void addUser(@RequestBody AddUser addUser) {
        User user = new User();

        user.setUsername(addUser.getUsername());
        user.setEmail(addUser.getEmail());

        userRepository.save(user);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@RequestBody Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());

        userRepository.delete(user);
    }

    @PostMapping("users/{userId}/interests")
    public void addInterest(@PathVariable Long userId, @RequestBody AddInterest addInterest) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        Interests interests = new Interests();

        interests.setContent(addInterest.getContent());
        user.getInterestsList().add(interests);

        interestsRepository.save(interests);
        userRepository.save(user);
    }

    @DeleteMapping("/users/{userId}/interests/{interestId}")
    public void deleteInterest(@PathVariable Long userId, @PathVariable Long interestId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        Interests interests = interestsRepository.findById(interestId).orElseThrow(() -> new NoSuchElementException());

        user.getInterestsList().remove(interests);
        interestsRepository.delete(interests);
        interestsRepository.save(interests);
    }

    @PostMapping("users/{userId1}/common-interests/{userId2}")
    public List<Interests> findCommonInterests(@PathVariable Long userId1, @PathVariable Long userId2) {
        User user1 = userRepository.findById(userId1).orElseThrow(() -> new NoSuchElementException());
        User user2 = userRepository.findById(userId2).orElseThrow(() -> new NoSuchElementException());

        List<Interests> commonInterests = new ArrayList<>();

        List<Interests> userInterests1 = user1.getInterestsList();
        List<Interests> userInterests2 = user2.getInterestsList();

        for(Interests interests1 : userInterests1) {
            for(Interests interests2 : userInterests2) {
                if(interests1.getContent().equals(interests2.getContent())) {
                    commonInterests.add(interests1);
                }
            }
        }

        return commonInterests;
    }
}
