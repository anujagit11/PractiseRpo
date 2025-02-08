package com.crud1.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud1.Repository.StuRepository;
import com.crud1.model.Student;
import com.crud1.serviceI.stuServiceI;

@Service
public class StuServiceImpl implements stuServiceI{
	@Autowired
	StuRepository r;
	

	@Override
	public Student saveSingle(Student s) {
		return r.save(s);
		
	 }


	@Override
	public List<Student> savelist(List<Student> s) {
		return r.saveAll(s);
		
	}


	@Override
	public List<Student> getAll() {
		
		return r.findAll();
		
	}


	@Override
	public Student getSingle(int id) {
		Optional<Student> op=r.findById(id);
		if(op.isPresent())
		{
			Student s=op.get();
			return s;
		}
		else
		{
		return null;
		}
	}


	@Override
	public Student updateSingle(Student s) {
		return r.save(s);
		
	}


	@Override
	public void updatePatch(Student s) {
        r.save(s);
		
	}


	@Override
	public void delete(int id) {
		r.deleteById(id);
		
	}

}
