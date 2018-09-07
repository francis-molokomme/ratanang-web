package za.co.ratanang.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import za.co.ratanang.entities.Dependant;

public interface DependantService {
    Page<Dependant> getAllDependantsByMemberId(Long idNumber, Pageable pageable);

    Dependant insertDependant(Long idNumber, Dependant dependantDetails);

    Dependant updateDependant(
            Long idNumber, Long dependantNumber, Dependant dependantDetails);

    ResponseEntity<?> deleteDependant(Long idNumber, Long dependantNumber);
}
