package com.becoder.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.becoder.entity.Todo;
@Service
public interface TodoService {
	public Todo saveTodo(Todo todo);
	public List<Todo> getAllTodo();
	public Todo getById(int id);
	public void delete(int id);
	public Todo updateTodo(int id,Todo todo);

}
