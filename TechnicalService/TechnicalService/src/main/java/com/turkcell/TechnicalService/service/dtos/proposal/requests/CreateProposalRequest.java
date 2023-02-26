package com.turkcell.TechnicalService.service.dtos.proposal.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProposalRequest {
		
	private long productId;	
	
	private long systemUserId;
	
	private double proposalPrice;
	
	@Size(max=300)
	private String proposalNote;
	
	
		
}
