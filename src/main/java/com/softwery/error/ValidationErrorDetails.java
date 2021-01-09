/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softwery.error;

import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author engcarvalho
 */
public class ValidationErrorDetails extends ErrorDetail {

    private List<Map<String,List<String>>> fieldsError;

    public List<Map<String,List<String>>> getFieldsError() {
        return fieldsError;
    }

    public void setFieldsError(List<Map<String,List<String>>> fieldsError) {
        this.fieldsError = fieldsError;
    }
        
    public static class Builder {

        private String title;
        private int status;
        private String detail;
        private long timestamp;
        private String developerMessage;
        private List<Map<String,List<String>>> fieldsError;

        private Builder() {
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

        public Builder fieldsError(final List<Map<String,List<String>>> value) {
            this.fieldsError = value;
            return this;
        }

        public ValidationErrorDetails build() {
            ValidationErrorDetails ValidationErrorDetails = new ValidationErrorDetails();
            ValidationErrorDetails.setTitle(title);
            ValidationErrorDetails.setStatus(status);
            ValidationErrorDetails.setDetail(detail);
            ValidationErrorDetails.setTimestamp(timestamp);
            ValidationErrorDetails.setDeveloperMessage(developerMessage);
            ValidationErrorDetails.setFieldsError(fieldsError);

            return ValidationErrorDetails;
        }
    }

    public static ValidationErrorDetails.Builder builder() {
        return new ValidationErrorDetails.Builder();
    }
}
