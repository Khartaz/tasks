package com.crud.tasks.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AdminConfig {
    @Value("${admin.name}")
    private String adminName;
    @Value("${admin.mail}")
    private String adminMail;
    @Value("${info.app.owner.name}")
    private String name;
    @Value("${info.app.owner.surname}")
    private String lastname;
    @Value("${info.company.name}")
    private String companyName;


    public AdminConfig() {
    }

    public String getAdminMail() {
        return adminMail;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCompanyName() {
        return companyName;
    }
}
