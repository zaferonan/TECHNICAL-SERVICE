package com.turkcell.TechnicalService.service.dtos.proposal.responses;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.turkcell.TechnicalService.model.ProposalState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListProposalResponse {
		
	private long proposalId;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate proposalDate;
	
	private String systemUserName;

	private String productName;	
	
	private double proposalPrice;	
		
	private ProposalState proposalState;
}
