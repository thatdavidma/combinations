class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start){
        if (remain < 0){ return; } // break because the sum is larger than the target
        else if (remain == 0){ list.add(new ArrayList<>(tempList)); } // we found that the sum is the same as target
        else {
            for (int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // i because we can use duplicates
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
