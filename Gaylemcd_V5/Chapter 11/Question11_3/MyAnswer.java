package Question11_3;

public class MyAnswer {

	public static int search(int a[], int left, int right, int target) {
		if (right < left) {
			return -1;
		}
		int mid = left + (right - left) / 2;
		if (a[mid] == target) {
			return mid;
		} else if (a[mid] > a[left]) {
			if (a[left] <= target && target < a[mid]) {
				return search(a, left, mid-1, target);
			} else {
				return search(a, mid+1, right, target);
			}
		} else if (a[mid] < a[left]) {
			if (a[mid] < target && target <= a[right]) {
				return search(a, mid+1, right, target);
			} else {
				return search(a, left, mid-1, target);
			}
		} else {
			if (a[mid] != a[right]) {
				return search(a, mid+1, right, target);
			} else {
				int leftRes = search(a, left, mid-1, target);
				if (leftRes == -1) {
					return search(a, mid+1, right, target);
				} else {
					return leftRes;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] a;

		a = new int[] { 2, 3, 2, 2, 2, 2, 2, 2, 2, 2 };
		System.out.println(search(a, 0, a.length - 1, 2));
		System.out.println(search(a, 0, a.length - 1, 3));
		System.out.println(search(a, 0, a.length - 1, 4));
		System.out.println(search(a, 0, a.length - 1, 1));
		System.out.println(search(a, 0, a.length - 1, 8));
		System.out.println();

		a = new int[] { 20, 55, 103, 200, 3, 5, 7, 12 };
		System.out.println(search(a, 0, a.length - 1, 3));
		System.out.println(search(a, 0, a.length - 1, 12));
		System.out.println(search(a, 0, a.length - 1, 20));
		System.out.println(search(a, 0, a.length - 1, 2));
		System.out.println(search(a, 0, a.length - 1, 45));
	}

}
