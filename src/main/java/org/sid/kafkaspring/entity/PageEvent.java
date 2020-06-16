package org.sid.kafkaspring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@Data
@NoArgsConstructor @AllArgsConstructor
@ToString
public class PageEvent {
    private String page;
    private Date date;
    private int duration;
}
