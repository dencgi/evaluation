package dad.certification;

class Plane {
	static String s = "-";

	public static void main(String[] args) {
		new Plane().s1();
		System.out.println(s);
	}

	void s1() {
		try {
			s2();
		} catch (Exception e) {
			s += "c";
		}
	}

	void s2() throws Exception {
		s3();
		s += "2";
		s3();
		s += "2b";
	}

	void s3() throws Exception {
		throw new Exception();
	}
}

// A. -
// B. -c
// C. -c2
// D. -2c
// E. -c22b
// F. -2c2b
// G. -2c2bc
