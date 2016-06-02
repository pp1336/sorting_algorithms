package bloomberg;

public class Countingsort {
	// this version is for numbers only, not stable
	public void countingsort(int[] nums) {
		// find min and max
		int l = nums.length;
		if (l == 0) {
			return;
		}
		int min = nums[0];
		int max = min;
		for (int i = 1; i < l; i++) {
			if (nums[i] < min) {
				min = nums[i];
			}
			if (nums[i] > max) {
				max = nums[i];
			}
		}
		
		//create range
		int range = max - min + 1;
		int[] arr = new int[range];
		for (int i = 0; i < l; i++) {
			arr[nums[i] - min] += 1;
		}
		
		// write num
		int j = 0;
		for (int i = 0; i < range; i++) {
			if (arr[i] > 0) {
				for (int k = 0; k < arr[i]; k++) {
					nums[j] = i + min;
					j++;
				}
			}
		}
	}
}
