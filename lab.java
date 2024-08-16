public class lab {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Enter correct argument");
		} else {
			if (args[0].equals("square") && args.length == 2)
				;
			{
				int l = Integer.parseInt(args[2]);
				System.out.println("Area is:" + (l * l));
			}
		}
	}
}
