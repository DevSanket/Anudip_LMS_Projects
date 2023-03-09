package com.sanketscode.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="student_details")
public class Student {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		
		@Column(name="stu_name")
		private String stu_name;
		
		@Column(name="stu_phone")
		private long stu_phone;
		
		@Column(name="stu_email")
		private String stu_email;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getStu_name() {
			return stu_name;
		}

		public void setStu_name(String stu_name) {
			this.stu_name = stu_name;
		}

		public long getStu_phone() {
			return stu_phone;
		}

		public void setStu_phone(long stu_phone) {
			this.stu_phone = stu_phone;
		}

		public String getStu_email() {
			return stu_email;
		}

		public void setStu_email(String stu_email) {
			this.stu_email = stu_email;
		}
		
		
		
		
		
}
