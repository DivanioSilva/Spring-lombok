package com.lab.springlombok.exceptions;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public @Data class ExceptionsBag extends Exception{
    private List<EntityNotFoundException> exceptions;

    public ExceptionsBag() {
        this.exceptions = new ArrayList<>();
    }

    public void addExceptions(EntityNotFoundException exception) {
        this.exceptions.add(exception);
    }

    public boolean isNotEmpty() {
        return !this.exceptions.isEmpty();
    }

    public void clear(){
        this.exceptions.clear();
    }
}
