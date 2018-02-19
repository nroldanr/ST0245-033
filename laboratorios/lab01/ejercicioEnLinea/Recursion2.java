
/**
 * Write a description of class Recursion2 here.
 *
 * @author Esteban Quintero y Nicolas Roldan
 * @version Febrero 2018
 */
public class Recursion2
{
   public boolean groupSum5(int start, int[] nums, int target) {
  if(start >= nums.length){                                   //C1
  return target == 0;                                         //C2
  }
  if(nums[start] % 5 == 0){                                   //C3
  if(start + 2 <= nums.length && nums[start + 1] == 1){       //C4
  nums[start+1] = 0;  //C5
  }
  return groupSum5(start + 1, nums, target - nums[start]);    //T(n-1)
  } else {                                                    //C6
  return groupSum5(start + 1, nums, target - nums[start]) ||  //T(n-1)
  groupSum5(start + 1, nums, target);                         //T(n-1)
  }
 }
 
 public boolean groupSum6(int start, int[] nums, int target) {
  if(start >= nums.length){                                   //C1
  return target == 0;                                         //C2
  }
  if(nums[start] % 6 == 0){                                   //C3
  return groupSum6(start + 1, nums, target - nums[start]);    //T(n-1)
  } else {
  return groupSum6(start + 1, nums, target - nums[start]) ||  //T(n-1)
  groupSum6(start + 1, nums, target);                         //T(n-1)
  }
 }
 
 public boolean groupNoAdj(int start, int[] nums, int target) {
  if(start >= nums.length){                                    //C1
  return target == 0;                                          //C2
  }
  return groupNoAdj(start + 2, nums, target - nums[start]) ||  //T(n-2) 
  groupNoAdj(start + 1, nums, target);                         //T(n-1)
 }
 
 public boolean groupSumClump(int start, int[] nums, int target) {
  if (start >= nums.length){                                        //C1
  return target == 0;                                               //C2
  }
  int i;                                                            //C3
  int sum = 0;                                                      //C4
  for (i = start; i < nums.length && nums[i] == nums[start]; i++){  //C5*n
   sum += nums[i];                                                  //C6*n
  }
  nums[start] = sum;                                                //C7
  return groupSumClump(i, nums, target - nums[start]) ||            //T(n-1)
  groupSumClump(i, nums, target);                                   //T(n-1)
 }
 
 public boolean splitArray(int[] nums) {
  return splitArray2(0, nums, 0, 0);                                  //C1
 }
 public boolean splitArray2(int start, int[] nums, int g1, int g2) {
  if(start >= nums.length){                                           //C2
  return g1 == g2;                                                    //C3
  }
  return splitArray2(start+1, nums, g1 + nums[start], g2) ||          //T(n-1)
  splitArray2(start+1, nums, g1, g2 + nums[start]);                   //T(n-1)
 }
}
