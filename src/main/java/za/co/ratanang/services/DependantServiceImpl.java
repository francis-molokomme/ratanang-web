package za.co.ratanang.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.ratanang.repositories.DependantDao;
import za.co.ratanang.repositories.MemberDao;
import za.co.ratanang.entities.Dependant;
import za.co.ratanang.exceptions.ResourceNotFoundException;

@Service
public class DependantServiceImpl implements DependantService {

  @Autowired private DependantDao dependantDao;
  @Autowired private MemberDao memberDao;

  @Override
  public Page<Dependant> getAllDependantsByMemberId(Long idNumber, Pageable pageable) {
    return dependantDao.findByMemberIdNumber(idNumber, pageable);
  }

  @Override
  public Dependant insertDependant(Long idNumber, Dependant dependantDetails) {
    return memberDao
        .findById(idNumber)
        .map(
            member -> {
              dependantDetails.setMember(member);
              return dependantDao.save(dependantDetails);
            })
        .orElseThrow(() -> new ResourceNotFoundException("Member", "idNumber", idNumber));
  }

  @Override
  public Dependant updateDependant(
          Long idNumber, Long dependantNumber, Dependant dependantDetails) {
    if (!memberDao.existsById(idNumber)) {
      throw new ResourceNotFoundException("Member", "idNumber", idNumber);
    }
    return dependantDao
        .findById(dependantNumber)
        .map(
            dependant -> {
              dependant.setIdDependant(dependantDetails.getIdDependant());
              dependant.setDependantType(dependantDetails.getDependantType());
              dependant.setName(dependantDetails.getName());
              dependant.setSurname(dependantDetails.getSurname());
              return dependantDao.save(dependant);
            })
        .orElseThrow(
            () -> new ResourceNotFoundException("Dependant", "dependantNumber", dependantNumber));
  }

  @Override
  public ResponseEntity<?> deleteDependant(Long idNumber, Long dependantNumber) {
    if (!memberDao.existsById(idNumber)) {
      throw new ResourceNotFoundException("Member", "idNumber", idNumber);
    }
    return dependantDao
        .findById(dependantNumber)
        .map(
            dependant -> {
              dependantDao.delete(dependant);
              return ResponseEntity.ok().build();
            })
        .orElseThrow(
            () -> new ResourceNotFoundException("Dependant", "dependantNumber", dependantNumber));
  }
}
