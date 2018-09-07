package za.co.ratanang.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.ratanang.entities.Dependant;

@Repository
public interface DependantDao extends JpaRepository<Dependant, Long> {
    Page<Dependant> findByMemberIdNumber(Long idNumber, Pageable pageable);
}
