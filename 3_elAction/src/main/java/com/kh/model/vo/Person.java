package com.kh.model.vo;

public class Person {
	
	private String name;
	private int age;
	private String gendet;
	
	public Person() {
		
	}
	
	public Person(String name, int age, String gendet) {
		this.name = name;
		this.age = age;
		this.gendet = gendet;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGendet() {
		return gendet;
	}

	public void setGendet(String gendet) {
		this.gendet = gendet;
	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gendet=" + gendet + "]";
	}
	
	
	

}
