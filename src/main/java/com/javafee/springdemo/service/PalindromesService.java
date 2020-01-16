package com.javafee.springdemo.service;

import java.util.List;
import java.util.Set;

import com.javafee.springdemo.entity.Numerator;

public interface PalindromesService {
	List<Numerator> getNumber();

	List<Numerator> searchNumberByValue(int value);

	Numerator getNumberById(int id);

	void deleteNumber(Numerator number);

	void deleteNumberById(int id);

	void saveNumber(Numerator number);

	boolean checkNumberIsPalindrome(int nr);

	void checkNumberCorrectness(int value) throws NumberFormatException;

	Set<Numerator> generatePalindromesFromSpecificInterval(int interval[]);
}
