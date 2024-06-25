package com.symatique.SmartSoft.DTO;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NotificationDTO {
    private Long id;
    private Long receiverId;
    private String status;
    private String message;
    private Date sendDate;
    private Long candidatureId;
    private Boolean seen;
}
