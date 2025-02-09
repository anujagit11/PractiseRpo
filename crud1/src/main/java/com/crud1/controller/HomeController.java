package com.crud1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.crud1.model.Student;
import com.crud1.serviceI.stuServiceI;

@RestController
public class HomeController {
	
	@Autowired
stuServiceI si;

  //inserting data
	
@PostMapping("/insertSingleData")
public String insertSingleData(@RequestBody Student s)
{
	si.saveSingle(s);
	return "single data inserted new record";
}

@PostMapping("insertlist")
public String insertList(@RequestBody List<Student> s)
{
	si.savelist(s);
	return "insert sucessfully";
}

@GetMapping("/getall")
public List<Student> getAllData()
{
	return si.getAll();
}

@GetMapping("/getSingle/{id}")
public Student getSingle(@PathVariable int id)
{
	return si.getSingle(id);
}

@PutMapping("/update/{id}")
public String update(@RequestBody Student s,@PathVariable int id)
{
	si.updateSingle(s);
	return "data updated";
}

@PatchMapping("/updatePatch/{id}")
public String updatePatch(@RequestBody Student s,@PathVariable int id)
{
	si.updatePatch(s);
	return "update patch";
}
 
@DeleteMapping("/delete/{id}")
public String delete(@PathVariable int id)
{
	si.delete(id);
	
	
	return "delete data sucessfully";
}
}
