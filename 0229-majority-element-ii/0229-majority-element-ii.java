class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int count1=0; int el1=0;
        int count2=0; int el2=0;
        int minimum = (int)(n/3)+1;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(count1==0 && nums[i]!=el2){
                count1=1;
                el1=nums[i]; //change candidate
            }else if(count2==0 && nums[i]!=el1){
                count2=1;
                el2=nums[i];
            }else if(nums[i]==el1){
                count1++;
            }else if(nums[i]==el2){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        int cnt1=0, cnt2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==el1) cnt1++;
            if(nums[i]==el2) cnt2++;
        }
        if(cnt1>=minimum){
            result.add(el1);
        }if(el2 != el1 && cnt2>=minimum){
            result.add(el2);
        }
        return result;
    }
}