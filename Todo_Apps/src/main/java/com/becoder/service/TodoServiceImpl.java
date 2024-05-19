package com.becoder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.becoder.entity.Todo;
import com.becoder.exception.ResourceNotFoundException;
import com.becoder.repository.TodoRepo;
@Service
public class TodoServiceImpl implements TodoService{
	
	@Autowired
	private TodoRepo todoRepo;

	@Override
	public Todo saveTodo(Todo todo) {
		
		return todoRepo.save(todo);
	}

	@Override
	public List<Todo> getAllTodo() {
		return todoRepo.findAll();
	}

	@Override
	public Todo getById(int id) {
	return todoRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Todo id not Found with id="+id));
	}

	@Override
	public void delete(int id) {
		Todo todo=todoRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Todo id not Found with id="+id));
		todoRepo.delete(todo);
		
	}

	@Override
	public Todo updateTodo(int id, Todo todo) {
		Todo oldtodo=todoRepo.findById(id).get();
		oldtodo.setTitle(todo.getTitle());
		oldtodo.setDescription(todo.getDescription());
		oldtodo.setStatus(todo.getStatus());
		oldtodo.setUsername(todo.getUsername());
		return todoRepo.save(oldtodo);
	}
	
	
	

}
