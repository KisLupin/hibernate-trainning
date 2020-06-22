package com.example.demo;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import com.example.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DemoApplication {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try{
			session.beginTransaction();
//			Course course = session.get(Course.class, 3);
			Course course = session.get(Course.class, 5);
			System.out.println("Delete the course");
			session.delete(course);

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
