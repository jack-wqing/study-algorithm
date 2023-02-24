package com.lwq.study.array.code;

public class B_RemoveElementArray {

    public static void main(String[] args){
        int[] nums = new int[]{1, 2, 2, 4, 7, 6, 6, 10, 3};
        System.out.print("长度为：" + solution(nums, 2) + "元素详情为:");
        for (int ele : nums) {
            System.out.print(ele + ",");
        }
        System.out.println("------------------------------");
        int[] nums1 = new int[]{1, 2, 2, 4, 7, 6, 6, 10, 3};
        System.out.print("长度为：" + solution1(nums1, 2) + "元素详情为:");
        for (int ele : nums1) {
            System.out.print(ele + ",");
        }
        System.out.println();

    }

    /**
     * 暴力破解元素
     */
    public static int solution(int[] nums, int target){
        int length = nums.length;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] == target){   //如果元素相等，需要删除，删除需要移动元素
                for (int j = i + 1; j < nums.length; j++) {
                    nums[j - 1] = nums[j];
                }
                i--;
                length--;
            }
        }
        return length;
    }

    /**
     * 二指针发操作元素
     *  原址操作：通过快慢指针来查询：
     *      快指针：寻找新数组的元素，新数组的就是不含有目标元素的数组
     *      慢指针：指向更新，新数组下标的未知
     */
    public static int solution1(int[] nums, int target){
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if(nums[fastIndex] != target){
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }

}
