package datastructure.array;

/*
The majority element is the element that appears more than ⌊n / 2⌋ times.
Moore's voting algorithm:
If a majority element exists then other elements' count will be less than n/2.
If we start with 1st element as candidate and count as 1, and we increment the count if we find
the same candidate element, and we decrement count if it is a different element. If the count becomes
0 this means that till that index we don't have majority element for sure because if it was there
then count would not have been 0. Example, [7,7,5,3 ....] till index 3, the candidate element is 7 and
count goes 1,2,1,0 --> as count becomes 0, it means 7 didn't occur more than n/2 otherwise the count wouldn't have
cancelled. So, we repeat the process and start with count =1 and candidate element = a[4] and so on..

youtube: https://www.youtube.com/watch?v=nP_ns3uSh80 , starts from time: 7.49

*/
public class MajorityElement {


    public static void majorityElement(int[] a) {
        int count = 0;
        int candidate = a[0];
        for (int i = 0; i < a.length; i++) {
            if (count == 0) {
                candidate = a[i];
                count = 1;
            } else {
                if (a[i] != candidate) --count;
                else ++count;
            }
        }

        int c = 0;
        for (int i = 0; i < a.length; i++) {
            if(candidate==a[i]) ++c;
        }
        if(c>a.length/2) System.out.println("majority element: "+candidate);
        else System.out.println("majority element: "+ -1);
        //then check count of candidate element in array if more than n/2 then it is ans

    }

    public static void main(String[] args) {
        int[] a = {1,13};
        int[] b = {7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5};
        majorityElement(b);
    }
}
