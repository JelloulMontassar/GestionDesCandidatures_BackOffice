package com.symatique.SmartSoft.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receiver_id")
    private Utilisateur receiver;

    @Column(name = "notification_status")
    private String status;

    private String message;

    @Column(name = "send_date")
    private Date sendDate;

    @Column(name = "candidature_id")
    private Long candidatureId;

    private Boolean seen;
}
