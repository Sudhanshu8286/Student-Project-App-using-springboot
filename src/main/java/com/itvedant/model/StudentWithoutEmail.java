package com.itvedant.model;

import org.springframework.beans.factory.annotation.Value;

public interface StudentWithoutEmail {
	String getName();
	Double getAggregate();
	
	@Value("#{target.name}" +" has scored " + "#{target.aggregate}")
	String getResult();
}
