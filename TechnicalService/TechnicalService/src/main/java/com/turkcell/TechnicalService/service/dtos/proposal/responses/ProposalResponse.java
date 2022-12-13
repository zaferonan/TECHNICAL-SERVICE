package com.turkcell.TechnicalService.service.dtos.proposal.responses;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.turkcell.TechnicalService.model.ProposalState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProposalResponse {

	@JsonFormat(pattern = "dd.MM.yyyy")
	private LocalDate proposalDate;

	private long systemUserId;

	private String systemUserName;

	private long productId;

	private String productName;

	private double proposalPrice;

	private String proposalNote;

	private ProposalState proposalState;

}
