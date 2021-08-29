package br.com.frwk.exceptions;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class ExceptionDetails {

    protected String title;
    protected int status;
    protected String developerMessage;
    protected String details;
    protected LocalDateTime timestamp;
}
