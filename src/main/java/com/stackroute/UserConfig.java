package com.stackroute;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserConfig {
    @Bean
    public User user()
    {
        return new User();
    }
}
