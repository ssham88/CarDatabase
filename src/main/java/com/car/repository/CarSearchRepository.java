package com.car.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.car.model.Car;

@Repository
public class CarSearchRepository {
	@Autowired
	MongoTemplate mongoTemplate;

	public Collection<Car> searchCars(String text) {
		Query q = new Query();
		Criteria c = new Criteria();
		c.orOperator(Criteria.where("description").regex(text),
				Criteria.where("make").regex(text),
				Criteria.where("model").regex(text));
		return mongoTemplate.find(q.addCriteria(c), Car.class);
	}
}
