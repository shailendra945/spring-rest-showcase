package com.infoiv.quickpoll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infoiv.quickpoll.domain.Option;

public interface OptionRepository extends JpaRepository<Option, Long> {

}
