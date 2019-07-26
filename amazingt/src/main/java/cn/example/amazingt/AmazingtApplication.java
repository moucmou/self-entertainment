package cn.example.amazingt;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ServletComponentScan
public class AmazingtApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AmazingtApplication.class, args);
    }

//    @Bean
//    public TomcatServletWebServerFactory servletContainer() {
//        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
//            @Override
//            protected void postProcessContext(Context context) {
//                SecurityConstraint securityConstraint=new SecurityConstraint();
//                securityConstraint.setUserConstraint("CONFIDENTIAL");
//                SecurityCollection collection=new SecurityCollection();
//                collection.addPattern("/*");
//                securityConstraint.addCollection(collection);
//                context.addConstraint(securityConstraint);
//            }
//
//        };
//        tomcat.addAdditionalTomcatConnectors(httpConnector());
//        return tomcat;
//    }
//
//    @Bean
//    public Connector httpConnector() {
//            Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//
//        //Set the scheme that will be assigned to requests received through this connector
//        //@param scheme The new scheme
//        connector.setScheme("http");
//
//        //Set the port number on which we listen for requests.
//        // @param port The new port number
//        connector.setPort(8099);
//
//        //Set the secure connection flag that will be assigned to requests received through this connector.
//        //@param secure The new secure connection flag
//        //if connector.setSecure(true),the http use the http and https use the https;else if connector.setSecure(false),the http redirect to https;
//        connector.setSecure(false);
//
//        //redirectPort The redirect port number (non-SSL to SSL)
//        connector.setRedirectPort(8443);
//        return connector;
//    }


}
