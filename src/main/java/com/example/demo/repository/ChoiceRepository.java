package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Choice;

public interface ChoiceRepository extends JpaRepository<Choice, Long> {
}