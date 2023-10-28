package com.example.demo.repositories;

import com.example.demo.model.CashCard;
import org.springframework.data.repository.CrudRepository;

/**
 * CrudRepository<CashCard, Long> - посочва че CashCardRepository ще менажира CashCard данни и ,че ID-то на CashCard е от тип Long
 * Имплементацията ще се генерира при стартирането на IoC контейнера и (Sprint Runtime) ще я добави като bean ,за да може да се извиква където е нужно
 */
public interface CashCardRepository extends CrudRepository<CashCard, Long> {
}
