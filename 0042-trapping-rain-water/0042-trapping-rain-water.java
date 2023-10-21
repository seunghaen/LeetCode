class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int leftMax = height[left];
        int rightMax = height[right];
        int answer = 0;

        //투포인터를 이용한 문제풀이

        
        while(left<right){
        //오른쪽과 왼쪽 중 더 작은 높이의 index를 움직인다.
            if(leftMax<=rightMax){ //왼쪽 최대높이가 큰경우
                left++;
                if(leftMax<height[left]){ //새로운 최대 높이를 갱신하거나,
                    leftMax = height[left];
                } else{ //갱신하지 못할 경우 그 차이만큼 answer를 증가
                    answer += (leftMax-height[left]);
                }
            } else{ //오른쪽 최대 높이가 큰경우
                right--;
                if(rightMax<height[right]){//새로운 최대 높이를 갱신하거나,
                    rightMax = height[right];
                } else{//갱신하지 못할 경우 그 차이만큼 answer를 증가
                    answer += (rightMax - height[right]);
                }
            }
        }
        return answer;
    }
}