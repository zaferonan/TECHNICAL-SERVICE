package com.turkcell.TechnicalService.service.dtos.proposal.requests;

import com.turkcell.TechnicalService.model.ProposalState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProposalStateRequest {

	private long proposalId;
	
	private ProposalState proposalState;
}
