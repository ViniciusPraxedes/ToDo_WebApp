package com.example.webapplication.ToDoApp;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class ToDoControllerJpa {
        private ToDoRepository toDoRepository;

        public ToDoControllerJpa(ToDoRepository toDoRepository) {
            this.toDoRepository = toDoRepository;
        }

        //List to do
        @RequestMapping("/ListToDos")
        public String listAllToDos(ModelMap model) {
            String username = getLoggedInUsername(model);
            List<ToDo> todos = toDoRepository.findByUsername(username);
            model.addAttribute("todos", todos);
            return "ListToDos";
        }


        //Add to do
        @RequestMapping(value = "/AddToDo", method = RequestMethod.GET)
        public String showAddToDoPage(ModelMap model) {
            String userName = getLoggedInUsername(model);
            ToDo todo = new ToDo(0, userName, "", LocalDate.now().plusYears(1), false);
            model.put("todo", todo);
            return "AddToDo";
        }


        //Redirect to add to do page
        @RequestMapping(value = "/AddToDo", method = RequestMethod.POST)
        public String redirectToAddToDoPage(ModelMap model, @Valid @ModelAttribute("todo") ToDo todo, BindingResult result) {
            if (result.hasErrors()) {
                return "AddToDo";
            }
            String username = getLoggedInUsername(model);
            todo.setUsername(username);
            toDoRepository.save(todo);
            //toDoService.addTodo(userName, todo.getDescription(), todo.getTargetDate(), false);
            return "redirect:ListToDos";
        }

        //Delete to do
        @RequestMapping("DeleteToDo")
        public String deleteToDo(@RequestParam int id) {
            toDoRepository.deleteById(id);
            return "redirect:ListToDos";
        }


        //Update to do
        @RequestMapping(value = "UpdateToDo", method = RequestMethod.GET)
        public String showUpdateToDoPage(@RequestParam int id, ModelMap model) {
            ToDo todo = toDoRepository.findById(id).get();
            model.addAttribute("todo", todo);
            return "AddToDo";
        }

        @RequestMapping(value = "/UpdateToDo", method = RequestMethod.POST)
        public String updateToDo(ModelMap model, @Valid ToDo todoToBeUpdated, BindingResult result) {
            if (result.hasErrors()) {
                return "AddToDo";
            }
            String username = getLoggedInUsername(model);
            todoToBeUpdated.setUsername(username);
            toDoRepository.save(todoToBeUpdated);
            return "redirect:ListToDos";
        }

        private String getLoggedInUsername(ModelMap model) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            return authentication.getName();
        }
    }

