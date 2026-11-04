package com.app.mechat.primitives;

import lombok.Getter;

public class Result<T>{
    @Getter private boolean isFailure;
    @Getter private boolean isSuccess;
    @Getter private Error error;
    @Getter private T value;

    public Result(T value){
        isFailure = false;
        isSuccess = true;
        this.value = value;
        error = Error.none;
    }

    public Result(Error error){
        isFailure = true;
        isSuccess = false;
        this.error = error;
        this.value = null;
    }

    public static <T> Result<T> success(T result){
        return new Result<>(result);
    }

    public static <T> Result<T> failure(Error error){
        return new Result<>(error);
    }
}
