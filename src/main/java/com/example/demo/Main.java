package com.example.demo;

import com.example.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try{
			session.beginTransaction();
			Student student = new Student("Killer", "Kol", "kill@gmail.com");
			System.out.println("Student: " + student);
			System.out.println("Course: " + student.getCourses());
			Course course1 = new Course("python");
			Course course2 = new Course("java");
			course1.addStudent(student);
			course2.addStudent(student);

			session.save(student);
			session.save(course1);
			session.save(course2);

//			Course course = session.get(Course.class, 3);
//			Course course = new Course("Pacman learning to code");
//			System.out.println("Save Course");
//			session.save(course);
//			Student student1 = new Student("Julia", "Path", "julia@gmail.com");
//			Student student2 = new Student("Jack", "Bal", "jack@gmail.com");
//			course.addStudent(student1);
//			course.addStudent(student2);
//			System.out.println("Save Students");
//			session.save(student1);
//			session.save(student2);
//			System.out.println("Saved Students" + course.getStudents());

//			System.out.println("Course :"+course);
//			System.out.println("Review: "+ course.getReviews());
//			Instructor instructor = session.get(Instructor.class, 5);
//			Course course = new Course("korea");
//			Course course2 = new Course("France");
//			instructor.add(course);
//			instructor.add(course2);


//			System.out.println("instructor : "+instructor);
//			System.out.println("course : "+instructor.getCourses());

//			Instructor instructor = new Instructor("Obama", "Barack", "Obama@gmail.com");
//			InstructorDetail instructorDetail = new InstructorDetail("https://Obama", "art");
//			instructor.setInstructorDetail(instructorDetail);
//
//			//save instructor
//			session.beginTransaction();
//			System.out.println("Save instructor");
//			session.save(instructor);

			//delete instructor
//			session.beginTransaction();
//			Instructor instructor = session.get(Instructor.class, 2);
//			System.out.println("Found" + instructor);
//			if (instructor != null){
//				System.out.println("Deleted");
//				session.delete(instructor);
//			}

			//get instructor_detail and Instructor
//			session.beginTransaction();
//			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 2);
//			System.out.println("InstructorDetail: "+instructorDetail);
//			System.out.println("Associate Instructor: "+instructorDetail.getInstructor());
//			System.out.println("Delete InstructorDetail");

			//delete
//			instructorDetail.getInstructor().setInstructorDetail(null);
//			session.delete(instructorDetail);

			session.getTransaction().commit();
			System.out.println("Done!");
		}catch (Exception exp){
			exp.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
