package com.turkcell.TechnicalService.service.dtos.proposal.responses;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.turkcell.TechnicalService.model.ProposalState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListProposalResponse {
		
	private long proposalId;
	
	@JsonFormat(pattern = "dd.MM.yyyy - HH:mm")
	private LocalDateTime proposalDate;
	
	private String systemUserName;

	private String productName;	
	
	private double proposalPrice;	
		
	private ProposalState proposalState;
}
