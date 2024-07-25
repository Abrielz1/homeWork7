package com.skillbox;

import java.util.Objects;

@FunctionalInterface
public interface Function1<T, R> {

    R apply(T inputData);

    default <V> Function1<T, V> compose(Function1<? super R, ? extends V> input) {
        Objects.requireNonNull(input);
        return (v) -> input.apply(this.apply(v));
    }
}
