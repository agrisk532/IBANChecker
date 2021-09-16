import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Util class is the workhorse of the project.
* Calculations and file IO is done there.
* 
* @author Agris Klimkans
* 
*/
public class Util
{
	/**
	 * Contains IBAN length by country
	 */
	private static Map<String, Integer> ibanLengthByCountry;

	static
	{
		ibanLengthByCountry = new HashMap<>();
		ibanLengthByCountry.put("AL", 28);
		ibanLengthByCountry.put("AD", 24);
		ibanLengthByCountry.put("AT", 20);
		ibanLengthByCountry.put("AZ", 28);
		ibanLengthByCountry.put("BH", 22);
		ibanLengthByCountry.put("BY", 28);
		ibanLengthByCountry.put("BE", 16);
		ibanLengthByCountry.put("BA", 20);
		ibanLengthByCountry.put("BG", 22);
		ibanLengthByCountry.put("BR", 29);
		ibanLengthByCountry.put("CH", 21);
		ibanLengthByCountry.put("CR", 22);
		ibanLengthByCountry.put("CZ", 24);
		ibanLengthByCountry.put("CY", 28);
		ibanLengthByCountry.put("DE", 22);
		ibanLengthByCountry.put("DK", 18);
		ibanLengthByCountry.put("DO", 28);
		ibanLengthByCountry.put("TL", 23);
		ibanLengthByCountry.put("EG", 29);
		ibanLengthByCountry.put("SV", 28);
		ibanLengthByCountry.put("EE", 20);
		ibanLengthByCountry.put("FO", 18);
		ibanLengthByCountry.put("ES", 24);
		ibanLengthByCountry.put("FI", 18);
		ibanLengthByCountry.put("FR", 27);
		ibanLengthByCountry.put("GB", 22);
		ibanLengthByCountry.put("GE", 22);
		ibanLengthByCountry.put("GI", 23);
		ibanLengthByCountry.put("GT", 28);
		ibanLengthByCountry.put("GR", 27);
		ibanLengthByCountry.put("HR", 21);
		ibanLengthByCountry.put("HU", 28);
		ibanLengthByCountry.put("IS", 26);
		ibanLengthByCountry.put("IQ", 23);
		ibanLengthByCountry.put("IE", 22);
		ibanLengthByCountry.put("IL", 23);
		ibanLengthByCountry.put("IT", 27);
		ibanLengthByCountry.put("JO", 30);
		ibanLengthByCountry.put("KZ", 20);
		ibanLengthByCountry.put("XK", 20);
		ibanLengthByCountry.put("KW", 30);
		ibanLengthByCountry.put("LB", 28);
		ibanLengthByCountry.put("LY", 25);
		ibanLengthByCountry.put("LI", 21);
		ibanLengthByCountry.put("LU", 20);
		ibanLengthByCountry.put("MK", 19);
		ibanLengthByCountry.put("MT", 31);
		ibanLengthByCountry.put("MR", 27);
		ibanLengthByCountry.put("MU", 30);
		ibanLengthByCountry.put("MC", 27);
		ibanLengthByCountry.put("MD", 24);
		ibanLengthByCountry.put("ME", 22);
		ibanLengthByCountry.put("NL", 18);
		ibanLengthByCountry.put("LC", 32);
		ibanLengthByCountry.put("LT", 20);
		ibanLengthByCountry.put("LV", 21);
		ibanLengthByCountry.put("NO", 15);
		ibanLengthByCountry.put("PK", 24);
		ibanLengthByCountry.put("PL", 28);
		ibanLengthByCountry.put("PS", 29);
		ibanLengthByCountry.put("PT", 25);
		ibanLengthByCountry.put("QA", 29);
		ibanLengthByCountry.put("LC", 32);
		ibanLengthByCountry.put("RO", 24);
		ibanLengthByCountry.put("SA", 24);
		ibanLengthByCountry.put("SE", 24);
		ibanLengthByCountry.put("SM", 27);
		ibanLengthByCountry.put("ST", 25);
		ibanLengthByCountry.put("RS", 22);
		ibanLengthByCountry.put("SC", 31);
		ibanLengthByCountry.put("SK", 24);
		ibanLengthByCountry.put("SI", 19);
		ibanLengthByCountry.put("TN", 24);
		ibanLengthByCountry.put("TR", 26);
		ibanLengthByCountry.put("UA", 29);
		ibanLengthByCountry.put("AE", 23);
		ibanLengthByCountry.put("VA", 22);
		ibanLengthByCountry.put("VG", 24);
	}
	
	/**
	 * 
	 * Checks if IBAN of a country is supported or not 
	 * 
	 * @param country two char ID of a country
	 * @return is country IBAN supported or not 
	 */
	public static boolean isCountryImplemented(String country)
	{
		return (ibanLengthByCountry.containsKey(country)) ? true : false;
	}
	
	/**
	 * 
	 * Get IBAN length
	 * 
	 * @param country two char ID of a country
	 * @return IBAN length for country 
	 */
	public static Integer getIBANLength(String country)
	{
		return ibanLengthByCountry.get(country);
	}

	/**
	 * 
	 * Checks IBAN length
	 * 
	 * @param iban IBAN to test
	 * @param countryCode two char ID of a country
	 * @return is IBAN length for country correct or not
	 */
	public static boolean isIBANLengthCorrect(String iban, String countryCode)
	{
		return (iban.length() == Util.getIBANLength(countryCode)) ? true : false;
	}

	/**
	 * All IBAN calculations are done here
	 * 
	 * @param iban IBAN to test
	 * @return if contains 'ok' the IBAN is correct. Otherwise not.
	 */
	public static String isIBANCorrect(String iban)
	{
		// trim spaces and make iban uppercase
		String iban1 = iban.replaceAll("\\s","").toUpperCase();
		
		if(iban1.length() == 0)
			return "Please enter IBAN";
		
		// check if IBAN of a country is implemented
		boolean b = Util.isCountryImplemented(Util.getCountryCode(iban1));
		if(!b)
			return String.format("Country %s IBAN currently not implemented.", iban);
		
		// extract the country code
		String countryCode = Util.getCountryCode(iban1);
		
		// Check if IBAN length for countryCode is correct.
		b = Util.isIBANLengthCorrect(iban1, countryCode);
		if(!b)
			return "Incorrect IBAN length";

		// converts IBAN to integer and computes mod 97
		int ret = Util.computeMod97Remainder(Util.transformIBAN(iban1));
		if(ret == 1)
			return iban + ": ok";
		else
			return iban + ": not valid";
	}

	/**
	 * Get two digit country code from IBAN
	 * 
	 * @param iban IBAN to test
	 * @return two char country code
	 */
	public static String getCountryCode(String iban)
	{
		return iban.substring(0, 2);
	}
	
	/**
	 * Converts IBAN to integer 
	 * 
	 * @param iban IBAN to test
	 * @return IBAN converted to integer
	 */
	public static String transformIBAN(String iban)
	{
		iban = moveFirstFourChars(iban);
		iban = convertToInteger(iban);
		return iban;
	}
	
	/**
	 * Move the four initial IBAN characters to the end of the string
	 * 
	 * @param iban IBAN to test
	 * @return Rearranged IBAN
	 */
	public static String moveFirstFourChars(String iban)
	{
		// 
		String s4 = iban.substring(0,4);
		String sm = iban.replaceFirst(s4, ""); 
		return sm + s4;
	}
	
	/**
	 * Replace each letter in the rearranged IBAN with two digits, 
	 * thereby expanding the string, where A = 10, B = 11, ..., Z = 35
	 * 
	 * @param s rearranged IBAN 
	 * @return converted IBAN
	 */
	public static String convertToInteger(String s)
	{
        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer();

        for (char ch: chars)
        {
        	if(Character.isLetter(ch))
        	{
        		// since ascii of 'A' is 65, of 'a' is 97
                int ascii = (int)ch - 55; 
                String str = Integer.toString(ascii);
        		sb.append(str);
        	}
        	else
        	{
        		sb.append(ch);
        	}
        }
        return sb.toString();
	}
	
	/**
	 * Computes mod 97 of the converted IBAN
	 * 
	 * @param str converted IBAN
	 * @return 1 if IBAN is correct
	 */
	public static int computeMod97Remainder(String str)
	{
		String sr = "";
		int end_pos = 9;
		boolean last = false;
		
		while(true)
		{
			String s = str.substring(0, end_pos);
			int i = Integer.parseInt(s);
			sr = Integer.toString(i % 97);
			if(last)
			{
				break;
			}
			str = str.replaceFirst(s, sr);
			if(end_pos > str.length())
			{
				end_pos = str.length();
				last = true;
			}
		}
		return Integer.parseInt(sr);
	}
	
	/**
	 * Reads list of IBANs from file
	 * 
	 * @param istream InputStream to read from
	 * @return List list with IBANs 
	 * @throws IOException in case of IO problems
	 */
	public static List<String> readFromInputStream(InputStream istream) throws IOException
	{
		ArrayList<String> list = new ArrayList<String>();
        try
        {
            if (istream != null)
            {
                InputStreamReader isr = new InputStreamReader(istream);
                BufferedReader br = new BufferedReader(isr);
                String st;
                while ((st = br.readLine()) != null)
                {
                	st = st.trim();
                	if(st.length() > 0)
                		list.add(st);
                }
            }
            else
            {
            	list.add("InputStream is null");
            }
        }
        finally
        {
        }
		return list;
	}
}
