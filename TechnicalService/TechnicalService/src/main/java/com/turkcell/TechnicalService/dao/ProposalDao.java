package com.turkcell.TechnicalService.dao;

import com.turkcell.TechnicalService.model.Proposal;
import com.turkcell.TechnicalService.model.ProposalState;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProposalDao extends JpaRepository<Proposal, Long>{

	List<Proposal> findAllBySystemUserSystemUserId(long systemUserId, Sort by);

	List<Proposal> findAllByProposalState(ProposalState proposalState, Sort by);

}
