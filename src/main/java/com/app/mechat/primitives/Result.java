package com.app.mechat.primitives;

import lombok.Getter;

public class Result<T>{
    @Getter private boolean isFailure;
    @Getter private boolean isSuccess;
    @Getter private Error error;
    private T result;

    public Result(T result){
        isFailure = false;
        isSuccess = true;
        this.result = result;
        error = Error.none;
    }

    public Result(Error error){
        isFailure = true;
        isSuccess = false;
        this.error = error;
    }

    public T getResult(){
        if(isFailure)
            throw new RuntimeException("Value of result can not be accessed");

        return this.result;
    }

    public static <T> Result<T> success(T result){
        return new Result<>(result);
    }

    public static <T> Result<T> failure(Error error){
        return new Result<>(error);
    }
}
