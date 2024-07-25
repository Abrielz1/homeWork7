package com.skillbox;

import java.util.Objects;

@FunctionalInterface
public interface Function1<T, R> {

    R apply(T inputData);

    default <V> Function1<V, R> compose(Function1<V, T> input) {
        Objects.requireNonNull(input);
        return (V v) -> apply(input.apply(v));
    }
}
