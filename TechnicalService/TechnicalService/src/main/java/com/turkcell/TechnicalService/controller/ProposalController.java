package com.turkcell.TechnicalService.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.TechnicalService.core.utils.results.DataResult;
import com.turkcell.TechnicalService.service.abstracts.ProposalService;
import com.turkcell.TechnicalService.service.dtos.proposal.requests.UpdateProposalStateRequest;
import com.turkcell.TechnicalService.service.dtos.proposal.responses.ListProposalResponse;
import com.turkcell.TechnicalService.service.dtos.proposal.responses.ProposalResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/admin/proposal")
@RequiredArgsConstructor
public class ProposalController {
	
	private final ProposalService proposalService;

	@GetMapping("/getBids")
	public DataResult<List<ListProposalResponse>> getBids(Locale locale){
		return proposalService.getBids(locale);
	}
	@GetMapping("/getBidsByUser")
	public DataResult<List<ListProposalResponse>> getBidsByUser(@RequestParam long systemUserId,Locale locale){
		return proposalService.getBidsByUser(systemUserId, locale);
	}
	@GetMapping("/getBidsByState")
	public DataResult<List<ListProposalResponse>> getBidsByState(@RequestParam String proposalState,Locale locale){
		return proposalService.getBidsByState(proposalState, locale);
	}
	@GetMapping("/getBidsById")
	public DataResult<ProposalResponse> getById(@RequestParam long proposalId,Locale locale){
		return proposalService.getById(proposalId, locale);
	}
	@PostMapping("/changeBidState")
	public DataResult<ProposalResponse> changeBidState(@RequestBody UpdateProposalStateRequest updateProposalStateRequest,Locale locale){
		return proposalService.changeBidState(updateProposalStateRequest, locale);
	}
}
