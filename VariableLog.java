
public class VariableLog {

	public String name;
	public int Tam_say�;
	private String D�z�;
	public  Float Gercek_say�;
	public char Harf;
	public  int S�ra;
	public boolean  mant�k;
	
	
	
	public  VariableLog(String name , Float deger ,int  s�ra){
		
	this.name = name;
	this.Gercek_say� = deger;
	this.S�ra =  s�ra;
		
	}
	public  VariableLog(String name , String deger ,int  s�ra){
		this.name = name;
		this.setD�z�(deger);
		this.S�ra =  s�ra;
		
		
		
	}
	public  VariableLog(String name , int deger ,int  s�ra){
	
		this.name = name ;
		this.Tam_say� = deger;
	
		this.S�ra =  s�ra;
	
	}
	public  VariableLog(String name , char deger ,int  s�ra){
		this.name = name;
		this.Harf =deger;
		this.S�ra =  s�ra;
	
	
	}
	public  VariableLog(String name , boolean deger ,int  s�ra){
		this.name = name;
		this.mant�k =deger;
		this.S�ra =  s�ra;
	
	
	}
	public String getD�z�() {
		return D�z�;
	}
	public void setD�z�(String d�z�) {
		D�z� = d�z�;
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
