package Question17_13;

public class MyAnswer {

	public static BiNode convert(BiNode root) {
		return root;
	}

	public static void main(String[] args) {
		BiNode root = QuestionC.createTree();
		QuestionC.printAsTree(root, "");
		BiNode r = convert(root);
		QuestionC.printLinkedListTree(r);
	}

}
