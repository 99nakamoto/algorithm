package algo.questions;

public class JsonPrettifier {

	public static void main(String[] args) {
		JsonPrettifier ins = new JsonPrettifier();
		String input = "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"isAlive\":true,\"age\" :25,\"height_cm\":167.6,\"address\":{\"streetAddress\":\"212ndStre et\",\"city\":\"NewYork\",\"state\":\"NY\",\"postalCode\":\"10021-3100\" },\"phoneNumbers\":[{\"type\":\"home\",\"number\":\"212555-1234\"},{\" type\":\"office\",\"number\":\"646555-4567\"}],\"children\":[],\"spou se\":null}";
		System.out.println("Input: ");
		System.out.println(input);

		System.out.println("Output: ");
		System.out.println(ins.prettify(input));
	}

	public String prettify(String input) {
		StringBuilder sb = new StringBuilder();

		return sb.toString();
	}
}
