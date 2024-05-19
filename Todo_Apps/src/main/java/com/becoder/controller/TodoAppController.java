package com.becoder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.becoder.entity.Todo;
import com.becoder.service.TodoService;

@RestController
public class TodoAppController {
	@Autowired
	public TodoService todoService;
	@PostMapping("/save")
	public ResponseEntity<?>save(@RequestBody Todo todo){
		return new ResponseEntity<>(todoService.saveTodo(todo),HttpStatus.CREATED);
	}
	@GetMapping("/getAll")
	public ResponseEntity<?>getAllTodo(@RequestBody Todo todo){
		return new ResponseEntity<>(todoService.getAllTodo(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?>getTodoById(@PathVariable int id){
		return new ResponseEntity<>(todoService.getById(id),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteTodo(@PathVariable int id){
		todoService.delete(id);
		return new ResponseEntity<>("Todo Delete Successfully",HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<?>updateTodo(@RequestBody Todo todo,@PathVariable int id){
		return new ResponseEntity<>(todoService.updateTodo(id,todo),HttpStatus.OK);
	}

}
