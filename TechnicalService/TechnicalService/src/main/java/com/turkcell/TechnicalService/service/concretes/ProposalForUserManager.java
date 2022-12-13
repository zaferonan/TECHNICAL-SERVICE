package com.turkcell.TechnicalService.service.concretes;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

import com.turkcell.TechnicalService.core.utils.results.DataResult;
import com.turkcell.TechnicalService.dao.ProposalDao;
import com.turkcell.TechnicalService.service.abstracts.ProposalForUserService;
import com.turkcell.TechnicalService.service.dtos.proposal.requests.CreateProposalRequest;
import com.turkcell.TechnicalService.service.dtos.proposal.responses.ListProposalResponse;
import com.turkcell.TechnicalService.service.dtos.proposal.responses.ProposalResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProposalForUserManager implements ProposalForUserService {

	private final ProposalDao proposalDao;

	@Override
	public DataResult<ProposalResponse> bid(CreateProposalRequest createProposalRequest, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<ListProposalResponse>> getBidsByUser(long systemUserId, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<ProposalResponse> delete(long proposalId, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<ProposalResponse> getById(long proposalId, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}
}
