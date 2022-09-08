package com.example.springbootpoc;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class ToDoController {
    private final TodoRepository repository;

    ToDoController(TodoRepository repository){
        this.repository = repository;
    }

    @GetMapping("/todo")
    public List<TodoModel> getAll(){
        return repository.findAll();
    }

    @PostMapping("/todo")
    TodoModel newTodo(@RequestBody TodoModel todo) {
        return repository.save(todo);
    }

    // Single item

    @GetMapping("/todo/{id}")
    TodoModel getOne(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    @PutMapping("/todo/{id}")
    TodoModel replaceEmployee(@RequestBody TodoModel todoModel, @PathVariable Long id) {

        return repository.findById(id)
                .map(model -> {
                    model.setContent(todoModel.getContent());
                    return repository.save(model);
                })
                .orElseGet(() -> {
                    todoModel.setId(id);
                    return repository.save(todoModel);
                });
    }

    @DeleteMapping("/todo/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
