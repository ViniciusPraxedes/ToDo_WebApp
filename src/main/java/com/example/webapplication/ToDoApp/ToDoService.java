package com.example.webapplication.ToDoApp;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

@Service
public class ToDoService {
    private static List<ToDo> todos = new ArrayList<>();

    private static int todosCount = 1;

    /*static{
        todos.add(new ToDo(todosCount++,"Vini","Learn software development", LocalDate.now().plusYears(1), false));
        todos.add(new ToDo(todosCount++,"Vini","Learn Russian", LocalDate.now().plusYears(1), false));
        todos.add(new ToDo(todosCount++,"Vini","Read books", LocalDate.now().plusYears(1), false));
    }*/

    public List<ToDo> findByUsername(String username){
        /*todos.sort(Comparator.comparingInt(ToDo::getId));*/
        Predicate<? super ToDo> predicate = ToDo -> ToDo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }
    public ToDo findById(int id){
        Predicate<? super ToDo> predicate = ToDo -> ToDo.getId() == id;
        ToDo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }
    public void addTodo(String userName, String description, LocalDate targetDate, boolean isItDone){
        ToDo todo = new ToDo(++todosCount,userName,description,targetDate, isItDone);
        todos.add(todo);

    }
    public void deleteById(int id){
        Predicate<? super ToDo> predicate = ToDo -> ToDo.getId() == id;
        todos.removeIf(predicate);
    }
    public void updateToDo(@Valid ToDo todo){
        deleteById(todo.getId());
        todos.add(todo);
    }
 }

