import java.util.HashMap;

import javax.naming.NamingException;

public class Aine {

	private String name;
	private String[] selitteet = {"id", "nimi", "energia", "hiilihydraatti", "rasva", "proteiini", "alkoholi", "kuitu", "orgaanisetHapot", "sokerialkoholi", "tärkkelys", "sokerit", "fruktoosi", "galaktoosi", "glukoosi", "laktoosi", "maltoosi", "sakkaroosi", "polysakkaridi", "kuituLiukenematon", "rasvahapotYhteensa", "rasvahapotMonityydyttymattomat", "rasvahapotCIS", "rasvahapotTyydyttyneet", "rasvahapotTrans", "rasvahapot_n_3", "rasvahapot_n_6", "rasvahappo_18_2", "rasvahappo_18_3", "rasvahappo_EPA", "rasvahappo_DHA", "kolesteroli", "sterolit", "kalsium", "rauta", "jodidi", "kalium", "magnesium", "natrium", "suola", "fosfori", "seleeni", "sinkki", "tryptofaani", "folaatti", "niasiiniekvivalentti", "niasiini", "B6vitamiini", "B2vitamiini", "B1vitamiini", "B12vitamiini", "Cvitamiini", "Avitamiini", "karotenoidit", "Dvitamiini", "Evitamiini", "Kvitamiini"};
	private HashMap<String, Float> tiedot;

	public Aine(String rivi) throws NamingException {

		this.tiedot = new HashMap<String, Float>();

		String[] palat = rivi.split(";");
		int i=0;
		for (String pala : palat) {

		

			try {
				this.tiedot.put(this.selitteet[i], Float.valueOf(pala));
			} catch (NumberFormatException e) {
				//Jos syöte ei sovi float-muotoon, oletetaan että tieto on aineen nimi stringinä
				if (this.name == null) {
					this.name = pala;

					//Syöte voi myös sisältää erikoismerkkejä tai olla tyhjä	
				} else if (pala.length() == 0 || pala.equalsIgnoreCase("< 0.1") || pala.equalsIgnoreCase("< 1.0") || pala.equalsIgnoreCase("< 0.01")) {
					this.tiedot.put(this.selitteet[i], Float.valueOf(0));
					
					//Syöte voi myös sisältää anglismimuodossa numeroita 1,234.56
				} else if (pala.contains(",") && pala.contains(".")) {
						String[] commaremoved = pala.split(",");
						Float correctFormat = Float.valueOf(commaremoved[0] + commaremoved[1]);
						
						this.tiedot.put(this.selitteet[i], correctFormat);
					
				} else {
					NamingException ex = new NamingException(pala + " is malformed input.");
					throw ex;
				}
			}
			i++;
		}


		

	}
	public String toString() {
		return "ID " + this.tiedot.get("id") +  " : " + this.name;
	}




}
