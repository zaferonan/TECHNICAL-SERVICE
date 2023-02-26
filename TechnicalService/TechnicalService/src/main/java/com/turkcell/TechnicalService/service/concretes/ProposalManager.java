package com.turkcell.TechnicalService.service.concretes;

import com.turkcell.TechnicalService.core.exceptions.BusinessException;
import com.turkcell.TechnicalService.core.utils.results.DataResult;
import com.turkcell.TechnicalService.core.utils.results.SuccessDataResult;
import com.turkcell.TechnicalService.dao.ProposalDao;
import com.turkcell.TechnicalService.model.Proposal;
import com.turkcell.TechnicalService.model.ProposalState;
import com.turkcell.TechnicalService.service.abstracts.ProposalService;
import com.turkcell.TechnicalService.service.dtos.proposal.requests.UpdateProposalStateRequest;
import com.turkcell.TechnicalService.service.dtos.proposal.responses.ListProposalResponse;
import com.turkcell.TechnicalService.service.dtos.proposal.responses.ProposalResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.EnumUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class ProposalManager implements ProposalService {

	private final ProposalDao proposalDao;
	private final MessageSource messageSource;

	@Override
	public DataResult<List<ListProposalResponse>> getBids(Locale locale) {
		List<Proposal> proposals = proposalDao.findAll(Sort.by(Direction.ASC, "proposalId"));
		List<ListProposalResponse> listProposalResponses = new ArrayList<ListProposalResponse>();
		for (Proposal proposal : proposals) {
			ListProposalResponse listProposalResponse = new ListProposalResponse();
			listProposalResponse.setProposalId(proposal.getProposalId());
			listProposalResponse.setProductName(proposal.getProduct().getProductName());
			listProposalResponse.setSystemUserName(proposal.getSystemUser().getName());
			listProposalResponse.setProposalPrice(proposal.getProposalPrice());
			listProposalResponse.setProposalDate(proposal.getProposalDate());
			listProposalResponse.setProposalState(proposal.getProposalState());

			listProposalResponses.add(listProposalResponse);
		}

		return new SuccessDataResult<List<ListProposalResponse>>(listProposalResponses,
				messageSource.getMessage("proposal.getBids.success", null, locale));
	}

	@Override
	public DataResult<List<ListProposalResponse>> getBidsByUser(long systemUserId, Locale locale) {
		List<Proposal> proposals = proposalDao.findAllBySystemUserSystemUserId(systemUserId,
				Sort.by(Direction.ASC, "proposalId"));
		List<ListProposalResponse> listProposalResponses = new ArrayList<ListProposalResponse>();
		for (Proposal proposal : proposals) {
			ListProposalResponse listProposalResponse = new ListProposalResponse();
			listProposalResponse.setProposalId(proposal.getProposalId());
			listProposalResponse.setProductName(proposal.getProduct().getProductName());
			listProposalResponse.setSystemUserName(proposal.getSystemUser().getName());
			listProposalResponse.setProposalPrice(proposal.getProposalPrice());
			listProposalResponse.setProposalDate(proposal.getProposalDate());
			listProposalResponse.setProposalState(proposal.getProposalState());

			listProposalResponses.add(listProposalResponse);
		}

		return new SuccessDataResult<List<ListProposalResponse>>(listProposalResponses,
				messageSource.getMessage("proposal.getBidsByUser.success", null, locale));
	}

	@Override
	public DataResult<List<ListProposalResponse>> getBidsByState(String proposalState, Locale locale) {
		checkProposalStateIsValid(proposalState,locale);
		List<Proposal> proposals = proposalDao.findAllByProposalState(EnumUtils.findEnumInsensitiveCase(ProposalState.class, proposalState),
				Sort.by(Direction.ASC, "proposalId"));
		List<ListProposalResponse> listProposalResponses = new ArrayList<ListProposalResponse>();
		for (Proposal proposal : proposals) {
			ListProposalResponse listProposalResponse = new ListProposalResponse();
			listProposalResponse.setProposalId(proposal.getProposalId());
			listProposalResponse.setProductName(proposal.getProduct().getProductName());
			listProposalResponse.setSystemUserName(proposal.getSystemUser().getName());
			listProposalResponse.setProposalPrice(proposal.getProposalPrice());
			listProposalResponse.setProposalDate(proposal.getProposalDate());
			listProposalResponse.setProposalState(proposal.getProposalState());

			listProposalResponses.add(listProposalResponse);
		}

		return new SuccessDataResult<List<ListProposalResponse>>(listProposalResponses,
				messageSource.getMessage("proposal.getBidsByState.success", null, locale));
	}

	@Override
	public DataResult<ProposalResponse> getById(long proposalId, Locale locale) {
		checkProposalIdExists(proposalId, locale);
		Proposal proposal = proposalDao.findById(proposalId).get();
		ProposalResponse proposalResponse=new ProposalResponse();
		proposalResponse.setProductId(proposal.getProduct().getProductId());
		proposalResponse.setProductName(proposal.getProduct().getProductName());
		proposalResponse.setSystemUserId(proposal.getSystemUser().getSystemUserId());
		proposalResponse.setSystemUserName(proposal.getSystemUser().getName());
		proposalResponse.setProposalDate(proposal.getProposalDate());
		proposalResponse.setProposalPrice(proposal.getProposalPrice());
		proposalResponse.setProposalNote(proposal.getProposalNote());
		proposalResponse.setProposalState(proposal.getProposalState());
		
		return new SuccessDataResult<ProposalResponse>(proposalResponse,
				messageSource.getMessage("proposal.getById.success", null, locale));
	}

	@Override
	public DataResult<ProposalResponse> changeBidState(UpdateProposalStateRequest updateProposalStateRequest, Locale locale) {
		checkProposalIdExists(updateProposalStateRequest.getProposalId(), locale);
		checkProposalStateIsValid(updateProposalStateRequest.getProposalState(),locale);
		Proposal proposal=proposalDao.findById(updateProposalStateRequest.getProposalId()).get();
		proposal.setProposalState(EnumUtils.findEnumInsensitiveCase(ProposalState.class,updateProposalStateRequest.getProposalState()));
		
		proposalDao.save(proposal);
		
		ProposalResponse proposalResponse=new ProposalResponse();
		proposalResponse.setProductId(proposal.getProduct().getProductId());
		proposalResponse.setProductName(proposal.getProduct().getProductName());
		proposalResponse.setSystemUserId(proposal.getSystemUser().getSystemUserId());
		proposalResponse.setSystemUserName(proposal.getSystemUser().getName());
		proposalResponse.setProposalDate(proposal.getProposalDate());
		proposalResponse.setProposalPrice(proposal.getProposalPrice());
		proposalResponse.setProposalNote(proposal.getProposalNote());
		proposalResponse.setProposalState(proposal.getProposalState());
		
		return new SuccessDataResult<ProposalResponse>(proposalResponse,
				messageSource.getMessage("proposal.changeBidState.success",new Object[] {proposal.getProposalState().toString()}, locale));
		
		
	}

	private void checkProposalStateIsValid(String state, Locale locale) {
		try {
			EnumUtils.findEnumInsensitiveCase(ProposalState.class, state);
		} catch (IllegalArgumentException e) {
			throw new BusinessException(messageSource.getMessage("proposal.checkProposalStateIsValid.error",new Object[] {state,ProposalState.PENDING,ProposalState.DENIED,ProposalState.APPROVED}, locale));
		}
		
		
	}

	private void checkProposalIdExists(long proposalId, Locale locale) {
		if (!proposalDao.existsById(proposalId)) {
			throw new BusinessException(
					messageSource.getMessage("proposal.checkproposalid.error", new Object[] {proposalId}, locale));
		}

	}
}
