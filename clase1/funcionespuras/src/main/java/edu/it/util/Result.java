package edu.it.util;

public class Result<V> {
    public final V value;
    public final Throwable error;

    private Result(V value, Throwable error) {
        this.value = value;
        this.error = error;
    }

    public boolean isError() {
        return error != null;
    }

    public static <V> Result<V> failure(Throwable error) {;
        return new Result<>(null, error);
    }

    public static <V> Result<V> success(V value) {
        return new Result<>(value, null);
    }
}

