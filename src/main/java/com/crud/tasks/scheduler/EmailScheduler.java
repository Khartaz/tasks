package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {
    private SimpleEmailService simpleEmailService;
    private TaskRepository taskRepository;
    private AdminConfig adminConfig;

    @Autowired
    public EmailScheduler(SimpleEmailService simpleEmailService,
                          TaskRepository taskRepository,
                          AdminConfig adminConfig) {
        this.simpleEmailService = simpleEmailService;
        this.taskRepository = taskRepository;
        this.adminConfig = adminConfig;
    }

    private static final String SUBJECT = "Tasks: Once a day email";

    @Scheduled(fixedDelay = 10000)   // (cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        long size = taskRepository.count();

        String task = size > 1 ? " tasks" : " task";
        String message = "Currently in database you got: " + size + task;

        simpleEmailService.sendInfoTaskMessage(new Mail(adminConfig.getAdminMail(), SUBJECT, message));

    }

}
