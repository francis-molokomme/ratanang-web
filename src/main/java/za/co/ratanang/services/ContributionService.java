package za.co.ratanang.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import za.co.ratanang.entities.Contribution;

public interface ContributionService {
  Page<Contribution> getAllContributionsByMemberId(Long idNumber, Pageable pageable);

  Contribution insertContribution(Long idNumber, Contribution contributionDetails);

  Contribution updateContribution(
      Long idNumber, Long contributionId, Contribution contributionDetails);

  ResponseEntity<?> deleteContribution(Long idNumber, Long contributionId);
}
