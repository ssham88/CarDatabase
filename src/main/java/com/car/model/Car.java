package com.car.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Cars")
public class Car {
	
private String id;
private String make;
private String model;
private String description;

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getMake() {
	return make;
}
public void setMake(String make) {
	this.make = make;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

}
