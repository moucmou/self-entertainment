package com.self.entertainment.simple;

public abstract class AbstractServlet {

    //Tomcat是满足Servlet规范的容器,所以提供了doget,dopost,service等常用的方法
    public abstract  void doGet(SimpleRequest simpleRequest , SimpleResponse simpleResponse);

    public abstract  void doPost(SimpleRequest myRequest , SimpleResponse simpleResponse);

    public void service(SimpleRequest simpleRequest , SimpleResponse simpleResponse){
        if (simpleRequest.getMethod().equalsIgnoreCase("POST")){
            doPost(simpleRequest,simpleResponse);
        }else  if (simpleRequest.getMethod().equalsIgnoreCase("GET")){
            doGet(simpleRequest,simpleResponse);
        }

    }
}
