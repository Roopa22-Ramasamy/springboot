package com.portalproblem.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student
{
         @Id
         private int StudentregNo;
         private String StudentCourse;
         private String StudentCourseId;
		public int getStudentregNo() {
			return StudentregNo;
		}
		public void setStudentregNo(int studentregNo) {
			StudentregNo = studentregNo;
		}
		public String getStudentCourse() {
			return StudentCourse;
		}
		public void setStudentCourse(String studentCourse) {
			StudentCourse = studentCourse;
		}
		public String getStudentCourseId() {
			return StudentCourseId;
		}
		public void setStudentCourseId(String studentCourseId) {
			StudentCourseId = studentCourseId;
		}
         
}
