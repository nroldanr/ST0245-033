
/**
 * Write a description of class EjerciciosEnLinea here.
 *
 * @author Esteban Quintero y Nicolas Roldan
 * @version Marzo 2018
 */
public class EjerciciosEnLinea
{
 //Array 2   
 public int sum13(int[] nums) {
  int cont = 0;
  if(nums.length == 0){
    return 0;
  } else {
  for(int i = 0; i<nums.length; i++){
    if(nums[i] != 13){
      cont += nums[i];
    } else {
      i++;
    }
   }
  }
  return cont;
 }
  public boolean has22(int[] nums) {
  for(int i = 0; i < nums.length-1; i++){
    if(nums[i] == 2 && nums[i+1] == 2){
      return true;
    } 
  } return false;
 }
 public boolean sum28(int[] nums) {
  int cont = 0;
  for(int i = 0; i < nums.length; i++){
    if(nums[i] == 2){
      cont += 2;
    }
  } if(cont == 8){
    return true;
  } return false;
 }
 public int[] fizzArray(int n) {
  int [] nums = new int[n];
  for(int i = 0; i < nums.length; i++){
    nums[i] = i;
  }
  return nums;
 }
 public boolean haveThree(int[] nums) {
  int cont = 0;
  for (int i = 0; i < nums.length-1; i++){
    if (nums[i] == 3 && nums[i+1] != 3){
      cont++;
    } else if (nums[i] == 3 && nums[i+1] == 3){
      return false;
    }
  }
  if (nums.length > 2){
    if (nums[nums.length-1] == 3 && nums[nums.length-2] != 3){
      cont++;
    }
  }
  if (cont == 3){
    return true;
  }
  return false;
 }
 //Array 3
 public int maxSpan(int[] nums) {
  int max = 0;
  for (int i = 0; i < nums.length; i++){
    for (int j = nums.length - 1; j > i; j--){
       if (nums[j]==nums[i]){
            if (j - i + 1 > max){
               max = j-i + 1;
            }
       }
    }
  }
  if (max == 0 && nums.length != 0){
    return 1;
  }
  return max;
 }
 public int[] fix45(int[] nums) {
  int VTemp = 0;
  for (int i = 0; i < nums.length; i++) {
     if (nums[i] == 4) {
        for (int j = 0; j < nums.length; j++) {
           if (nums[j] == 5) {
              if (j > 0 && nums[j-1] != 4) {
                 VTemp = nums[i+1];
                 nums[i+1] = 5;
                 nums[j] = VTemp;
              } 
              else if (j == 0) {
                 VTemp = nums[i+1];
                 nums[i+1] = 5;
                 nums[j] = VTemp;
              }
           }
        }
     }
  }
  return nums;
 }
 public boolean linearIn(int[] outer, int[] inner) {
  int nums = 0;
  for (int i = 0; i < inner.length; i++){
     for (int j = 0; j < outer.length; j++){
        if (inner[i] == outer[j]){
             nums++;
             break;
        }
     } 
  }
  if (nums == inner.length){
      return true;
  } else {
      return false;
  }
 }
 public int[] seriesUp(int n) {
  int[] nums = new int [n*(n + 1)/2];
  int pos = 0;
  for (int i = 0; i <= n; i++){
     for (int j = 1; j <= i; j++){
            nums[pos] = j;
            pos++;
     }
  }
  return nums;
 }
 public int countClumps(int[] nums) {
  int cont = 0;
  for (int i = 1; i < nums.length-1; i++){
     if (nums[i-1] == nums[i]){

     } else if (nums[i+1] == nums[i]) {
         cont++;
     }
  }
  if (nums.length == 0){
      return 0;
  }
  if (nums[0] == nums [1]){
      cont++;
  }
  return cont;
 }
}
