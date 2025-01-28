package org.example.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.security.PublicKey;

@Component
@Scope("prototype")
public class Author {
    private String name;

    public Author(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}