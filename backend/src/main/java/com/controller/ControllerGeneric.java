package com.controller;

import javassist.bytecode.DuplicateMemberException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface ControllerGeneric<T> {

    @GetMapping
    List<T> getList();

    @GetMapping("/{id}")
    T get(long id);

    @PostMapping("/add")
    void add(@RequestBody @Valid T obj);

    @PutMapping("/update")
    void update(@RequestBody T obj);


    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable long id);
}
