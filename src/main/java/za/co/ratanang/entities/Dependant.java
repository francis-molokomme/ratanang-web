package za.co.ratanang.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "dependant")
public class Dependant extends Audit {

  @Id private Long idDependant;

  @NotNull
  private String dependantType;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_number", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
  private Member member;

  public Long getIdDependant() {
    return idDependant;
  }

  public void setIdDependant(Long idDependant) {
    this.idDependant = idDependant;
  }

  public String getDependantType() {
    return dependantType;
  }

  public void setDependantType(String dependantType) {
    this.dependantType = dependantType;
  }

  public Member getMember() {
    return member;
  }

  public void setMember(Member member) {
    this.member = member;
  }
}
