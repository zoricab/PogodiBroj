package classes;

import java.util.Random;

import enums.Stanje;
import interfaces.IOperations;

public class PogodiBroj implements IOperations{

	protected int gornjaGr;
	protected int uneseniBr;
	protected int trazeniBr;
	protected Stanje stanje;
	protected int brDozGreski;
	protected boolean terminirajProgram;
	protected int brTrenGreski;
	
	public PogodiBroj ()
	{
		this.gornjaGr = 0;	
		this.brTrenGreski = 0;
		this.stanje = Stanje.sManji;
		this.trazeniBr = 0;
		//Random rnd = new Random();
		//this.trazeniBr = rnd.nextInt(this.gornjaGr)+1;
		this.brDozGreski = 0;
				
		this.terminirajProgram = false;
		
		
	}
	
	protected void GenerisiBroj()
	{
		Random rnd = new Random();
		this.trazeniBr = rnd.nextInt(this.gornjaGr)+1;
		this.brDozGreski = (this.trazeniBr/5)+5;
	}

	public int getBrTrenGreski() {
		return brTrenGreski;
	}

	public void setBrTrenGreski(int brTrenGreski) {
		this.brTrenGreski = brTrenGreski;
	}

	public boolean isTerminirajProgram() {
		return terminirajProgram;
	}

	public void setTerminirajProgram(boolean terminirajProgram) {
		this.terminirajProgram = terminirajProgram;
	}

	public int getGornjaGr() {
		return gornjaGr;
	}

	public void setGornjaGr(int gornjaGr) {
		this.gornjaGr = gornjaGr;
		this.GenerisiBroj();
	}

	public int getUneseniBr() {
		return uneseniBr;
	}

	public void setUneseniBr(int uneseniBr) {
		this.uneseniBr = uneseniBr;
	}

	public int getTrazeniBr() {
		return trazeniBr;
	}

	public void setTrazeniBr(int trazeniBr) {
		this.trazeniBr = trazeniBr;
	}

	public Stanje getStanje() {
		return stanje;
	}

	public void setStanje(Stanje stanje) {
		this.stanje = stanje;
	}

	public int getBrDozGreski() {
		return brDozGreski;
	}

	public void setBrDozGreski(int brDozGreski) {
		this.brDozGreski = brDozGreski;
	}
	
	@Override
	public Stanje Validacija(int unetiBroj) {
		
		this.uneseniBr = unetiBroj;
		
		if (this.trazeniBr == this.uneseniBr)
		{
			this.stanje = Stanje.sPogodjen;
			this.terminirajProgram = true;	
		}else{	
			if(this.trazeniBr > this.uneseniBr)
				this.stanje = Stanje.sVeci;
				else this.stanje = Stanje.sManji;
					this.brTrenGreski++;
					
		}	
		
		if(this.brDozGreski == this.brTrenGreski)
			
			this.terminirajProgram = true;
		
		return this.stanje;
	}
	
}
