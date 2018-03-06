import java.util.ArrayList;
import java.util.Arrays;

import javax.security.auth.x500.X500Principal;

public class Merge_sort {
	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 7 };
		int[] b = { 2, 4, 6, 8 };
		int[] c = merge(a, b);
		System.out.println(Arrays.toString(c));
		int[] e = { 234,34,21,45,1,36,65,100};
		int[] d = sort1(e);
		System.out.println(Arrays.toString(d));
	}

	/**归并算法
	 * @param a
	 * @param b
	 * @return
	 */
	public static int[] merge(int[] a, int[] b) {
		int i = 0;
		int j = 0;
		if (a == null) {
			if (b != null) {
				return b;
			} else {
				return null;
			}
		} else if (b == null) {
			return a;
		}
		int[] c = new int[a.length + b.length];
		while (true) {
			if (a[i] < b[j]) {
				c[i + j] = a[i];
				i++;
			} else {
				c[i + j] = b[j];
				j++;
			}
			if (i == a.length) {
				break;
			}
			if (j == b.length) {
				break;
			}
		}
		if (j < b.length) {
			for (int x = j; x <= b.length - 1; x++) {
				c[i + x] = b[x];
			}
		}
		if (i < a.length) {
			for (int x = i; x <= a.length - 1; x++) {
				c[j + x] = a[x];
			}
		}
		return c;
	}

	/**
	 * 递归版归并排序
	 * 
	 * @param a
	 * @return
	 */
	public static int[] sort(int[] a) {
		if (a.length <= 1) {
			return a;
		}
		int mid = a.length / 2;
		int[] left = new int[mid];
		int[] right = new int[a.length - mid];
		for (int i = 0; i < mid; i++) {
			left[i] = a[i];
		}
		for (int i = mid; i < a.length; i++) {
			right[i - mid] = a[i];
		}
		left = sort(left);
		right = sort(right);
		return merge(left, right);
	}

	/**迭代版归并排序
	 * @param a
	 * @return
	 */
	public static int[] sort1(int[] a) {
		int step = 1;
		int[] k = null;
		int[] q = null;
		int[] p = null;
		while (step < a.length) {
			int hi = step << 1;
			for (int i = 0; i < a.length; i += hi) {
				p=null;
				q=null;
				if (i != a.length - 1 && i < a.length) {
					p = Arrays.copyOfRange(a, i, i + step);
				} else {
					p = new int[] { a[i] };
				}
				if (i + step != a.length - 1 && i + step < a.length) {
					q = Arrays.copyOfRange(a, i + step, i + hi);
				} else {
					p = new int[] { a[i] };
				}
				k = merge(p, q);
				int o = i;
				for (int x : k) {
					a[o] = x;
					o++;
				}
			}
			step = hi;
		}
		return a;
	}
}
