package za.co.ratanang.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.ratanang.entities.Contribution;

@Repository
public interface ContributionDao extends JpaRepository<Contribution, Long> {
  Page<Contribution> findByMemberIdNumber(Long idNumber, Pageable pageable);
}
