package com.lautarobravo.tracipapi.domain.services;

import java.util.List;
import java.util.stream.StreamSupport;

public interface IterableExtensions {
    static <T> List<T> toList(Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .toList();
    }
}
