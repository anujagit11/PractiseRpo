package com.crud1.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.crud1.Repository.StuRepository;
import com.crud1.model.Student;
import com.crud1.serviceI.stuServiceI;

@SpringBootTest
public class ServiceTest {
	
	@MockBean
	StuRepository sr;
	
	@Autowired
	stuServiceI si;
	
	private  Student s;
	private  Student s2;
	
	
	@BeforeEach
	public void setUp()
	{
		s=new Student("anuja","admin","admin");
		s2=new Student("arpit","arpit","admin2");
		
	}
	
	public void tearDown()
	{
		sr.deleteAll();
		s=null;
		//al.clear();
		
	}
 
  @Test
  public void tests_SaveStudent()
  {
	  when(sr.save(s)).thenReturn(s);
	  assertEquals(s, si.saveSingle(s));
  }
  
  @Test
  public void tests_saveList()
  {
	   List<Student> al=new ArrayList<Student>();
			al.add(new Student("anuja","admin","admin")); 
			 al.add(new Student("arpit","arpit","admin2"));  

	  when(sr.saveAll(al)).thenReturn(al);
	  assertEquals(al, si.savelist(al));
  }
  
  @Test
  public void tests_getAll()
  {
	  List<Student> al=new ArrayList<Student>();
		al.add(new Student("anuja","admin","admin")); 
		 al.add(new Student("arpit","arpit","admin2"));  

		 when(sr.findAll()).thenReturn(al);
		 assertEquals(al, si.getAll());
  }
  
  @Test
  public void tests_single()
  {
	  when(sr.findById(1)).thenReturn(Optional.of(s));
	  assertEquals("anuja",si.getSingle(1).getName());
	  
  }
  
  @Test
  public void tests_updateSingle()
  {
	  s=new Student("anujaSaykhede","admin","admin");
	  when(sr.save(s)).thenReturn(s);
	  assertEquals("anujaSaykhede", si.updateSingle(s).getName());
  }
  
  @Test
  public void tests_delete()
  {
	   doNothing().when(sr).deleteById(1);
	  si.delete(1);
	  verify(sr,times(1)).deleteById(1);
  }
}
