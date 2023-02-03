package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseDao;
import com.example.demo.entities.Courses;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao crdao;
	
//	public List<Courses> courselist;
	
	
	public CourseServiceImpl() {
//		courselist=new ArrayList<Courses>();
//		courselist.add(new Courses(100,"java course","this is java course"));
//		courselist.add(new Courses(102,"dbda course","this is dbda course"));
//		courselist.add(new Courses(103,"ditiss course","this is ditis course"));		
	}
	
	
	@Override
	public List<Courses> getCourses() {
		return crdao.findAll();
	}


//	@SuppressWarnings("deprecation")
	@Override
	public Courses getCourse(long courseid) {
		// TODO Auto-generated method stub
//		Courses tempc=null;
//		for(Courses c:courselist) {
//			if(c.getId()==courseid) {
//				tempc=c;
//				break;
//			}
//		}		
		return crdao.getReferenceById(courseid);
	}


	@Override
	public Courses addCourse(Courses tempobj) {
		// TODO Auto-generated method stub
//		courselist.add(tempobj);
		return crdao.save(tempobj);
	}


	@Override
	public long deleteCourse(long courseid) {
		// TODO Auto-generated method stub
//		for(Courses c:courselist) {
//			if(c.getId()==courseid) {
//				courselist.remove(c);
//				break;				
//			}
//		}
//		return courseid;
				crdao.deleteById(courseid);
				return courseid;
	}


	@Override
	public long getCourseAndUpdate(Courses obj) {
		// TODO Auto-generated method stub
//		courselist.forEach(temp->{
//		if(temp.getId()==obj.getId()) {
//			temp.setTitle(obj.getTitle());
//			temp.setDescription(obj.getDescription());
//		}
//		});				
		return crdao.save(obj).getId();
	}

}
