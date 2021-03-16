package com.flick.app;

import com.flick.app.models.User;
import com.flick.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.fail;
import static org.testng.Assert.assertTrue;

@SpringBootTest(classes = FlickServerApplication.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testRegister() {
        User user = new User();
        user.setEmail("test@test.com");
        user.setFirstName("Test");
        user.setLastName("Bot");
        user.setPassword("password");

        try {
            Map<String, Boolean> status = userService.register(user);
            assertTrue(status.get("status"));
        } catch (Exception e) {
            fail("It should not fail");
        }

    }
    @Test
    public void testReRegister() {
        User user = new User();
        user.setEmail("test@test.com");
        user.setFirstName("Test");
        user.setLastName("Bot");
        user.setPassword("password");

        try {
            Map<String, Boolean> status = userService.register(user);
        } catch (Exception e) {
            fail("User already exists");
        }

    }

    @Test
    public void testRegisterFail() {
        User user = new User();
        user.setFirstName("Test");
        user.setLastName("Bot");
        user.setPassword("password");

        try {
            Map<String, Boolean> status = userService.register(user);
            assertTrue(status.get("status"));
        } catch (Exception e) {
            fail("It should not fail");
        }

    }
}
