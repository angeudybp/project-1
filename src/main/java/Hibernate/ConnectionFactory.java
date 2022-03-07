package Hibernate;

import org.hibernate.cfg.Configuration;

public class ConnectionFactory {
    private static Configuration configuration = null;
    private ConnectionFactory(){

    }
    public static Configuration getConfiguration(){
        if (configuration==null){
            configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
        }
        return configuration;
    }

}
