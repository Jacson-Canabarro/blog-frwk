package br.com.frwk.exceptions;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BadRequestExceptionDetails {
    private String title;
    private int status;
    private String developerMessage;
    private String details;
    private LocalDateTime timestamp;
}
