package za.co.ratanang.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.ratanang.entities.Dependant;
import za.co.ratanang.services.DependantService;

import javax.validation.Valid;

@RestController
@RequestMapping("/dependants")
public class DependantController {

  @Autowired private DependantService dependantService;

  /**
   * getAllDependantsByMemberId method.
   *
   * @param idNumber value
   * @param pageable value
   * @return Page<Dependant> object
   */
  @GetMapping("/{idNumber}/all")
  public Page<Dependant> getAllDependantsByMemberId(
      @PathVariable(value = "idNumber") Long idNumber, Pageable pageable) {
    return dependantService.getAllDependantsByMemberId(idNumber, pageable);
  }

  @PostMapping("/{idNumber}/insert")
  public Dependant insertDependant(
      @PathVariable(value = "idNumber") Long idNumber,
      @Valid @RequestBody Dependant dependantDetails) {
    return dependantService.insertDependant(idNumber, dependantDetails);
  }

  @PutMapping("/{idNumber}/update/{dependantNumber}")
  public Dependant updateDependant(
      @PathVariable(value = "idNumber") Long idNumber,
      @PathVariable(value = "dependantNumber") Long dependantNumber,
      @Valid @RequestBody Dependant dependantDetails) {
    return dependantService.updateDependant(idNumber, dependantNumber, dependantDetails);
  }

  @DeleteMapping("/{idNumber}/delete/{dependantNumber}")
  public ResponseEntity<?> deleteDependant(
      @PathVariable(value = "idNumber") Long idNumber,
      @PathVariable(value = "dependantNumber") Long dependantNumber) {
    return dependantService.deleteDependant(idNumber, dependantNumber);
  }
}
