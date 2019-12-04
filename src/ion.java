//This is an extension of class molecule that utilizes different attributes associated with ionic molecules
//The ion molecules class is utilized in the newIonFrame class of the GUI

public class ion extends molecule{
	
	public double meltingPoint;
	public double solubility;
	public String physicalState;

	public ion(String otherMolecularFormula, String otherIUPAC, double othermolecularWeight) {
		super(otherMolecularFormula, otherIUPAC, othermolecularWeight);
	}
	
	public double getMeltingPoint() {
		return meltingPoint;
	}
	
	public double getSolubility() {
		return solubility;
	}

	public void setMeltingPoint(double otherMeltingPoint) {
		meltingPoint = otherMeltingPoint;
	}
	
	public void setSolubility(double otherSolubility) {
		solubility = otherSolubility;
	}
	
	public void setPhysicalState(String otherPhysicalState) {
		physicalState = otherPhysicalState;
	}
	
	@Override
	public String toString() {
		String statement = "IUPAC Name: " + IUPAC + "\n" + "Molecular Formula: " + molecularFormula + "\n" + "Molecular Weight: " + molecularWeight + "\n";
		statement += "Melting Point: " + meltingPoint + "\n";
		statement += "Solubility: " + solubility + "\n";
		statement += "Physical State: " + physicalState + "\n";
		statement += "Molecule Type: Ionic";
		return statement;
	}
}
