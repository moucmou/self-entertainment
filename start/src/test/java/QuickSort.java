/**
 * @author AmazingZ
 * @date 2019/4/29 13:54
 */
public class QuickSort {

    private static void sort(int []temp,int start,int end){

        int i=start;
        int j=end;
        if(i>=j) return;

        int tem=temp[i];
        while (i<j){
            while (i<j&&temp[j]>=tem){
                j--;
            }
            temp[i]=temp[j];
            while (i<j&&temp[i]<=tem){
                i++;
            }
            temp[j]=temp[i];
        }
        temp[i]=tem;
        sort(temp,start,i-1);
        sort(temp,i+1,end);
    }

    public static void main(String[] args) {

        int []temp=new int[]{ 3,7,9,4,1,3,6,6,5};
        sort(temp,0,8);
        System.out.println();
    }
}
