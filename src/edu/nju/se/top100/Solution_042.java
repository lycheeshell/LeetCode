package edu.nju.se.top100;

/**
 * 接雨水
 * 
 * @author zongk
 *
 */
public class Solution_042 {

	public int trap(int[] height) {
        int maxIndex=0;//最高位置
        for (int i = 0; i < height.length; i++) {
            if(height[maxIndex]<height[i]){
                maxIndex=i;
            }
        }
        int result=0;
        int aHighSide=0;//另一高边
        for (int i = 0; i < maxIndex; i++) {
            if(height[i]>aHighSide){
                aHighSide=height[i];
            }else{
                result+=aHighSide-height[i];
            }
        }
        aHighSide=0;
        for (int i=height.length-1;i>maxIndex;i--){
            if(height[i]>aHighSide){
                aHighSide=height[i];
            }else{
                result+=aHighSide-height[i];
            }
        }
        return result;
    }

	public static void main(String[] args) {
		int[] height = {5,2,1,2,1,5};
		System.out.println(new Solution_042().trap(height));
	}

}
