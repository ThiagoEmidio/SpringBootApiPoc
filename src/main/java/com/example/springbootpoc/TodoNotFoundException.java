package com.example.springbootpoc;

public class TodoNotFoundException extends RuntimeException {
    TodoNotFoundException(Long id){
        super("Não foi possível encontrar a tarefa " + id);
    }
}
