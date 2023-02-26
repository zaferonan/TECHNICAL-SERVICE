package com.turkcell.TechnicalService.service.abstracts;

import com.turkcell.TechnicalService.core.utils.results.DataResult;
import com.turkcell.TechnicalService.service.dtos.proposal.requests.UpdateProposalStateRequest;
import com.turkcell.TechnicalService.service.dtos.proposal.responses.ListProposalResponse;
import com.turkcell.TechnicalService.service.dtos.proposal.responses.ProposalResponse;

import java.util.List;
import java.util.Locale;

public interface ProposalService {

	public DataResult<List<ListProposalResponse>> getBids(Locale locale);
	public DataResult<List<ListProposalResponse>> getBidsByUser(long systemUserId,Locale locale);
	public DataResult<List<ListProposalResponse>> getBidsByState(String proposalState,Locale locale);
	public DataResult<ProposalResponse> getById(long proposalId,Locale locale);
	public DataResult<ProposalResponse> changeBidState(UpdateProposalStateRequest updateProposalStateRequest,Locale locale);
}
