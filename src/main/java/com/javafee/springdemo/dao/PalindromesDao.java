package com.javafee.springdemo.dao;

import com.javafee.springdemo.entity.Numerator;

import java.util.List;

public interface PalindromesDao {

    List<Numerator> getNumbers();

    List<Numerator> searchNumbersByValue(int value);

    Numerator getNumberById(int id);

    void deleteNumber(Numerator number);

    void deleteNumberById(int id);

    void saveNumber(Numerator number);
}
