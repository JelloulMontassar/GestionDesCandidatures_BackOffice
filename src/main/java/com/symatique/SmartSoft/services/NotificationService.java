package com.symatique.SmartSoft.services;

import com.symatique.SmartSoft.models.Notification;
import com.symatique.SmartSoft.models.Utilisateur;
import com.symatique.SmartSoft.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    public Notification sendNotification(Notification notification) {
        return notificationRepository.save(notification);
    }
    public Notification saveNotification(Notification notification) {
        return notificationRepository.save(notification);
    }
    public List<Notification> getLatestNotifications(Utilisateur user) {

        return notificationRepository.findBySeenFalseAndReceiverOrderBySendDateDesc(user);
    }
    public Notification getNotification(Long notificationId) {
        return notificationRepository.getById(notificationId);
    }
}
