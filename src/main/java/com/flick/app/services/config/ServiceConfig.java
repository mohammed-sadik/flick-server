package com.flick.app.services.config;

import com.flick.app.services.MovieService;
import com.flick.app.services.MovieServiceImpl;
import com.flick.app.services.UserService;
import com.flick.app.services.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    UserService userService() {
        return new UserServiceImpl();
    }

    @Bean
    MovieService movieService() {
        return new MovieServiceImpl();
    }

}
