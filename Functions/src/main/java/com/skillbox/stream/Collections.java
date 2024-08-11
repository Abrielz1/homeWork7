package com.skillbox.stream;

import com.skillbox.BiFunction;
import com.skillbox.Function1;
import com.skillbox.Predicate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Collections {

    public static <T, R> List<R> map(Function1<T, R> functionF, T[] a) {

        List<R> result = new ArrayList<>();

        for (T iter : a) {
            result.add(functionF.apply(iter));
        }

        return result;
    }

    public static <T> List<T> filter(Predicate<T> predicateP, T[] a) {

        List<T> result = new ArrayList<>();

        for (T iter : a) {

            if (!predicateP.test(iter)) {
                continue;
            }

            result.add(iter);
        }

        return result;
    }

    public static <T> List<T> takeWhile(Predicate<T> predicateP, T[] a) {

        List<T> result = new ArrayList<>();

        for (T iter : a) {

            if (predicateP.test(iter)) {
                result.add(iter);
            } else {
                return result;
            }
        }

        return result;
    }

    public static <T> List<T> takeUnless(Predicate<T> predicateP, T t, T[] a) {

        List<T> result = new ArrayList<>();

        for (T iter : a) {

            if (!predicateP.test(iter)) {
                result.add(iter);
            } else {
                return result;
            }
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    public static <T, U, R> R foldl(BiFunction<T, U, R> biFunctionB, T start, Collection<T> collectionElements) {

        for (Object e : collectionElements) {
             start = (T) biFunctionB.apply(start, (U) e);
        }

        return (R) start;
    }

    public static <T, U, R> R foldr(BiFunction<T, U, R> biFunctionB, T start, Collection<T> collectionElements) {

        List<T> list = new ArrayList<>(collectionElements);
        java.util.Collections.reverse(list);

        return foldl(biFunctionB, start, list);
    }
}
