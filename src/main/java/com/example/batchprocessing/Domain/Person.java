//package com.example.batchprocessing.Repositories;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
////@Table( name="Person",uniqueConstraints = @UniqueConstraint(columnNames = {"firstName"}))
//@Entity
//public class Person {
//
//	@Id
//	@GeneratedValue(strategy= GenerationType.AUTO)
//	private Long id;
//	private String lastName;
//	private String firstName;
//
//	protected Person() {}
//
//	public Person(String firstName, String lastName) {
//		this.firstName = firstName;
//		this.lastName = lastName;
//	}
//
//	public String Person() {
//		return String.format(
//				"Customer[id=%d, firstName='%s', lastName='%s']",
//				id, firstName, lastName);
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	@Override
//	public String toString() {
//		return "firstName: " + firstName + ", lastName: " + lastName;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//}
