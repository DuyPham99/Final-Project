package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperUtil {
    @Autowired
    com.github.dozermapper.core.Mapper mapper;

    public  <T, U> List<U> map(final List<T> source, final Class<U> destType) {

        final List<U> dest = new ArrayList<>();

        for (T element : source) {
            dest.add(this.mapper.map(element, destType));
        }

        return dest;
    }
}
