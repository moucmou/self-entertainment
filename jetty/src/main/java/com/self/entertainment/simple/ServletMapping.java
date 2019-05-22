package com.self.entertainment.simple;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@AllArgsConstructor(staticName="of")
@Slf4j
public class ServletMapping implements Serializable {
    private static final long serialVersionUID = -3835893442344556053L;
    private String servletName;
    private String url;
    private String clazz;

    public static void main(String[] args) {
        ServletMapping.of("","","");
    }
}
