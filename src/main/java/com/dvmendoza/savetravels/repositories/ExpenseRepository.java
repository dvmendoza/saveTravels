package com.dvmendoza.savetravels.repositories;

import com.dvmendoza.savetravels.models.Expense;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<Expense, Long>{
	List<Expense> findAll();

}
