/*package com.example.webapplication.ToDoApp;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

//@Controller
//@SessionAttributes("name")
public class ToDoController {

    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }


    //List to do
    @RequestMapping("/ListToDos")
    public String listAllToDos(ModelMap model){
        String username = getLoggedInUsername(model);
        List<ToDo> todos = toDoService.findByUsername(username);
        model.addAttribute("todos",todos);
        return "ListToDos";
    }


    //Add to do
    @RequestMapping(value="/AddToDo", method = RequestMethod.GET)
    public String showAddToDoPage(ModelMap model){
        String userName = getLoggedInUsername(model);
        ToDo todo = new ToDo(0, userName, "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "AddToDo";
    }


    //Redirect to add to do page
    @RequestMapping(value="/AddToDo", method = RequestMethod.POST)
    public String redirectToAddToDoPage(ModelMap model, @Valid @ModelAttribute("todo") ToDo todo, BindingResult result){
        if (result.hasErrors()){
           return "AddToDo";
        }
        String userName = getLoggedInUsername(model);
        toDoService.addTodo( userName, todo.getDescription(), todo.getTargetDate(), false);
        return "redirect:ListToDos";
    }

    //Delete to do
    @RequestMapping("DeleteToDo")
    public String deleteToDo(@RequestParam int id){
        toDoService.deleteById(id);
        return "redirect:ListToDos";
    }



    //Update to do
    @RequestMapping(value="UpdateToDo",method = RequestMethod.GET)
    public String showUpdateToDoPage(@RequestParam int id, ModelMap model){
        ToDo todo = toDoService.findById(id);
        model.addAttribute("todo", todo);
        return "AddToDo";
    }
    @RequestMapping(value="/UpdateToDo", method = RequestMethod.POST)
    public String updateToDo(ModelMap model, @Valid ToDo todoToBeUpdated, BindingResult result){
        if (result.hasErrors()){
            return "AddToDo";
        }
        String username = getLoggedInUsername(model);
        todoToBeUpdated.setUsername(username);
        toDoService.updateToDo(todoToBeUpdated);
        return "redirect:ListToDos";
    }
    private String getLoggedInUsername(ModelMap model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }





}*/
