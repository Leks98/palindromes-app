package com.javafee.springdemo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.javafee.springdemo.dao.PalindromesDao;
import com.javafee.springdemo.exception.NumberRangeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javafee.springdemo.entity.Numerator;

import javax.validation.OverridesAttribute;

@Service
public class PalindromesServiceImpl implements PalindromesService {
	@Autowired
	private PalindromesDao palindromesDao;

	@Transactional
	@Override
	public List<Numerator> getNumber() {
		return palindromesDao.getNumbers();
	}

	@Transactional
	@Override
	public List<Numerator> searchNumberByValue(int value) {
		return palindromesDao.searchNumbersByValue(value);
	}

	@Transactional
	@Override
	public Numerator getNumberById(int id) {
		return palindromesDao.getNumberById(id);
	}

	@Transactional
	@Override
	public void deleteNumber(Numerator number) {
		palindromesDao.deleteNumber(number);
	}

	@Transactional
	@Override
	public void deleteNumberById(int id) {
		palindromesDao.deleteNumberById(id);
	}

	@Transactional
	@Override
	public void saveNumber(Numerator number) {
		palindromesDao.saveNumber(number);
	}

	@Override
	public boolean checkNumberIsPalindrome(int nr) {
		int reverseNumber = 0;
		int tmp = nr;
		while (tmp != 0) {
			reverseNumber = reverseNumber * 10 + tmp % 10;
			tmp = tmp / 10;
		}
		return nr == reverseNumber;
	}

	@Override
	public void checkNumberCorrectness(int value) throws NumberRangeException {
		if (value < 0) {
			throw new NumberRangeException("The given number is incorrect because it's negative.");
		}
	}
	@Override
	public Set<Numerator> generatePalindromesFromSpecificInterval(int interval[]) {
		//generate all possibly combinations from specify interval, because interval is integer type it can't throw NumberFormatException
		Set<Numerator> nrs = new HashSet<>();
		for (int number = interval[0]; number <= interval[1]; number++) {
			//it doesn't use checkNumberCorrectness method from Number because, it's not present information about each value from interval =>
			//if it's palindrome or not but the result has to be the whole set of the numeric palindromes
			if (checkNumberIsPalindrome(number)) {
				Numerator n = new Numerator(0, number, null, true);
				nrs.add(n);
			}
		}
		return nrs;
	}
}
