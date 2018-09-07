package za.co.ratanang.enumerations;

public enum DependantType {
  SPOUSE("SPOUSE"),
  CHILD("CHILD"),
  ADULT("ADULT");

  private String dependantType;

  DependantType(String dependantType) {
    this.dependantType = dependantType;
  }

  public String getDependantType() {
    return this.dependantType;
  }
}
