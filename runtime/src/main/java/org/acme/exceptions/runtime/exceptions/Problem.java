package org.acme.exceptions.runtime.exceptions;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response.Status;

public class Problem {

    private int status;
    private OffsetDateTime timestamp;
    private String title;
    private String detail;
    private List<ProblemObject> messages;

    public Problem(ConstraintViolationException e){
        this.status    = Status.BAD_REQUEST.getStatusCode();
        this.timestamp = OffsetDateTime.now();
        this.title     = Status.BAD_REQUEST.getReasonPhrase();
        this.detail    = "Dados inválidos";
        this.messages  = new ArrayList<>();
    }

    public Problem(BusinessException e){
        this.status    = 422;
        this.timestamp = OffsetDateTime.now();
        this.title     = "Erro negocial";
        this.detail    = e.getMessage();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<ProblemObject> getMessages() {
        return messages;
    }

    public void setMessages(List<ProblemObject> messages) {
        this.messages = messages;
    }

}
