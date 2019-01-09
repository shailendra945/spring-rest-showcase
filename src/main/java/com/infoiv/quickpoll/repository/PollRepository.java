package com.infoiv.quickpoll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infoiv.quickpoll.domain.Poll;

public interface PollRepository extends JpaRepository<Poll, Long> {

}
