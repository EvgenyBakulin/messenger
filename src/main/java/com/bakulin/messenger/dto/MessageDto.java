package com.bakulin.messenger.dto;

import lombok.Data;

import java.util.List;
@Data
public class MessageDto {
    private Long message_id;
    private String text;
    private List <UsersForSendingDto> correspondents;
    private List <String> file;
}
