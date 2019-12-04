//This is an extension of class molecule that utilizes different attributes associated with polar molecules
//The polar molecules class is utilized in the newPolarFrame class of the GUI

public class polar extends molecule{

	public String physicalState;
	public double electronegativity;
	public double solubility;
	public double boilingPoint;
	public double meltingPoint;
	public String conductElectricity;
	
	public polar(String otherMolecularFormula, String otherIUPAC, double othermolecularWeight) {
		super(otherMolecularFormula, otherIUPAC, othermolecularWeight);
	}
	
	public void setPhysicalState(String otherPhysicalState){
		physicalState = otherPhysicalState;
	}
	
	public void setBoilingPoint(double otherBoilingPoint) {
		boilingPoint = otherBoilingPoint;
	}
	
	public void setMeltingPoint(double otherMeltingPoint) {
		meltingPoint = otherMeltingPoint;
	}
	
	public void setElectronegativity(double otherElectronegativty) {
		electronegativity = otherElectronegativty;
	}
	
	public void setSolubility(double otherSolubility) {
		solubility = otherSolubility;
	}
	
	public void conductElectricity(String conduct) {
		conductElectricity = conduct;
	}
	
	public String getphysicalState(){
		return physicalState;
	}
	
	public double getBoilingPoint() {
		return boilingPoint;
	}
	
	public double getMeltingPoint() {
		return meltingPoint;
	}
	
	public double getElectronegativity() {
		return electronegativity;
	}
	
	public double getSolubility() {
		return solubility;
	}
	
	public String isConducive() {
		return conductElectricity;
	}
	
	@Override
	public String toString() {
		String statement = "IUPAC Name: " + IUPAC + "\n" + "Molecular Formula: " + molecularFormula + "\n" + "Molecular Weight: " + molecularWeight + "\n";
		statement += "Melting Point (C): " + meltingPoint + "\n";
		statement += "Boiling Point (C): " + boilingPoint + "\n";
		statement += "Electronegativity: " + electronegativity + "\n";
		statement += "Physical State: " + physicalState + "\n";
		statement += "Solubility: " + solubility + "\n";
		statement += "Conduct Electricity: " + conductElectricity + "\n";
		statement += "Molecule Type: Polar";
		return statement;
	}
}