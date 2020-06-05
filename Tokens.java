import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Tokens {

	BASLANGIC ("Devam\\{"),
	BITIS ("\\}Tamam"),
    PARANTEZ_AC ("\\("),
    PARANTEZ_KAPA ("\\)"),
    EGER("eger\\("),
    EGER_SON("egerson"),
    VEYA ("veya"),
    VE ("ve"),
    MANTIK_DEGIL("degil\\("),
    CARPMA("carpma\\("),
    BOLME ("bolme\\("),
    DONGU ("dongu\\("),
    MANTIK("mantik\\("),
    MANTIK_ISLEM ("mantikis\\("),
    MANTIK_DOGRU ("dogru"),
    MANTIK_YANLIS ("yanlis"),
    TOPLAMA("toplama\\("),
    DIZI_TOPLAMA("dizitoplama\\("),
    HARF_TOPLAMA ("harftoplama\\("),
    SUSLU_PARANTEZ_AC("\\{"),
    SUSLU_PARANTEZ_KAPA("\\}"),
    CIKARMA("cikarma\\("),
    VIRGUL (","),
    ATAMA ("ata\\("),
    NOKTALI_VIRGUL (";"),
    GERCEK_SAYI ("(\\d+)\\.\\d+"),
    DIZI ("\"[^\"]+\""),
    TAM_SAYI ("\\d+"),
    DIZI1("\\w\\w+"),
    HARF("\\w");
	

    private final Pattern pattern;

    Tokens(String regex) {
        pattern = Pattern.compile("^" + regex);
    }

    int endOfMatch(String s) {
        Matcher m = pattern.matcher(s);

        if (m.find()) {
            return m.end();
        }
        return -1;
    }
}
	
	
	
	
	
	


