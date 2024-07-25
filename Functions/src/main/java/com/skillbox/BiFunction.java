package com.skillbox;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface BiFunction<T, U, R> {

    R apply(T inputData0, U inputData1);

    default <V> BiFunction<T,U,V> andThen(Function<? super R,? extends V> after) {
        Objects.requireNonNull(after);
        return (t, u) -> after.apply(this.apply(t, u));
    }

    default Function<U, R> bind0(T inputData1) {
        return inputData2 -> this.apply(inputData1, inputData2);
    }

    default Function<T, R> bind1(U inputData1) {
        return inputData2 -> this.apply(inputData2, inputData1);
    }
}
