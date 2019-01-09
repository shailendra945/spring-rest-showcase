package com.infoiv.quickpoll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infoiv.quickpoll.domain.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {

}
