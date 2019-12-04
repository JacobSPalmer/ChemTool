//This is an extension of class molecule that utilizes different attributes associated with nonpolar molecules
//The nonpolar molecules class is utilized in the newNonolarFrame class of the GUI

public class nonpolar extends molecule{

	public String physicalState = null;
	public double boilingPoint;
	public double meltingPoint;
	public double dipoleMoment;
	public double electronegativity;
	
	public nonpolar(String otherMolecularFormula, String otherIUPAC, double othermolecularWeight) {
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
	
	public void setDipoleMoment(double otherDipoleMoment) {
		dipoleMoment = otherDipoleMoment;
	}
	
	public void setElectronegativity(double otherElectronegativty) {
		electronegativity = otherElectronegativty;
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
	
	public double getDipoleMoment() {
		return dipoleMoment;
	}
	
	public double getElectronegativity() {
		return electronegativity;
	}
	
	public String toString() {
		String statement = "IUPAC Name: " + IUPAC + "\n" + "Molecular Formula: " + molecularFormula + "\n" + "Molecular Weight: " + molecularWeight + "\n";
		statement += "Melting Point (C): " + meltingPoint + "\n";
		statement += "Boiling Point (C): " + boilingPoint + "\n";
		statement += "Dipole Moment: " + dipoleMoment + "\n";
		statement += "Electronegativity: " + electronegativity + "\n";
		statement += "Physical State: " + physicalState + "\n";
		statement += "Molecule Type: Non-Polar";
		return statement;
	}
}

