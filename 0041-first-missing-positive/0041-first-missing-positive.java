class Solution {
    public int firstMissingPositive(int[] nums) {
        int i=0;


        //값 == 위치가 되도록 정리한다.
        //이때 값 주어진 배열의 길이보다 크거나, 음수인 경우에는 정해진 자리가 없기 때문에 건너뛴다.
        while(i<nums.length){
            if(nums[i]>0 && nums[i]<nums.length && i != nums[i]-1){ //양수이고, 값이 배열의 길이보다 작고, 아직 정렬이 안되어 있는 경우에만

                int tmp = nums[nums[i]-1];
                
                //swap할 대상들이 동일하면 건너뛴다.
                if(tmp == nums[i]){
                    i++;
                    continue;
                }else{
                    //swap
                    nums[nums[i]-1]=nums[i];
                    nums[i]=tmp;
                }
            }else{  
                i++;
            }
        }

        //정리 후,
        //정해진 위치에 그 숫자가 없다면 해당 숫자가 가장 작은 없는 양수가 된다.
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j+1){
                return j+1;
            }
        }
        //모두 값==위치로 정리되어 있다면, 길이+1을 반환
        return nums.length+1;
    }
}