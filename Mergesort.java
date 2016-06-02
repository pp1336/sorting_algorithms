package bloomberg;

public class Mergesort {
	public int[] mergesort(int[] nums) {
		int l = nums.length;
		if (l <= 1) {
			return nums;
		}
		if (l == 2) {
			int x = nums[0];
			int y = nums[1];
			if (x > y) {
				nums[0] = y;
				nums[1] = x;
			}
			return nums;
		}
		
		int m = l / 2;
		int[] left = new int[m];
		int[] right = new int[l - m];
		
		// split array
		int i;
		int j = 0;
		int k = 0;
		for (i = 0; i < l; i++) {
			if (i < m) {
				left[j] = nums[i];
				j++;
			} else {
				right[k] = nums[i];
				k++;
			}
		}
		
		int[] a = mergesort(left);
		int[] b = mergesort(right);
		
		i = 0;
		j = 0;
		k = 0;
		while(k < l) {
			if (j >= b.length) {
				// only a has element left
				while (i < a.length) {
					nums[k] = a[i];
					k++;
					i++;
				}
			} else if (i >= a.length) {
				// only b has element left
				while(j < b.length) {
					nums[k] = b[j];
					k++;
					j++;
				}
			} else {
				// both have element left
				if (a[i] <= b[j]) {
					nums[k] = a[i];
					i++;
				} else {
					nums[k] = b[j];
					j++;
				}
				k++;
			}
		}
		return nums;
	}
}
