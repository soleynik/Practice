package FB;

public class KthLargestElementInArray {

    static int findKthLargest(int[] a, int k){
        k = a.length - k;
        int l = 0;
        int r = a.length - 1;
        while(l<r){
            int mid = partition(a,l,r);
            if(k < mid)
                r = mid -1;
            else if(k > mid)
                l = mid + 1;
            else
                break;

        }
        return a[k];
    }

    static int partition(int[] a, int l, int r){
        int pivot = a[r];
        int i = l;
        for(int j = l; j < r; j++){
            if(a[i] < pivot){
                int temp = a[i];
                a[i++] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[i];
        a[i] = a[pivot];
        a[pivot] = temp;
        return i;
    }

    public static void main(String[] args) {
        int[] a = {3,2,1,5,6,4};
        System.out.println(findKthLargest(a,2));

        int[] a1 = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(a1,4));
    }
}
