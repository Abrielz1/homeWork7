package com.skillbox.stream;

import com.skillbox.BiFunction;
import com.skillbox.Function1;
import com.skillbox.Predicate;
import java.util.ArrayList;
import java.util.List;

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

    public static <T, V, R> List<T> takeUnless(BiFunction<T, V, R> BiFunctionB, T t, T[] a) {

        List<T> result = new ArrayList<>();


        return result;
    }

    public static <T, V, R> List<T> foldr(BiFunction<T, V, R> BiFunctionB, T t, T[] a) { // todo: foldr / foldl — принимает функцию двух аргументов, начальное значение и коллекцию, работает так.

        List<T> result = new ArrayList<>();

        return result;
    }

    public static <T> List<T> foldl(Predicate<T> predicateP, T[] a) { // todo: foldr / foldl — принимает функцию двух аргументов, начальное значение и коллекцию, работает так.

        List<T> result = new ArrayList<>();


        return result;
    }
}
