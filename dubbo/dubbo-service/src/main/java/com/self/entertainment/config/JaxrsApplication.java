package com.self.entertainment.config;

import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author AmazingZ
 * @date 2019/5/24 17:26
 */
@Component
@ApplicationPath("/sample-app/")
public class JaxrsApplication extends Application {
}
