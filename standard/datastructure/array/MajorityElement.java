package datastructure.array;

/*
The majority element is the element that appears more than ⌊n / 2⌋ times.
*/
public class MajorityElement {

    public static void main(String[] args) {
        int[] a = {1,13};
        int size = a.length;
        System.out.println(majorityElement(a,size));
    }


    static int majorityElement(int a[], int size)
    {
        if(a.length==1) return a[0];
        int count = 1;
        int maj_index=0;
        for(int i = 1; i < size; ++i) {
            if(a[maj_index] != a[i]) {
                count=count-1;
                if(count == 0) {
                    count = 1;
                    maj_index = i;
                }
            } else {
                count=count+1;
            }
        }

        int c = 0;
        for (int i = 0; i < size; i++) {
            if(a[maj_index]==a[i]) ++c;
        }
        if(c>size/2) return a[maj_index];
        return -1;
    }
}
