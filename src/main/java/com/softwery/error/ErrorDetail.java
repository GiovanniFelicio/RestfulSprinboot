/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwery.error;

/**
 *
 * @author engcarvalho
 */
public class ErrorDetail {
    
    private String title;
    
    private int status;
    
    private String detail;
    
    private long timestamp;
    
    private String developerMessage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }
    
    public static class Builder {

        private String title;
        private int status;
        private String detail;
        private long timestamp;
        private String developerMessage;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder title(final String value) {
            this.title = value;
            return this;
        }

        public Builder status(final int value) {
            this.status = value;
            return this;
        }

        public Builder detail(final String value) {
            this.detail = value;
            return this;
        }

        public Builder timestamp(final long value) {
            this.timestamp = value;
            return this;
        }

        public Builder developerMessage(final String value) {
            this.developerMessage = value;
            return this;
        }

        public ErrorDetail build() {
            ErrorDetail ErrorDetail = new ErrorDetail();
            ErrorDetail.setTitle(title);
            ErrorDetail.setStatus(status);
            ErrorDetail.setDetail(detail);
            ErrorDetail.setTimestamp(timestamp);
            ErrorDetail.setDeveloperMessage(developerMessage);

            return ErrorDetail;
        }
    }
}
