package bloomberg;

public class Quicksort {
	public void quicksort(int[] nums, int left, int right) {
		if (right <= left) {
			return;
		}
		int pivot = nums[left + (right - left) / 2];
		int i = left;
		int j = right;
		while (i <= j) {
			while (nums[i] < pivot) {
				i++;
			}
			while (nums[j] > pivot) {
				j--;
			}
			if (i <= j) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
				j--;
			}
		}
		if (j > left) {
			quicksort(nums, left, j);
		}
		if (i < right) {
			quicksort(nums, i, right);
		}
	}
}
