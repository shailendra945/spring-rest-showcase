package com.infoiv.quickpoll.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.infoiv.quickpoll.domain.Poll;
import com.infoiv.quickpoll.repository.PollRepository;

@RestController
public class PollController {
	
	@Autowired
	private PollRepository pollRepository;
	
	@RequestMapping(value="/polls",method=RequestMethod.GET)
	public ResponseEntity<Iterable<Poll>> getAllPolls(){
		Iterable<Poll> polls=this.pollRepository.findAll();
		return new ResponseEntity<>(polls,HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value="/polls" ,method=RequestMethod.POST)
	public ResponseEntity<?> createPoll(@RequestBody Poll poll){
		if(poll!=null)
		poll=this.pollRepository.save(poll);
		else
			return new ResponseEntity<>("Poll cann't be created as some problem with request data",HttpStatus.BAD_REQUEST);
		
		URI newPollUri=ServletUriComponentsBuilder.fromCurrentRequest()
												  .path("/{id}")
												  .buildAndExpand(poll.getId())
												  .toUri();
		HttpHeaders responseHeaders=new HttpHeaders();
		responseHeaders.setLocation(newPollUri);
		return new ResponseEntity<>(null,responseHeaders,HttpStatus.OK);
	}
	
	@RequestMapping(value="/polls/{pollId}")
	public ResponseEntity<?> getPoll(@PathVariable Long pollId){
		Poll poll=this.pollRepository.findById(pollId).get();
		return new ResponseEntity<>(poll,HttpStatus.OK);
	}
	
	@RequestMapping(value="/polls/{pollId}" ,method=RequestMethod.PUT)
	public ResponseEntity<?> updatePoll(@RequestBody Poll poll,@PathVariable Long pollId){
		Poll poll1=this.pollRepository.findById(pollId).get();
		if(poll1!=null)
		poll=this.pollRepository.save(poll);
		else
			return new ResponseEntity<>("Poll cann't be updated as some problem with request data",HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(null,HttpStatus.OK);
	}
	
	@RequestMapping(value="/polls/{pollId}" ,method=RequestMethod.DELETE)
	public ResponseEntity<?> updatePoll(@PathVariable Long pollId){
		this.pollRepository.deleteById(pollId);
		return new ResponseEntity<>(null,HttpStatus.OK);
	}

}
