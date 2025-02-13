class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    // list is the result we are appending to
    // tempList is the individual lists that add up to the target
    // nums is the original candidates
    // remain is the temporary integer we are looking for or trying to add up to
    // target is the sum that we want to find
    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start){
        if (remain < 0){ return; } // sum is too large
        else if (remain == 0){ list.add(new ArrayList<>(tempList)); } // found a combination that works
        else {
            for (int i = start; i < nums.length; i++){
                if (i > start && nums[i] == nums[i-1]){ continue; }
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain-nums[i], i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
