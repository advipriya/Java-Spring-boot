package com.taskapp.LoginToDo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskapp.LoginToDo.model.ToDo;

@Repository
public interface IToDoRepo extends JpaRepository<ToDo, Long>{

}