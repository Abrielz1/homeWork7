package com.skillbox;

import java.util.Objects;

@FunctionalInterface
public interface Predicate<T> {

    boolean test(T t);

    default Predicate<T> and(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return o -> this.test(o) && other.test(o);
    }

    default Predicate<T> or(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return o -> this.test(o) || other.test(o);
    }

    default Predicate<T> not(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return t -> !this.test(t);
    }

    default <T> Predicate<T> isEqual(Predicate<? super T> other) {
       return other == null ? Objects::isNull : other::equals;
    }

    static <T> Predicate<T> alwaysFalse() {
        return t -> false;
    }

    static <T> Predicate<T> alwaysTrue() {
        return t -> true;
    }
}
