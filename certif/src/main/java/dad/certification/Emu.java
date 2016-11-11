package dad.certification;

class Emu {
	static String s = "-";

	public static void main(String[] args) {
		try {
			throw new Exception();
		} catch (Exception e) {
			try {
				try {
					throw new Exception();
				} catch (Exception ex) {
					s += "ic ";
				}
				throw new Exception();
			} catch (Exception x) {
				s += "mc ";
			} finally {
				s += "mf ";
			}
		} finally {
			s += "of ";
		}

		System.out.println(s);
	}
}

// A. -ic of
// B. -mf of
// C. -mc mf
// D. -ic mf of
// E. -ic mc mf of
// F. -ic mc of mf
