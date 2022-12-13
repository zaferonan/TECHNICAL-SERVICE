package com.turkcell.TechnicalService.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turkcell.TechnicalService.model.Proposal;
import com.turkcell.TechnicalService.model.ProposalState;

@Repository
public interface ProposalDao extends JpaRepository<Proposal, Long>{

	List<Proposal> findAllBySystemUserSystemUserId(long systemUserId, Sort by);

	List<Proposal> findAllByProposalState(ProposalState proposalState, Sort by);

}
