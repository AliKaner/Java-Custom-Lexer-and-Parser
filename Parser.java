import java.util.ArrayList;

public class Parser {

	
	private static   Lexer lexer = new Lexer("C:/Input.txt");
	
	
	static int  a,b,CarpanHolderInt,BolmeHolderInt,c,d,e,g,h =1,l,p=1;
	static  ArrayList<Integer> ToplamaListInt =  new ArrayList<Integer>();
	static ArrayList<Float> ToplamaListFloat = new ArrayList<Float>();
	static Tokens TokenTypeHolder,TokenTypeHolderMantik;
	static String id="",str;
	static ArrayList<String> ToplamaListChar = new ArrayList<String>();
	static ArrayList<VariableLog> VariableLogList = new ArrayList<VariableLog>();
	static ArrayList<VariableLog> VariableLogListLogic = new ArrayList<VariableLog>();
	static float f,CarpanHolderFloat,BolmeHolderFloat,t = 1,r =1,n,v,y;
	
	
	
	
	
	public static void main(String[] args) {
		
		
		ParserStart(lexer);
		
		
		
		
	}
	 public static void ParserStart(Lexer lexer)
	 {
		 if (lexer.currentToken() == Tokens.BASLANGIC)
		 {
			 lexer.moveAhead();
			 ParserPanel(lexer);
		 }
	 }
	
	public static void ParserPanel(Lexer lexer)
	{
		while(lexer.currentToken() != Tokens.BITIS)
		{
			
		
		if(lexer.currentToken() == Tokens.TOPLAMA)
			{
				ToplamaYedek(lexer);
				Reset();
			}
		if(lexer.currentToken() ==Tokens.CIKARMA)
			{	
				CikarmaYedek(lexer);
				Reset();
			}
		if(lexer.currentToken()== Tokens.CARPMA)
			{
				CarpmaYedek(lexer);
				Reset();
			}
		if(lexer.currentToken()== Tokens.BOLME)
			{
				BolmeYedek(lexer);
				Reset();
			}
		if(lexer.currentToken()== Tokens.DIZI_TOPLAMA)
			{
				DiziToplama(lexer);
				Reset();
			}
		if(lexer.currentToken() == Tokens.HARF_TOPLAMA)
			{
				HarfToplama(lexer);
				Reset();
			}
		if(lexer.currentToken() == Tokens.DONGU)
			{
				Dongu(lexer);
				Reset();
			}
		if(lexer.currentToken() == Tokens.ATAMA)
			{
				Atama(lexer);
				Reset();
			}
		if(lexer.currentToken() ==  Tokens.MANTIK_ISLEM)
			{
				MantýkIslem(lexer);
				Reset();
			}
		if(lexer.currentToken() == Tokens.MANTIK_DEGIL)
			{
			Degil(lexer);
			}
		
		if(lexer.currentToken() == Tokens.NOKTALI_VIRGUL)
			{
			lexer.moveAhead();
			}
		if(lexer.currentToken() == Tokens.EGER)
		{
			lexer.moveAhead();
			if(lexer.currentToken() == Tokens.MANTIK_DOGRU)
				{
				lexer.moveAhead();
				if(lexer.currentToken() ==Tokens.PARANTEZ_KAPA)
					lexer.moveAhead();
				while(lexer.currentToken() !=Tokens.EGER_SON)
				{
				if(lexer.currentToken() == Tokens.TOPLAMA)
				{
					ToplamaYedek(lexer);
					Reset();
					
				}
			if(lexer.currentToken() ==Tokens.CIKARMA)
				{	
					CikarmaYedek(lexer);
					Reset();
				}
			if(lexer.currentToken()== Tokens.CARPMA)
				{
					CarpmaYedek(lexer);
					Reset();
				}
			if(lexer.currentToken()== Tokens.BOLME)
				{
					BolmeYedek(lexer);
					Reset();
				}
			if(lexer.currentToken()== Tokens.DIZI_TOPLAMA)
				{
					DiziToplama(lexer);
					Reset();
				}
			if(lexer.currentToken() == Tokens.HARF_TOPLAMA)
				{
					HarfToplama(lexer);
					Reset();
				}
			if(lexer.currentToken() == Tokens.DONGU)
				{
					Dongu(lexer);
					Reset();
				}
			if(lexer.currentToken() == Tokens.ATAMA)
				{
					Atama(lexer);
					Reset();
				}
			if(lexer.currentToken() ==  Tokens.MANTIK_ISLEM)
				{
					MantýkIslem(lexer);
					Reset();
				}
			if(lexer.currentToken() == Tokens.MANTIK_DEGIL)
				{
				Degil(lexer);
				}
			
			if(lexer.currentToken() == Tokens.NOKTALI_VIRGUL)
				{
				lexer.moveAhead();
				}
				
				}}
			else if (lexer.currentToken() == Tokens.MANTIK_YANLIS)
			{
				lexer.moveAhead();
				if(lexer.currentToken() ==Tokens.PARANTEZ_KAPA)
					lexer.moveAhead();
				while(lexer.currentToken() !=Tokens.EGER_SON)
				{
					lexer.moveAhead();
				}
			}
			lexer.moveAhead();
				}
		
		}
		
	}
		
	// toplama.......................................................................................................
		//.........................................................................................................
	public static void ToplamaYedek(Lexer lexer)
	{
		lexer.moveAhead();
		g = 0;
		if(lexer.currentToken() == Tokens.GERCEK_SAYI)
		{
			
			while(lexer.currentToken() != Tokens.PARANTEZ_KAPA)
			{
				
				if(lexer.currentToken() == Tokens.GERCEK_SAYI)
				{
					f = f + Float.parseFloat(lexer.currentLexema());
					System.out.print(lexer.currentLexema());
					lexer.moveAhead();
				}
				if(lexer.currentToken() == Tokens.VIRGUL)
				{
					System.out.print("+");
					lexer.moveAhead();
				}
				if(lexer.currentToken() == Tokens.CARPMA)
				{
					
					System.out.print("(");
					lexer.moveAhead();
					while(lexer.currentToken() != Tokens.PARANTEZ_KAPA)
					{
						if(lexer.currentToken() == Tokens.VIRGUL)
						{
							System.out.print("x");
							lexer.moveAhead();
						}
						if(lexer.currentToken() == Tokens.GERCEK_SAYI)
						{
							t = t * Float.parseFloat(lexer.currentLexema());
							System.out.print(lexer.currentLexema());
							lexer.moveAhead();
						}}
					f = f + t;
					System.out.print(")");
					t =1;
					lexer.moveAhead();
				}
				if(lexer.currentToken() == Tokens.BOLME)
				{
					
					System.out.print("(");
					lexer.moveAhead();
					if(lexer.currentToken() == Tokens.GERCEK_SAYI)
					{
						t =  Float.parseFloat(lexer.currentLexema());
						System.out.print(lexer.currentLexema());
						lexer.moveAhead();
					}
						if(lexer.currentToken() == Tokens.VIRGUL)
						{
							System.out.print("÷");
							lexer.moveAhead();
						}
						if(lexer.currentToken() == Tokens.GERCEK_SAYI)
						{
							r = r /  Integer.parseInt(lexer.currentLexema());
							System.out.print(lexer.currentLexema());
							lexer.moveAhead();
						}
						if(lexer.currentToken() == Tokens.PARANTEZ_KAPA )
						{
					f = f + r;
					System.out.print(")");
					r = 1;
					lexer.moveAhead();
						}
				}
				
				if(lexer.currentToken() == Tokens.DIZI1)
				{
				if(VarMý(lexer.currentLexema()))
						{
						
						 f = f + VariableLogList.get(VarsaNerde(lexer.currentLexema())+g).Gercek_sayý;
						 g++;
						 System.out.print(lexer.currentLexema());
							lexer.moveAhead();
						}
			}
				if(lexer.currentToken() ==  Tokens.CIKARMA)
				 {
					 System.out.print("(-(");
					 lexer.moveAhead();
					 y = Float.parseFloat(lexer.currentLexema());
					 System.out.print(lexer.currentLexema());
					 lexer.moveAhead();
					 while(lexer.currentToken() != Tokens.PARANTEZ_KAPA)
						{ 
						 if(lexer.currentToken() == Tokens.VIRGUL)
						 {
							 lexer.moveAhead();
							 System.out.print("-");
						 }
					 if(lexer.currentToken() == Tokens.GERCEK_SAYI)
					 {
						 y = y - Float.parseFloat(lexer.currentLexema());
						 System.out.print(lexer.currentLexema());
						 lexer.moveAhead();
					 }
						 
						 f = f-y;
						}
					 System.out.print("))");
					 lexer.moveAhead();
					 
				 }}
			System.out.println("="+ f);
			f =0;
		     lexer.moveAhead();
		}
		if(lexer.currentToken() == Tokens.TAM_SAYI)
		{
			c = c + Integer.parseInt(lexer.currentLexema());
			System.out.print(lexer.currentLexema());
			lexer.moveAhead();
			TokenTypeHolder = Tokens.TAM_SAYI;
			
		while(lexer.currentToken() != Tokens.PARANTEZ_KAPA)
		{
			if(lexer.currentToken() == Tokens.VIRGUL)
			{
				System.out.print("+");
				lexer.moveAhead();
			}
			if(lexer.currentToken() == Tokens.TAM_SAYI)
			{
				c = c + Integer.parseInt(lexer.currentLexema());
				System.out.print(lexer.currentLexema());
				lexer.moveAhead();
			}
			if(lexer.currentToken() == Tokens.CARPMA)
			{
				
				System.out.print("(");
				lexer.moveAhead();
				while(lexer.currentToken() != Tokens.PARANTEZ_KAPA)
				{
					if(lexer.currentToken() == Tokens.VIRGUL)
					{
						System.out.print("x");
						lexer.moveAhead();
					}
					if(lexer.currentToken() == Tokens.TAM_SAYI)
					{
						h = h * Integer.parseInt(lexer.currentLexema());
						System.out.print(lexer.currentLexema());
						lexer.moveAhead();
					}}
				c = c +h;
				System.out.print(")");
				h =1;
				lexer.moveAhead();
			}
			if(lexer.currentToken() == Tokens.BOLME)
			{
				
				System.out.print("(");
				lexer.moveAhead();
				if(lexer.currentToken() == Tokens.TAM_SAYI)
				{
					p =  Integer.parseInt(lexer.currentLexema());
					System.out.print(lexer.currentLexema());
					lexer.moveAhead();
				}
					if(lexer.currentToken() == Tokens.VIRGUL)
					{
						System.out.print("÷");
						lexer.moveAhead();
					}
					if(lexer.currentToken() == Tokens.TAM_SAYI)
					{
						p = p /  Integer.parseInt(lexer.currentLexema());
						System.out.print(lexer.currentLexema());
						lexer.moveAhead();
					}
					if(lexer.currentToken() == Tokens.PARANTEZ_KAPA )
					{
				c = c + p;
				System.out.print(")");
				lexer.moveAhead();
					}
			}
			 if(lexer.currentToken() == Tokens.DIZI1)
			{
			if(VarMý(lexer.currentLexema()))
					{
					
					 c = c + VariableLogList.get(VarsaNerde(lexer.currentLexema())+g).Tam_sayý;
					 g++;
					 System.out.print(lexer.currentLexema());
						lexer.moveAhead();
					}
			
			}
			 if(lexer.currentToken() ==  Tokens.CIKARMA)
			 {
				 System.out.print("(-");
				 lexer.moveAhead();
				 while(lexer.currentToken() != Tokens.PARANTEZ_KAPA)
					{ 
				 if(lexer.currentToken() == Tokens.TAM_SAYI)
					 
					 c = c - Integer.parseInt(lexer.currentLexema());
					 System.out.print(lexer.currentLexema());
					 lexer.moveAhead();
					 if(lexer.currentToken() == Tokens.VIRGUL)
					 {
						 lexer.moveAhead();
						 System.out.print("-");
					 }
					}
				 System.out.print(")");
				 lexer.moveAhead();
				 
			 }
			
		}
		
		System.out.println("="+c);
		c=0;
	     lexer.moveAhead();
	     
	}
		
		}

	public static void DonguToplama(Lexer lexer,int  u)
	{
		lexer.moveAhead();

		if(lexer.currentToken() ==  Tokens.TAM_SAYI)
		{
			
			TokenTypeHolder = Tokens.TAM_SAYI;
			
				System.out.print(lexer.currentLexema());
				ToplamaListInt.add(Integer.parseInt(lexer.currentLexema()));
				
			
			lexer.moveAhead();
					
		
		}
		if(lexer.currentToken() == Tokens.VIRGUL)
		{
			lexer.moveAhead();
			
		}
		if(TokenTypeHolder  == lexer.currentToken())
		{
			for(int  j = 0; j< u ;j++)
			{
				System.out.print("+");
				ToplamaListInt.add(Integer.parseInt(lexer.currentLexema()));
				System.out.print(lexer.currentLexema());
				
			}
		}
		
		System.out.print("=");
		for(int i = 0 ; i < ToplamaListInt.size();i++)
		{
			b = b + ToplamaListInt.get(i);
		}
		System.out.print(b);
		ToplamaListInt.clear();
		lexer.moveAhead();
		lexer.moveAhead();
		
	}
		// çýkarma.......................................................................................................
	//.........................................................................................................
			public static  void CikarmaYedek(Lexer lexer)
			{
				lexer.moveAhead();
				g = 0;
				if(lexer.currentToken() == Tokens.GERCEK_SAYI)
				{
					f = f + Integer.parseInt(lexer.currentLexema());
					System.out.print(lexer.currentLexema());
					lexer.moveAhead();
					while(lexer.currentToken() != Tokens.PARANTEZ_KAPA)
					{
						
						if(lexer.currentToken() == Tokens.GERCEK_SAYI)
						{
							f = f - Integer.parseInt(lexer.currentLexema());
							System.out.print(lexer.currentLexema());
							lexer.moveAhead();
						}
						if(lexer.currentToken() == Tokens.VIRGUL)
						{
							System.out.print("-");
							lexer.moveAhead();
						}
						if(lexer.currentToken() == Tokens.CARPMA)
						{
							
							System.out.print("(");
							lexer.moveAhead();
							while(lexer.currentToken() != Tokens.PARANTEZ_KAPA)
							{
								if(lexer.currentToken() == Tokens.VIRGUL)
								{
									System.out.print("x");
									lexer.moveAhead();
								}
								if(lexer.currentToken() == Tokens.GERCEK_SAYI)
								{
									t = t * Float.parseFloat(lexer.currentLexema());
									System.out.print(lexer.currentLexema());
									lexer.moveAhead();
								}}
							f = f - t;
							System.out.print(")");
							t =1;
							lexer.moveAhead();
						}
						if(lexer.currentToken() == Tokens.BOLME)
						{
							
							System.out.print("(");
							lexer.moveAhead();
							if(lexer.currentToken() == Tokens.TAM_SAYI)
							{
								p =  Integer.parseInt(lexer.currentLexema());
								System.out.print(lexer.currentLexema());
								lexer.moveAhead();
							}
								if(lexer.currentToken() == Tokens.VIRGUL)
								{
									System.out.print("÷");
									lexer.moveAhead();
								}
								if(lexer.currentToken() == Tokens.TAM_SAYI)
								{
									p = p /  Integer.parseInt(lexer.currentLexema());
									System.out.print(lexer.currentLexema());
									lexer.moveAhead();
								}
								if(lexer.currentToken() == Tokens.PARANTEZ_KAPA )
								{
							f = f - r;
							System.out.print(")");
							r = 1;
							lexer.moveAhead();
								}
						}
						if(lexer.currentToken() == Tokens.DIZI1)
						{
						if(VarMý(lexer.currentLexema()))
								{
								
								 f = f - VariableLogList.get(VarsaNerde(lexer.currentLexema())+g).Gercek_sayý;
								 g++;
								 System.out.print(lexer.currentLexema());
									lexer.moveAhead();
								}
					}
						 if(lexer.currentToken() ==  Tokens.TOPLAMA)
						 {
							 System.out.print("(+");
							 lexer.moveAhead();
							 while(lexer.currentToken() != Tokens.PARANTEZ_KAPA)
								{ 
							 if(lexer.currentToken() == Tokens.TAM_SAYI)
								 
								 f = f + Float.parseFloat(lexer.currentLexema());
								 System.out.print(lexer.currentLexema());
								 lexer.moveAhead();
								 if(lexer.currentToken() == Tokens.VIRGUL)
								 {
									 lexer.moveAhead();
									 System.out.print("+");
								 }
								}
							 System.out.print(")");
							 lexer.moveAhead();
							 
						 }
					System.out.println("="+f);
					f =0;
				     lexer.moveAhead();
				}}
				if(lexer.currentToken() == Tokens.TAM_SAYI)
				{
					c = c + Integer.parseInt(lexer.currentLexema());
					System.out.print(lexer.currentLexema());
					lexer.moveAhead();
					TokenTypeHolder = Tokens.TAM_SAYI;
					
				while(lexer.currentToken() != Tokens.PARANTEZ_KAPA)
				{
					if(lexer.currentToken() == Tokens.VIRGUL)
					{
						System.out.print("-");
						lexer.moveAhead();
					}
					if(lexer.currentToken() == Tokens.TAM_SAYI)
					{
						c = c - Integer.parseInt(lexer.currentLexema());
						System.out.print(lexer.currentLexema());
						lexer.moveAhead();
					}
					if(lexer.currentToken() == Tokens.CARPMA)
					{
						
						System.out.print("(");
						lexer.moveAhead();
						while(lexer.currentToken() != Tokens.PARANTEZ_KAPA)
						{
							if(lexer.currentToken() == Tokens.VIRGUL)
							{
								System.out.print("x");
								lexer.moveAhead();
							}
							if(lexer.currentToken() == Tokens.TAM_SAYI)
							{
								h = h * Integer.parseInt(lexer.currentLexema());
								System.out.print(lexer.currentLexema());
								lexer.moveAhead();
							}}
						c = c -h;
						System.out.print(")");
						h =1;
						lexer.moveAhead();
					}
					if(lexer.currentToken() == Tokens.BOLME)
					{
						
						System.out.print("(");
						lexer.moveAhead();
						if(lexer.currentToken() == Tokens.TAM_SAYI)
						{
							p =  Integer.parseInt(lexer.currentLexema());
							System.out.print(lexer.currentLexema());
							lexer.moveAhead();
						}
							if(lexer.currentToken() == Tokens.VIRGUL)
							{
								System.out.print("÷");
								lexer.moveAhead();
							}
							if(lexer.currentToken() == Tokens.TAM_SAYI)
							{
								p = p /  Integer.parseInt(lexer.currentLexema());
								System.out.print(lexer.currentLexema());
								lexer.moveAhead();
							}
							if(lexer.currentToken() == Tokens.PARANTEZ_KAPA )
							{
						c = c - p;
						System.out.print(")");
						lexer.moveAhead();
							}
					}
					 if(lexer.currentToken() == Tokens.DIZI1)
					{
					if(VarMý(lexer.currentLexema()))
							{
							
							 c = c - VariableLogList.get(VarsaNerde(lexer.currentLexema())+g).Tam_sayý;
							 g++;
							 System.out.print(lexer.currentLexema());
								lexer.moveAhead();
							}
					
					}
					 if(lexer.currentToken() ==  Tokens.TOPLAMA)
					 {
						 System.out.print("(+");
						 lexer.moveAhead();
						 while(lexer.currentToken() != Tokens.PARANTEZ_KAPA)
							{ 
						 if(lexer.currentToken() == Tokens.TAM_SAYI)
							 
							 c = c + Integer.parseInt(lexer.currentLexema());
							 System.out.print(lexer.currentLexema());
							 lexer.moveAhead();
							 if(lexer.currentToken() == Tokens.VIRGUL)
							 {
								 lexer.moveAhead();
								 System.out.print("+");
							 }
							}
						 System.out.print(")");
						 lexer.moveAhead();
						 
					 }
					
				}
				System.out.println("="+c);
			     lexer.moveAhead();
			     c=0;
			     
			}
				
				}
			
		
		
	
	
	
	public static void DonguCikarma(Lexer lexer,int  u)
	{
		lexer.moveAhead();

		if(lexer.currentToken() ==  Tokens.TAM_SAYI)
		{
			
			TokenTypeHolder = Tokens.TAM_SAYI;
			
				
				System.out.print(lexer.currentLexema());
				ToplamaListInt.add(Integer.parseInt(lexer.currentLexema()));
				
		
			lexer.moveAhead();
					
		
		}
		if(lexer.currentToken() == Tokens.VIRGUL)
		{
			lexer.moveAhead();
			
		}
		if(TokenTypeHolder  == lexer.currentToken())
		{
			for(int  j = 0; j< u ;j++)
			{
				System.out.print("-");
				ToplamaListInt.add(Integer.parseInt("-"+lexer.currentLexema()));
				System.out.print(lexer.currentLexema());
				
			}
		}
		
		System.out.print("=");
		for(int i = 0 ; i < ToplamaListInt.size();i++)
		{
			b = b -ToplamaListInt.get(i);
		}
		System.out.print(b);
		lexer.moveAhead();
		lexer.moveAhead();
		
	}
	
	
	
	
	
	
	// carpma.......................................................................................................
		//.........................................................................................................
	
	
	
	
	
	
	public static void CarpmaYedek (Lexer lexer)
	{
		lexer.moveAhead();
		g = 0;
		if(lexer.currentToken() == Tokens.GERCEK_SAYI)
		{
			f = f + Integer.parseInt(lexer.currentLexema());
		System.out.print(lexer.currentLexema());
		lexer.moveAhead();
			
			while(lexer.currentToken() != Tokens.PARANTEZ_KAPA)
			{
				
				if(lexer.currentToken() == Tokens.GERCEK_SAYI)
				{
					f = f * Integer.parseInt(lexer.currentLexema());
					System.out.print(lexer.currentLexema());
					lexer.moveAhead();
				}
				if(lexer.currentToken() == Tokens.VIRGUL)
				{
					System.out.print("x");
					lexer.moveAhead();
				}
				
				if(lexer.currentToken() == Tokens.BOLME)
				{
					
					System.out.print("(");
					lexer.moveAhead();
					if(lexer.currentToken() == Tokens.TAM_SAYI)
					{
						p =  Integer.parseInt(lexer.currentLexema());
						System.out.print(lexer.currentLexema());
						lexer.moveAhead();
					}
						if(lexer.currentToken() == Tokens.VIRGUL)
						{
							System.out.print("÷");
							lexer.moveAhead();
						}
						if(lexer.currentToken() == Tokens.TAM_SAYI)
						{
							p = p /  Integer.parseInt(lexer.currentLexema());
							System.out.print(lexer.currentLexema());
							lexer.moveAhead();
						}
						if(lexer.currentToken() == Tokens.PARANTEZ_KAPA )
						{
					f = f * r;
					System.out.print(")");
					r = 1;
					lexer.moveAhead();
						}
				}
				
				if(lexer.currentToken() == Tokens.DIZI1)
				{
				if(VarMý(lexer.currentLexema()))
						{
						
						 f = f * VariableLogList.get(VarsaNerde(lexer.currentLexema())+g).Gercek_sayý;
						 g++;
						 System.out.print(lexer.currentLexema());
							lexer.moveAhead();
						}
			}
				if(lexer.currentToken() ==  Tokens.CIKARMA)
				 {
					 System.out.print("(-");
					 lexer.moveAhead();

					 v =  Float.parseFloat(lexer.currentLexema());
					 System.out.print(lexer.currentLexema());
					 lexer.moveAhead();
					 while(lexer.currentToken() != Tokens.PARANTEZ_KAPA)
						{ 
					 if(lexer.currentToken() == Tokens.TAM_SAYI)
						 
						 v = v - Float.parseFloat(lexer.currentLexema());
						 System.out.print(lexer.currentLexema());
						 lexer.moveAhead();
						 if(lexer.currentToken() == Tokens.VIRGUL)
						 {
							 lexer.moveAhead();
							 System.out.print("-");
						 }
						}
					 System.out.print(")");
					 lexer.moveAhead();
					 f = f*v;
					 v =0;
				 }
				if(lexer.currentToken() == Tokens.TOPLAMA)
				{
					System.out.print("(");
					lexer.currentLexema();
					while(lexer.currentToken() != Tokens.PARANTEZ_KAPA)
					{ 
				 if(lexer.currentToken() == Tokens.TAM_SAYI)
					 
					 v = v + Float.parseFloat(lexer.currentLexema());
					 System.out.print(lexer.currentLexema());
					 lexer.moveAhead();
					 if(lexer.currentToken() == Tokens.VIRGUL)
					 {
						 lexer.moveAhead();
						 System.out.print("+");
					 }
					 System.out.print(")");
					 lexer.moveAhead();
					 f = f*v;
					 v =0;
					}
				}
			System.out.println("="+f);
			f =0;
		     lexer.moveAhead();
		}}
		if(lexer.currentToken() == Tokens.TAM_SAYI)
		{
			c =  Integer.parseInt(lexer.currentLexema());
			System.out.print(lexer.currentLexema());
			lexer.moveAhead();
			TokenTypeHolder = Tokens.TAM_SAYI;
			
		while(lexer.currentToken() != Tokens.PARANTEZ_KAPA)
		{
			if(lexer.currentToken() == Tokens.VIRGUL)
			{
				System.out.print("x");
				lexer.moveAhead();
			}
			if(lexer.currentToken() == Tokens.TAM_SAYI)
			{
				c = c * Integer.parseInt(lexer.currentLexema());
				System.out.print(lexer.currentLexema());
				lexer.moveAhead();
			}
						if(lexer.currentToken() == Tokens.BOLME)
			{
				
				System.out.print("(");
				lexer.moveAhead();
				if(lexer.currentToken() == Tokens.TAM_SAYI)
				{
					p =  Integer.parseInt(lexer.currentLexema());
					System.out.print(lexer.currentLexema());
					lexer.moveAhead();
				}
					if(lexer.currentToken() == Tokens.VIRGUL)
					{
						System.out.print("÷");
						lexer.moveAhead();
					}
					if(lexer.currentToken() == Tokens.TAM_SAYI)
					{
						p = p /  Integer.parseInt(lexer.currentLexema());
						System.out.print(lexer.currentLexema());
						lexer.moveAhead();
					}
					if(lexer.currentToken() == Tokens.PARANTEZ_KAPA )
					{
				c = c * p;
				System.out.print(")");
				lexer.moveAhead();
					}
			}
			 if(lexer.currentToken() == Tokens.DIZI1)
			{
			if(VarMý(lexer.currentLexema()))
					{
					
					 c = c * VariableLogList.get(VarsaNerde(lexer.currentLexema())+g).Tam_sayý;
					 g++;
					 System.out.print(lexer.currentLexema());
						lexer.moveAhead();
					}
			
			}
			 if(lexer.currentToken() ==  Tokens.CIKARMA)
			 {
				 l =  Integer.parseInt(lexer.currentLexema());
					System.out.print(lexer.currentLexema());
					lexer.moveAhead();
					TokenTypeHolder = Tokens.TAM_SAYI;
				 System.out.print("(-");
				 lexer.moveAhead();
				 while(lexer.currentToken() != Tokens.PARANTEZ_KAPA)
					{ 
				 if(lexer.currentToken() == Tokens.TAM_SAYI)
					 
					 l = l - Integer.parseInt(lexer.currentLexema());
					 System.out.print(lexer.currentLexema());
					 lexer.moveAhead();
					 if(lexer.currentToken() == Tokens.VIRGUL)
					 {
						 lexer.moveAhead();
						 System.out.print("-");
					 }
					}
				 c = c*l;
				 System.out.print(")");
				 lexer.moveAhead();
				 l = 0;
				 
			 }
			 if(lexer.currentToken() == Tokens.TOPLAMA)
				{
					System.out.print("(");
					lexer.moveAhead();
					while(lexer.currentToken() != Tokens.PARANTEZ_KAPA)
					{ 
				 if(lexer.currentToken() == Tokens.TAM_SAYI)
				 {
					 l = l + Integer.parseInt(lexer.currentLexema());
					 System.out.print(lexer.currentLexema());
					 lexer.moveAhead();
				 }
					 if(lexer.currentToken() == Tokens.VIRGUL)
					 {
						 lexer.moveAhead();
						 System.out.print("+");
					 }
					 
					}
					System.out.print(")");
					 lexer.moveAhead();
					 c = c*l;
					 l =0;
				}
			
		}
		
		System.out.println("="+c);
		c=0;
	     lexer.moveAhead();
	     
	}
		
		}
		
		
		public static  void  DonguCarpma(Lexer lexer, int  u)
		{
			
			lexer.moveAhead();

			if(lexer.currentToken() ==  Tokens.TAM_SAYI)
			{
				
				TokenTypeHolder = Tokens.TAM_SAYI;
				
					
					System.out.print(lexer.currentLexema());
					CarpanHolderInt = Integer.parseInt(lexer.currentLexema());
					ToplamaListInt.add(Integer.parseInt(lexer.currentLexema()));
					
			
				lexer.moveAhead();
						
			
			}
			if(lexer.currentToken() == Tokens.VIRGUL)
			{
				lexer.moveAhead();
				
			}
			if(TokenTypeHolder  == lexer.currentToken())
			{
				for(int  j = 0; j< u ;j++)
				{
					System.out.print("x");
					
					System.out.print(lexer.currentLexema());
					
				}
			}
			
			System.out.print("=");
			for(int i = 0 ; i < u;i++)
			{
				CarpanHolderInt =  CarpanHolderInt * Integer.parseInt(lexer.currentLexema());
			}
			System.out.print(CarpanHolderInt);
			lexer.moveAhead();
			lexer.moveAhead();
			
			
			//Bölme..........................................................................................................
			//...............................................................................
			
		}
		public static void BolmeYedek (Lexer lexer)
		{
			lexer.moveAhead();
			g = 0;
			if(lexer.currentToken() == Tokens.GERCEK_SAYI)
			{
				f = f + Integer.parseInt(lexer.currentLexema());
			System.out.print(lexer.currentLexema());
			lexer.moveAhead();
				
				while(lexer.currentToken() != Tokens.PARANTEZ_KAPA)
				{
					
					if(lexer.currentToken() == Tokens.GERCEK_SAYI)
					{
						f = f / Integer.parseInt(lexer.currentLexema());
						System.out.print(lexer.currentLexema());
						lexer.moveAhead();
					}
					if(lexer.currentToken() == Tokens.VIRGUL)
					{
						System.out.print(" ");
						lexer.moveAhead();
					}
					
					if(lexer.currentToken() == Tokens.CARPMA)
					{
						
						System.out.print("(");
						lexer.moveAhead();
						if(lexer.currentToken() == Tokens.GERCEK_SAYI)
						{
							p =  Integer.parseInt(lexer.currentLexema());
							System.out.print(lexer.currentLexema());
							lexer.moveAhead();
						}
							if(lexer.currentToken() == Tokens.VIRGUL)
							{
								System.out.print("x");
								lexer.moveAhead();
							}
							if(lexer.currentToken() == Tokens.TAM_SAYI)
							{
								p = p *  Integer.parseInt(lexer.currentLexema());
								System.out.print(lexer.currentLexema());
								lexer.moveAhead();
							}
							if(lexer.currentToken() == Tokens.PARANTEZ_KAPA )
							{
						f = f / r;
						System.out.print(")");
						r = 1;
						lexer.moveAhead();
							}
					}
					
					if(lexer.currentToken() == Tokens.DIZI1)
					{
					if(VarMý(lexer.currentLexema()))
							{
							
							 f = f / VariableLogList.get(VarsaNerde(lexer.currentLexema())+g).Gercek_sayý;
							 g++;
							 System.out.print(lexer.currentLexema());
								lexer.moveAhead();
							}
				}
					if(lexer.currentToken() ==  Tokens.CIKARMA)
					 {
						 System.out.print("(-");
						 lexer.moveAhead();

						 v =  Float.parseFloat(lexer.currentLexema());
						 System.out.print(lexer.currentLexema());
						 lexer.moveAhead();
						 while(lexer.currentToken() != Tokens.PARANTEZ_KAPA)
							{ 
						 if(lexer.currentToken() == Tokens.TAM_SAYI)
							 
							 v = v - Float.parseFloat(lexer.currentLexema());
							 System.out.print(lexer.currentLexema());
							 lexer.moveAhead();
							 if(lexer.currentToken() == Tokens.VIRGUL)
							 {
								 lexer.moveAhead();
								 System.out.print("-");
							 }
							}
						 System.out.print(")");
						 lexer.moveAhead();
						 f = f/v;
						 v =0;
					 }
					if(lexer.currentToken() == Tokens.TOPLAMA)
					{
						
						
						
					}
				System.out.printf("%.2f",f);
				f =0;
			     lexer.moveAhead();
			}}
			if(lexer.currentToken() == Tokens.TAM_SAYI)
			{
				c =  Integer.parseInt(lexer.currentLexema());
				System.out.print(lexer.currentLexema());
				lexer.moveAhead();
				TokenTypeHolder = Tokens.TAM_SAYI;
				
			while(lexer.currentToken() != Tokens.PARANTEZ_KAPA)
			{
				if(lexer.currentToken() == Tokens.VIRGUL)
				{
					System.out.print("÷");
					lexer.moveAhead();
				}
				if(lexer.currentToken() == Tokens.TAM_SAYI)
				{
					c = c / Integer.parseInt(lexer.currentLexema());
					System.out.print(lexer.currentLexema());
					lexer.moveAhead();
				}
							if(lexer.currentToken() == Tokens.CARPMA)
				{
					
					System.out.print("(");
					lexer.moveAhead();
					if(lexer.currentToken() == Tokens.TAM_SAYI)
					{
						p =  Integer.parseInt(lexer.currentLexema());
						System.out.print(lexer.currentLexema());
						lexer.moveAhead();
					}
						if(lexer.currentToken() == Tokens.VIRGUL)
						{
							System.out.print("x");
							lexer.moveAhead();
						}
						if(lexer.currentToken() == Tokens.TAM_SAYI)
						{
							p = p /  Integer.parseInt(lexer.currentLexema());
							System.out.print(lexer.currentLexema());
							lexer.moveAhead();
						}
						if(lexer.currentToken() == Tokens.PARANTEZ_KAPA )
						{
					c = c /p;
					System.out.print(")");
					lexer.moveAhead();
						}
				}
				 if(lexer.currentToken() == Tokens.DIZI1)
				{
				if(VarMý(lexer.currentLexema()))
						{
						
						 c = c / VariableLogList.get(VarsaNerde(lexer.currentLexema())+g).Tam_sayý;
						 g++;
						 System.out.print(lexer.currentLexema());
							lexer.moveAhead();
						}
				
				}
				 if(lexer.currentToken() ==  Tokens.CIKARMA)
				 {
					 System.out.print("(");
					 lexer.moveAhead();
					 
					 
					 l =  Integer.parseInt(lexer.currentLexema());
					 System.out.print(lexer.currentLexema());
						lexer.moveAhead();
						
						TokenTypeHolder = Tokens.TAM_SAYI;
					
					 
					 while(lexer.currentToken() != Tokens.PARANTEZ_KAPA)
						{ 
					 if(lexer.currentToken() == Tokens.TAM_SAYI)
						 
						 l = l - Integer.parseInt(lexer.currentLexema());
						 System.out.print(lexer.currentLexema());
						 lexer.moveAhead();
						 if(lexer.currentToken() == Tokens.VIRGUL)
						 {
							 lexer.moveAhead();
							 System.out.print("-");
						 }
						}
					
					 c = c/l;
					 System.out.print(")");
					 lexer.moveAhead();
					 
				 }
				 if(lexer.currentToken() == Tokens.TOPLAMA)
					{
						System.out.print("(");
						lexer.moveAhead();
						lexer.currentLexema();
						while(lexer.currentToken() != Tokens.PARANTEZ_KAPA)
						{ 
					 if(lexer.currentToken() == Tokens.TAM_SAYI)
						 
						 l = l + Integer.parseInt(lexer.currentLexema());
						 System.out.print(lexer.currentLexema());
						 lexer.moveAhead();
						 if(lexer.currentToken() == Tokens.VIRGUL)
						 {
							 lexer.moveAhead();
							 System.out.print("+");
						 }
						}
						 System.out.print(")");
						 lexer.moveAhead();
						 c = c/l;
						 l =0;
						
					}
				
				
			}
			
			System.out.println("="+c);
			c=0;
		     lexer.moveAhead();
		     
		}
			
			}
		
		
		

		public static  void  DonguBolme(Lexer lexer, int  u)
		{
			
			lexer.moveAhead();

			if(lexer.currentToken() ==  Tokens.TAM_SAYI)
			{
				
				TokenTypeHolder = Tokens.TAM_SAYI;
				
					
					System.out.print(lexer.currentLexema());
					BolmeHolderInt = Integer.parseInt(lexer.currentLexema());
					ToplamaListInt.add(Integer.parseInt(lexer.currentLexema()));
					
			
				lexer.moveAhead();
						
			
			}
			if(lexer.currentToken() == Tokens.VIRGUL)
			{
				lexer.moveAhead();
				
			}
			if(TokenTypeHolder  == lexer.currentToken())
			{
				for(int  j = 0; j< u ;j++)
				{
					System.out.print("÷");
					
					System.out.print(lexer.currentLexema());
					
				}
			}
			
			System.out.print("=");
			for(int i = 0 ; i < u;i++)
			{
				BolmeHolderInt =  BolmeHolderInt / Integer.parseInt(lexer.currentLexema());
			}
			System.out.print(BolmeHolderInt);
			lexer.moveAhead();
			lexer.moveAhead();
			
			
			
		}
			
		
	
	
		public static  void DiziToplama(Lexer lexer)
		{
			lexer.moveAhead();
			if(lexer.currentToken() ==  Tokens.DIZI1)
				
			{
				str = lexer.currentLexema();
				System.out.print(lexer.currentLexema());
				lexer.moveAhead();
			}
			while(lexer.currentToken() != Tokens.PARANTEZ_KAPA)
			{
			
			
			if(lexer.currentToken() == Tokens.VIRGUL)
			{
				lexer.moveAhead();
				System.out.print("+");
			}
			if(lexer.currentToken() == Tokens.DIZI1)
			{
				System.out.print(lexer.currentLexema());
				str = str + lexer.currentLexema();
				lexer.moveAhead();
				
			}
			
		}
			System.out.println("="+ str);
			str ="";
			lexer.moveAhead();
			lexer.moveAhead();
			}
		
		
		public static  void DonguDiziToplama(Lexer lexer, int u)
		{
			lexer.moveAhead();
			if(lexer.currentToken() ==  Tokens.DIZI1)
			{
				System.out.print(u+"x"+"(");
				str = lexer.currentLexema();
				System.out.print(lexer.currentLexema());
				lexer.moveAhead();
			}
			while(lexer.currentToken() != Tokens.PARANTEZ_KAPA)
			{
			if(lexer.currentToken() == Tokens.VIRGUL)
			{
				lexer.moveAhead();
				System.out.print("+");
			}
			if(lexer.currentToken() == Tokens.DIZI1)
			{
				System.out.print(lexer.currentLexema());
				str = str + lexer.currentLexema();
				lexer.moveAhead();
				
			}
			
		}
			System.out.print(")=");
			for(int i =0;i<u;i++)
			{
				id = id+str;
			}
			System.out.print(id);
			lexer.moveAhead();
			lexer.moveAhead();
			}
		public static void HarfToplama(Lexer lexer)
		{
			
			 lexer.moveAhead();
			  
			 while(lexer.currentToken() != Tokens.PARANTEZ_KAPA)
			 {
				 
				 if(lexer.currentToken() == Tokens.HARF)
				 {
					 ToplamaListChar.add(lexer.currentLexema());
					 System.out.print(lexer.currentLexema());
					 lexer.moveAhead();
				 }
				 if(lexer.currentToken()== Tokens.VIRGUL)
				 {
					System.out.print("+");
					 lexer.moveAhead();
				 }
				 
			 }
			
				 	System.out.print("=");
				 	for(int i = 0; i<ToplamaListChar.size();i++)
				 	{
					 	System.out.print(ToplamaListChar.get(i));
				 	}
				 	System.out.print("\n");
				 	lexer.moveAhead();
				 	
			 }
	
		
		public static  void DonguHarfToplama(Lexer lexer, int u)
		{
			 lexer.moveAhead();
			  System.out.print(u + "x"+ "(");
			 while(lexer.currentToken() != Tokens.PARANTEZ_KAPA)
			 {
				 
				 if(lexer.currentToken() == Tokens.HARF)
				 {
					 ToplamaListChar.add(lexer.currentLexema());
					 System.out.print(lexer.currentLexema());
					 lexer.moveAhead();
				 }
				 if(lexer.currentToken()== Tokens.VIRGUL)
				 {
					System.out.print("+");
					 lexer.moveAhead();
				 }
				 
			 }
			 if(lexer.currentToken() == Tokens.PARANTEZ_KAPA)
			 {
				 System.out.print(")");
				 	System.out.print("=");
				 	for(int j = 0; j<u;j++)
				 	{
				 	for(int i = 0; i<ToplamaListChar.size();i++)
				 	{
					 	System.out.print(ToplamaListChar.get(i));
				 	}}
			 }lexer.moveAhead();
		}
		
		
		
		public static  void  Dongu(Lexer lexer )
		{
		
			
			 lexer.moveAhead();
			 if(lexer.currentToken() == Tokens.TAM_SAYI)
			 {
				a =  Integer.parseInt(lexer.currentLexema());
				lexer.moveAhead();
				
			 }
			 if(lexer.currentToken() == Tokens.VIRGUL)

			 {
				 lexer.moveAhead();
			 }
				 if(lexer.currentToken() == Tokens.TOPLAMA)
					{
						DonguToplama(lexer , a);
					}
					else if(lexer.currentToken() == Tokens.CIKARMA)
					{
						DonguCikarma(lexer,a);
					}
					else if(lexer.currentToken() == Tokens.CARPMA)
					{
						DonguCarpma(lexer,a);
					}
					else if(lexer.currentToken()== Tokens.BOLME)
					{
						DonguBolme(lexer,a);
					}
					else if(lexer.currentToken() == Tokens.DIZI_TOPLAMA)	
					{ 
						DonguDiziToplama(lexer,a);
					}
					else if(lexer.currentToken() == Tokens.HARF_TOPLAMA)
					{
						DonguHarfToplama(lexer,a);
					}
				 if(lexer.currentToken() ==  Tokens.PARANTEZ_KAPA)
				 {
					 lexer.moveAhead();
				 }
				 System.out.println();
				 
			 }
			
		
				 
				 
			 public static void Atama(Lexer lexer)
		 { 
			 lexer.moveAhead();
			 
			 if(lexer.currentToken() == Tokens.DIZI1)
			 {
				id =  lexer.currentLexema();	
				System.out.print(id);
				lexer.moveAhead();
			 if(lexer.currentToken() == Tokens.VIRGUL)
			 {
				 lexer.moveAhead();
				 System.out.print("=");
			 }
			 if(lexer.currentToken()== Tokens.DIZI1)
			 {
				 System.out.println(lexer.currentLexema());
				 VariableLogList.add( new VariableLog(id,lexer.currentLexema(),VariableLogList.size()));
				 
				 
			 }
			 if(lexer.currentToken() == Tokens.TAM_SAYI)
				 {
				 VariableLogList.add( new VariableLog(id,Integer.parseInt(lexer.currentLexema()),VariableLogList.size()));
				 System.out.println	(lexer.currentLexema());
				
				 
				 }
			 if(lexer.currentToken() == Tokens.GERCEK_SAYI)
			 {
				 VariableLogList.add(new VariableLog(id,Float.parseFloat(lexer.currentLexema()),VariableLogList.size()));
				 System.out.println(lexer.currentLexema());
			 }
			 if(lexer.currentToken() == Tokens.HARF)
			 {
				 VariableLogList.add(new VariableLog(id,lexer.currentLexema(),VariableLogList.size()));
				 System.out.println(lexer.currentLexema());
			 }
			 }
			 lexer.moveAhead();
			 if(lexer.currentToken() == Tokens.PARANTEZ_KAPA)
				 lexer.moveAhead();
			
			 
		 }
				 
			 public static  int VarsaNerdeMantýk(String str)
				{
					for(int i = 0 ; i<VariableLogListLogic.size();i++)
					{
						if(VariableLogListLogic.get(i).name == str)
							return i;
					}
					return 0;
				} 
			 
			 public static void MantýkIslem(Lexer lexer)
			 
			 {
				    lexer.moveAhead();
				
				
					if(lexer.currentToken() == Tokens.MANTIK_DOGRU)
					{
						System.out.print("(");
						System.out.print(lexer.currentLexema()+" ");
						
						lexer.moveAhead();
						if(lexer.currentToken() == Tokens.VE)
						{
							lexer.moveAhead();
							System.out.print("ve ");
							if(lexer.currentToken() == Tokens.MANTIK_DOGRU)
							{
								System.out.print(lexer.currentLexema());
								lexer.moveAhead();
								if(lexer.currentToken() == Tokens.PARANTEZ_KAPA)
								{
									System.out.println(") = Doðru ");
									lexer.moveAhead();
								}	
							}
							else {
								if(lexer.currentToken() ==Tokens.MANTIK_YANLIS)
								{
									System.out.print(lexer.currentLexema());
									TokenTypeHolderMantik = lexer.currentToken();									
									lexer.moveAhead();
									if(lexer.currentToken() == Tokens.PARANTEZ_KAPA)
									{
										System.out.println(") =  Yanlýþ" );
										lexer.moveAhead();
										
									}
								}
								else {
									error();
								}
								
							}
							
						}
						 if ( lexer.currentToken() == Tokens.VEYA)
						{
							lexer.moveAhead();
							System.out.print("veya ");
							if(lexer.currentToken() == Tokens.MANTIK_DOGRU)
							{
								System.out.print(lexer.currentLexema());
								lexer.moveAhead();
								if(lexer.currentToken() == Tokens.PARANTEZ_KAPA)
								{
									System.out.println(") = Doðru ");
									lexer.moveAhead();
								}	
							}
							else {
								if(lexer.currentToken() ==Tokens.MANTIK_YANLIS)
								{
									System.out.print(lexer.currentLexema());
									TokenTypeHolderMantik = lexer.currentToken();									
									lexer.moveAhead();
									if(lexer.currentToken() == Tokens.PARANTEZ_KAPA)
									{
										System.out.println(") =  Doðru" );
										lexer.moveAhead();
										
									}
								}
								else {
									error();
								}
								
							}
							
						}
						
						
						
					}
					else if(lexer.currentToken() == Tokens.MANTIK_YANLIS)
					{
						System.out.print("(");
						System.out.print(lexer.currentLexema()+" ");
						
						lexer.moveAhead();
						if(lexer.currentToken() == Tokens.VE)
						{
							lexer.moveAhead();
							System.out.print("ve ");
							if(lexer.currentToken() == Tokens.MANTIK_DOGRU)
							{
								System.out.print(lexer.currentLexema());
								lexer.moveAhead();
								if(lexer.currentToken() == Tokens.PARANTEZ_KAPA)
								{
									System.out.println(") = Yanlýþ ");
									lexer.moveAhead();
								}	
							}
							else {
								if(lexer.currentToken() ==Tokens.MANTIK_YANLIS)
								{
									System.out.print(lexer.currentLexema());
									TokenTypeHolderMantik = lexer.currentToken();									
									lexer.moveAhead();
									if(lexer.currentToken() == Tokens.PARANTEZ_KAPA)
									{
										System.out.println(") =  Yanlýþ" );
										lexer.moveAhead();
										
									}
								}
								
								
							}
							
						}
						else if ( lexer.currentToken() == Tokens.VEYA)
						{
							lexer.moveAhead();
							System.out.print("veya ");
							if(lexer.currentToken() == Tokens.MANTIK_DOGRU)
							{
								System.out.print(lexer.currentLexema());
								lexer.moveAhead();
								if(lexer.currentToken() == Tokens.PARANTEZ_KAPA)
								{
									System.out.println(") = Doðru ");
									lexer.moveAhead();
								}	
							}
							else {
								if(lexer.currentToken() ==Tokens.MANTIK_YANLIS)
								{
									System.out.print(lexer.currentLexema());
									TokenTypeHolderMantik = lexer.currentToken();									
									lexer.moveAhead();
									if(lexer.currentToken() == Tokens.PARANTEZ_KAPA)
									{
										System.out.println(") =  Yanlýþ" );
										lexer.moveAhead();
										
									}
								}
								
								
							}
							
						}
						
						
					}
					
				 }
				
				 
				 
			 
			
			public static  boolean  VarMý(String  str)
			{
				for(int i = 0 ; i<VariableLogList.size();i++)
				{
					if(VariableLogList.get(i).name == str)
						e =1;
				}
				if(e ==1)
				return true;
				else 
					return true ;
			}
			public static  int VarsaNerde(String str)
			{
				for(int i = 0 ; i<VariableLogList.size();i++)
				{
					if(VariableLogList.get(i).name == str)
						return i;
				}
				return 0;
			}
				 
			 public  static void error()
			 {
				 System.out.println("ERROR");
			 }
			 
			 
			 
			 
			 
			 
			 public static  void Reset()
			 {
				 
				 ToplamaListInt.clear();
				 ToplamaListFloat.clear();
				 ToplamaListChar.clear();
				 
			 }
			 
			 
			 
			 public static  void Degil(Lexer lexer)
			 {
				 
				 lexer.moveAhead();
				 System.out.print("degil(");
				 
			
					 
					 if(lexer.currentToken() == Tokens.MANTIK_YANLIS )
					 {
						 System.out.print(lexer.currentLexema());
						 lexer.moveAhead();
						 if(lexer.currentToken()==Tokens.PARANTEZ_KAPA)
						 {
							 System.out.println(")= Doðru");
							 lexer.moveAhead();
						 }
					 }
					 
					 if(lexer.currentToken() == Tokens.MANTIK_DOGRU )
					 {
						 System.out.print(lexer.currentLexema());
						 lexer.moveAhead();
						 if(lexer.currentToken()==Tokens.PARANTEZ_KAPA)
						 {
							 System.out.println(")= Yanlis");
							 lexer.moveAhead();
						 }
					 }
				 
				 
	 
			 }
			 
			 
			
			 
			 
			 
			 
			 
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
			 public void setStringList(ArrayList<Integer> stringList) {
				  this.ToplamaListInt = stringList;
				}
	

	public Lexer getLexer() {
		return lexer;
	}

	public void setLexer(Lexer lexer) {
		this.lexer = lexer;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
