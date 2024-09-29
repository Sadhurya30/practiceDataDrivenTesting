package practicedatadriventesting;

public class GenerateAlphaNumericRandomData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=15;
		//it is used for random generating of alphabets from a particular string
		//choose a character random from this string
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
		
		//create StringBuffer size of Alphanumeric string
		StringBuilder sb = new StringBuilder(n);

		for(int i=0;i<n;i++)
		{
			//generate a random number between 0 to alphanumeric string variable length
			int index = (int)(AlphaNumericString.length()*Math.random());
			
			//add  character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}
		System.out.println(sb);
	}

}
