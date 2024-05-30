package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Poll;
import com.example.demo.repository.ChoiceRepository;
import com.example.demo.repository.PollRepository;

@Service
public class PollService {

	@Autowired
	private PollRepository pollRepository;

	@Autowired
	private ChoiceRepository choiceRepository;

	public List<Poll> getAllPolls() {
		return pollRepository.findAll();
	}

	public Poll createPoll(Poll poll) {
		poll.getChoices().forEach(choice -> choice.setPoll(poll));
		return pollRepository.save(poll);
	}

	public Poll getPoll(Long id) {
		return pollRepository.findById(id).orElse(null);
	}

	public void vote(Long pollId, Long choiceId) {
		choiceRepository.findById(choiceId).ifPresent(choice -> {
			choice.setVotes(choice.getVotes() + 1);
			choiceRepository.save(choice);
		});
	}

}