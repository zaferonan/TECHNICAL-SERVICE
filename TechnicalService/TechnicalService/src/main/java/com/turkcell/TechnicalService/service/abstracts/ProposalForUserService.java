package com.turkcell.TechnicalService.service.abstracts;

import java.util.List;
import java.util.Locale;

import com.turkcell.TechnicalService.core.utils.results.DataResult;
import com.turkcell.TechnicalService.service.dtos.proposal.requests.CreateProposalRequest;
import com.turkcell.TechnicalService.service.dtos.proposal.responses.ListProposalResponse;
import com.turkcell.TechnicalService.service.dtos.proposal.responses.ProposalResponse;

public interface ProposalForUserService {

	public DataResult<ProposalResponse> bid(CreateProposalRequest createProposalRequest,Locale locale);
	public DataResult<List<ListProposalResponse>> getBidsByUser(long systemUserId,Locale locale);
	public DataResult<ProposalResponse> delete(long proposalId,Locale locale);
	public DataResult<ProposalResponse> getById(long proposalId,Locale locale);
}
