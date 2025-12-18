package com.springboot.ranga.learn_webservices.socialmediaapp.service;

import com.springboot.ranga.learn_webservices.socialmediaapp.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static List<User> users = new ArrayList<>();
    private static int userCount = 0;

    static {

        users.add(new User(++userCount, "Murli Prasad Sharma", LocalDate.now().minusYears(40)));
        users.add(new User(++userCount, "Majnu Bhai", LocalDate.now().minusYears(60)));
        users.add(new User(++userCount, "Raghunandan Das Govardhan Das Wakavale", LocalDate.now().minusYears(10)));
        users.add(new User(++userCount, "Baburao Ganpat Rao Apte", LocalDate.now().minusYears(55)));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(int id) {
       return users.stream().filter(user->user.getId() == id).findFirst().orElse(null);
    }

    public User createUser(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public boolean deleteUserById(int id) {
        return users.removeIf(user -> user.getId() == id);
    }
}
