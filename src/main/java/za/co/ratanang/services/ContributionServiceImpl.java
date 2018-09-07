package za.co.ratanang.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.ratanang.entities.Contribution;
import za.co.ratanang.exceptions.ResourceNotFoundException;
import za.co.ratanang.repositories.ContributionDao;
import za.co.ratanang.repositories.MemberDao;

@Service
public class ContributionServiceImpl implements ContributionService {

  @Autowired private MemberDao memberDao;
  @Autowired private ContributionDao contributionDao;

  @Override
  public Page<Contribution> getAllContributionsByMemberId(Long idNumber, Pageable pageable) {
    return contributionDao.findByMemberIdNumber(idNumber, pageable);
  }

  @Override
  public Contribution insertContribution(Long idNumber, Contribution contributionDetails) {
    return memberDao
        .findById(idNumber)
        .map(
            member -> {
              contributionDetails.setMember(member);
              return contributionDao.save(contributionDetails);
            })
        .orElseThrow(() -> new ResourceNotFoundException("Member", "idNumber", idNumber));
  }

  @Override
  public Contribution updateContribution(
          Long idNumber, Long contributionId, Contribution contributionDetails) {
    if (!memberDao.existsById(idNumber)) {
      throw new ResourceNotFoundException("Member", "idNumber", idNumber);
    }
    return contributionDao
        .findById(contributionId)
        .map(
            contribution -> {
              contribution.setContributionId(contributionDetails.getContributionId());
              contribution.setContributionPeriod(contributionDetails.getContributionPeriod());
              contribution.setMonthlyContribution(contributionDetails.getMonthlyContribution());
              contribution.setFineContribution(contributionDetails.getFineContribution());
              contribution.setCandleContribution(contributionDetails.getCandleContribution());
              contribution.setTransportContribution(contributionDetails.getTransportContribution());
              contribution.setFundingContribution(contributionDetails.getFundingContribution());
              contribution.setJoiningContribution(contributionDetails.getJoiningContribution());
              contribution.setTotalContribution(contributionDetails.getTotalContribution());
              return contributionDao.save(contribution);
            })
        .orElseThrow(
            () -> new ResourceNotFoundException("Contribution", "contributionId", contributionId));
  }

  @Override
  public ResponseEntity<?> deleteContribution(Long idNumber, Long contributionId) {
    if (!memberDao.existsById(idNumber)) {
      throw new ResourceNotFoundException("Member", "idNumber", idNumber);
    }
    return contributionDao
        .findById(contributionId)
        .map(
            contribution -> {
              contributionDao.delete(contribution);
              return ResponseEntity.ok().build();
            })
        .orElseThrow(
            () -> new ResourceNotFoundException("Contribution", "contributionId", contributionId));
  }
}
