package com.turkcell.TechnicalService.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.TechnicalService.core.utils.results.DataResult;
import com.turkcell.TechnicalService.service.abstracts.ProposalForUserService;
import com.turkcell.TechnicalService.service.dtos.proposal.requests.CreateProposalRequest;
import com.turkcell.TechnicalService.service.dtos.proposal.responses.ListProposalResponse;
import com.turkcell.TechnicalService.service.dtos.proposal.responses.ProposalResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("proposal")
@RequiredArgsConstructor
public class ProposalForUserConroller {

	private final ProposalForUserService proposalForUserService;
	
	@PostMapping("bid")
	public DataResult<ProposalResponse> bid(@RequestBody CreateProposalRequest createProposalRequest,Locale locale){
		return proposalForUserService.bid(createProposalRequest, locale);
	}
	@GetMapping("/getBidsByUser")
	public DataResult<List<ListProposalResponse>> getBidsByUser(long systemUserId,Locale locale){
		return proposalForUserService.getBidsByUser(systemUserId, locale);
	}
	@DeleteMapping("/delete")
	public DataResult<ProposalResponse> delete(long proposalId,Locale locale){
		return proposalForUserService.delete(proposalId, locale);
	}
	@GetMapping("/getById")
	public DataResult<ProposalResponse> getById(long proposalId,Locale locale){
		return proposalForUserService.getById(proposalId, locale);
	}
}
