package fr.epita.titanic.model;

public class PassengerDetails {
	
	private Integer survived;
	private Integer pClass;
	private String name;
	private String gender;
	private Integer genderIdx;
	private Double age;
	private Integer noOfSiblingSpouses;
	private Integer noOfParentChildren;
	private Double fare;
	public Integer getSurvived() {
		return survived;
	}
	public void setSurvived(Integer survived) {
		this.survived = survived;
	}
	public Integer getpClass() {
		return pClass;
	}
	public void setpClass(Integer pClass) {
		this.pClass = pClass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Double getAge() {
		return age;
	}
	public void setAge(Double age) {
		this.age = age;
	}
	public Integer getNoOfSiblingSpouses() {
		return noOfSiblingSpouses;
	}
	public void setNoOfSiblingSpouses(Integer noOfSiblingSpouses) {
		this.noOfSiblingSpouses = noOfSiblingSpouses;
	}
	public Integer getNoOfParentChildren() {
		return noOfParentChildren;
	}
	public void setNoOfParentChildren(Integer noOfParentChildren) {
		this.noOfParentChildren = noOfParentChildren;
	}
	public Double getFare() {
		return fare;
	}
	public void setFare(Double fare) {
		this.fare = fare;
	}
	public Integer getGenderIdx() {
		return genderIdx;
	}
	public void setGenderIdx(Integer genderIdx) {
		this.genderIdx = genderIdx;
	}
	
	


}
