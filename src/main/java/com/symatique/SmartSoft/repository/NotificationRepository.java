package com.symatique.SmartSoft.repository;

import com.symatique.SmartSoft.models.Notification;
import com.symatique.SmartSoft.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findTop10ByOrderBySendDateDesc();
    List<Notification> findBySeenFalseAndReceiverOrderBySendDateDesc(Utilisateur receiver);

}
