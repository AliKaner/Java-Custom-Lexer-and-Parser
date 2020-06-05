
public class VariableLog {

	public String name;
	public int Tam_sayý;
	private String Dýzý;
	public  Float Gercek_sayý;
	public char Harf;
	public  int Sýra;
	public boolean  mantýk;
	
	
	
	public  VariableLog(String name , Float deger ,int  sýra){
		
	this.name = name;
	this.Gercek_sayý = deger;
	this.Sýra =  sýra;
		
	}
	public  VariableLog(String name , String deger ,int  sýra){
		this.name = name;
		this.setDýzý(deger);
		this.Sýra =  sýra;
		
		
		
	}
	public  VariableLog(String name , int deger ,int  sýra){
	
		this.name = name ;
		this.Tam_sayý = deger;
	
		this.Sýra =  sýra;
	
	}
	public  VariableLog(String name , char deger ,int  sýra){
		this.name = name;
		this.Harf =deger;
		this.Sýra =  sýra;
	
	
	}
	public  VariableLog(String name , boolean deger ,int  sýra){
		this.name = name;
		this.mantýk =deger;
		this.Sýra =  sýra;
	
	
	}
	public String getDýzý() {
		return Dýzý;
	}
	public void setDýzý(String dýzý) {
		Dýzý = dýzý;
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
