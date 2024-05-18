package com.example.bookingmicroservice.resources;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResource<T> {

    private boolean success;
    private String message;
    private T data;

    private ApiResource() {}


    public static class Builder<T> {
        private boolean success;
        private String message;
        private T data;

        public Builder<T> success(boolean success) {
            this.success = success;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ApiResource<T> build() {
            ApiResource<T> response = new ApiResource<>();
            response.success = this.success;
            response.message = this.message;
            response.data = this.data;
            return response;
        }
    }
}
