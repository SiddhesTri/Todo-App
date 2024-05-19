package com.becoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.becoder.entity.Todo;
@Repository
public interface TodoRepo extends JpaRepository<Todo, Integer> {

}
