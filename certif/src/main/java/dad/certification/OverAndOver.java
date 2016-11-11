package dad.certification;

public class OverAndOver {

	static String s = "";

	public static void main(String[] args) {
		try {
			s += "1";
			throw new Exception();
		} catch (Exception e) {
			s += "2";
		} finally {
			s += "3";
			doStuff();
			s += "4";
		}
		System.out.println(s);
	}

	static void doStuff() {
		int x = 0;
		int y = 7 / x;
	}
}

//A. 12
//B. 13
//C. 123
//D. 1234
//E. 123 suivi d'une exception
//F. 1234 suivi d'une exception
//G. une exception est jetée
