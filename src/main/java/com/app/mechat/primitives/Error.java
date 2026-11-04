package com.app.mechat.primitives;

public record Error(String code, String message) {
    public static Error none = new Error("", "");
}
