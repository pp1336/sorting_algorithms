package bloomberg;

public class Heapsort {
	public void heapsort(int[] nums) {
		if (nums.length == 0) {
			return;
		}
		
		
		
		for (int i = 0; i < nums.length; i++) {
			// heap insert max heap
			int current = i;
			while (current > 0) {
				//System.out.println("current = " + current);
				int parent = (current - 1) / 2;
				//System.out.println("parent = " + parent);
				if (nums[parent] < nums[current]) {
					// swap with parent
					int temp = nums[parent];
					nums[parent] = nums[current];
					nums[current] = temp;
					// current = parent
					current = parent;
				} else {
					break;
				}
			}
		}
		
		
		// swap and rebuild
		for (int last = nums.length - 1; last > 0; last--) {
			int temp = nums[last];
			nums[last] = nums[0];
			nums[0] = temp;
			// heap rebuild
			int current = 0;
			int left_child = 1;
			int right_child = 2;
			while(left_child < last) {
				int max = left_child;
				if (right_child < last && nums[right_child] > nums[left_child]) {
					max = right_child;
				}
				if (nums[current] < nums[max]) {
				    int inner_temp = nums[current];
				    nums[current] = nums[max];
				    nums[max] = inner_temp;
				    
				    current = max;
				    left_child = max * 2 + 1;
				    right_child = left_child + 1;
				} else {
					break;
				}
			}
		}
	}
}
