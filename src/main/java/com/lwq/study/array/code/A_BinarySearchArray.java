package com.lwq.study.array.code;

public class A_BinarySearchArray {

    public static void main(String[] args) throws Exception {

        int[] nums = new int[]{-4, -2, 0, 11, 56, 78, 99};
        System.out.println(solution(nums, -4));
        System.out.println(solution(nums, 0));
        System.out.println(solution(nums, 99));
        System.out.println(solution(nums, 100));
        System.out.println("-------------------------");
        System.out.println(solution1(nums, -4));
        System.out.println(solution1(nums, 0));
        System.out.println(solution1(nums, 99));
        System.out.println(solution1(nums, 100));
        System.out.println("-------------------------");
        System.out.println(solution2(nums, 0, nums.length - 1, -4));
        System.out.println(solution2(nums, 0, nums.length - 1, 0));
        System.out.println(solution2(nums, 0, nums.length - 1, 99));
        System.out.println(solution2(nums, 0, nums.length - 1, 100));


    }

    /**
     * 二分查找数据时候：
     *  left闭空间， right闭空间
     */
    public static final int solution(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        //判断边界条件
        if(nums == null || nums[0] > target || nums[right] < target){
            return -1;
        }
        // 二分查找
        while (left <= right){
            int middle = left + (right - left) / 2; //二分的中间值
            if(nums[middle] > target){
                right = middle - 1;
            }else if(nums[middle] < target){
                left = middle + 1;
            }else{
                return middle;
            }
        }
        return -1;
    }

    /**
     * 数组二分查找
     *  使用：左闭，右开方式
     */
    public static final int solution1(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length;
        if(nums == null || nums[0] > target || nums[right - 1] < target){
            return -1;
        }
        while (left < right){
            int middle = left + (right - left) / 2;
            if(nums[middle] > target){
                right = middle;
            }else if(nums[middle] < target){
                left = middle + 1;
            }else{
                return middle;
            }
        }
        return -1;
    }

    /**
     * 数组二分查找：
     *  递归的二分查找
     * @return
     */
    public static final int solution2(int[] nums, int left, int right, int target){
        int middle = left + (right - left) / 2;
        if(nums[middle] == target){
            return middle;
        }
        if(left == right){
            return -1;
        }
        if(nums[middle] > target){
            return solution2(nums, left, middle - 1, target);
        }else{
            return solution2(nums, middle + 1, right, target);
        }
    }

}


