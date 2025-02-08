package com.crud1.serviceI;

import java.util.List;

import com.crud1.model.Student;

public interface stuServiceI {

	public Student saveSingle(Student s);

	public List<Student> savelist(List<Student> s);

	public List<Student> getAll();

	public Student getSingle(int id);

	public Student updateSingle(Student s);

	public void updatePatch(Student s);

	public void delete(int id);

}
