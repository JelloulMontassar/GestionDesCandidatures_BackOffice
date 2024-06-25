package com.symatique.SmartSoft.controllers;

import com.symatique.SmartSoft.models.Notification;
import com.symatique.SmartSoft.models.Utilisateur;
import com.symatique.SmartSoft.services.Impl.UtilisateurServiceImpl;
import com.symatique.SmartSoft.services.NotificationService;
import com.symatique.SmartSoft.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class NotificationController {
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private UtilisateurServiceImpl userService;
    @MessageMapping("/subscribe")
    @SendTo("/topic/notifications/")
    public List<Notification> subscribe(Authentication authentication) {
        Utilisateur user = userService.getUserByEmail(authentication.getName());
        return notificationService.getLatestNotifications(user);
    }


}

