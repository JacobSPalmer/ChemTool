//This is a class that setups the generic molecular attributes that is utilized in the ion, non-polar, and polar subclasses

public class molecule {
	
	public String molecularFormula;
	public String IUPAC;
	public double molecularWeight;

	
	public molecule(String otherIUPAC, String otherMolecularFormula, double othermolecularWeight) {
		molecularFormula = otherMolecularFormula;
		IUPAC = otherIUPAC;
		molecularWeight = othermolecularWeight;
	}

	public void setMolecularFormula(String otherFormula){
		molecularFormula = otherFormula;
	}
	
	public void setIUPAC(String otherString) {
		IUPAC = otherString;
	}
	
	public void setMolecularWeight(double otherDouble) {
		molecularWeight = otherDouble;
	}
	
	public String getMolecularFormula() {
		return molecularFormula;
	}
	
	public String getIUPAC() {
		return IUPAC;
	}
	
	public double getMolecularWeight() {
		return molecularWeight;
	}

	@Override
	public String toString() {
		String statement = "IUPAC Name: " + IUPAC + "\n" + "Molecular Formula: " + molecularFormula + "\n" + "Molecular Weight: " + molecularWeight;
		return statement;
	}
}
