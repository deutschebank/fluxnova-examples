package org.finos.flowave;

import org.finos.flowave.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDataSetup implements  CommandLineRunner {
   private final UserService userService;

    @Autowired
    public UserDataSetup(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void run(String... args) throws Exception {
        try {
            userService.setupDefaultUserGroupAndAuthorizations();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
