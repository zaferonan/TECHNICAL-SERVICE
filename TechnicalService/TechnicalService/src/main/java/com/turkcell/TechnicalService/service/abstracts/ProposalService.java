package com.turkcell.TechnicalService.service.abstracts;

import java.util.List;
import java.util.Locale;

import com.turkcell.TechnicalService.core.utils.results.DataResult;
import com.turkcell.TechnicalService.model.ProposalState;
import com.turkcell.TechnicalService.service.dtos.proposal.requests.UpdateProposalStateRequest;
import com.turkcell.TechnicalService.service.dtos.proposal.responses.ListProposalResponse;
import com.turkcell.TechnicalService.service.dtos.proposal.responses.ProposalResponse;

public interface ProposalService {

	public DataResult<List<ListProposalResponse>> getBids(Locale locale);
	public DataResult<List<ListProposalResponse>> getBidsByUser(long systemUserId,Locale locale);
	public DataResult<List<ListProposalResponse>> getBidsByState(ProposalState proposalState,Locale locale);
	public DataResult<ProposalResponse> getById(long proposalId,Locale locale);
	public DataResult<ProposalResponse> changeBidState(UpdateProposalStateRequest updateProposalStateRequest,Locale locale);
}
