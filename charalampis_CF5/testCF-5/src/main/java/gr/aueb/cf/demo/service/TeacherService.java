package gr.aueb.cf.demo.service;

import java.util.List;

import gr.aueb.cf.demo.model.Teacher;

public interface TeacherService {

	List<Teacher> getAllTeachers();
	void saveTeacher(Teacher teacher);
	Teacher getTeacherById(long id);
	void deleteTeacherById(Long id);
	
}