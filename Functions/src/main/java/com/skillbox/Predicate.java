package com.skillbox;

import java.util.Objects;

@FunctionalInterface
public interface Predicate<T> {

    boolean test(T t);

    default Predicate<T> and(Predicate<T> other) {
        Objects.requireNonNull(other);
        return (o) -> this.test(o) && other.test(o);
    }

    default Predicate<T> or(Predicate<T> other) {
        Objects.requireNonNull(other);
        return (o) -> this.test(o) || other.test(o);
    }

    default Predicate<T> not(Predicate<T> other) {
        Objects.requireNonNull(other);
        return other.negate();
    }

    default Predicate<T> negate() {
        return (t) -> !this.test(t);
    }

    default <T> Predicate<T> isEqual(Predicate<T> other) {
       return other == null ? Objects::isNull : other::equals;
    }
}
