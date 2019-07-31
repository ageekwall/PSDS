public class SearchinRotatedArray {
    public SearchinRotatedArray() {
    }

    public static void main(String[] args) {
        SearchinRotatedArray s = new SearchinRotatedArray();
        int lo =0 ;
        int hi = 8;
        int a[] = new int[]{7,8,9,1,2,3,4,5,6};
        int d = s.findPivot(a,lo, hi);
        System.out.println(d);
        int ans= s.bin_search(a,lo,d,6);
        int ans1 = s.bin_search(a,d+1,hi,6);
        System.out.println(ans +" "+ ans1);
    }

    public  int findPivot(int [] arr, int lo, int hi) {
        if(lo > hi) return -1;
        int mid =( lo+hi )/2;
        if(mid < hi && arr[mid] > arr[mid+1]) {
            return mid;
        }
        if(mid > lo && arr[mid-1] > arr[mid]) {
            return mid;
        }
        if(arr[lo] > arr[mid]) {
            return findPivot(arr,lo,mid);
        }
        return findPivot(arr,mid, lo);
    }
    public int bin_search(int [] arr, int lo, int hi, int v) {
        if(lo > hi) return -1;
        int mid =(lo+hi )/2;
        if(arr[mid] == v) return mid;
        if(arr[mid] > v) return bin_search(arr,lo,mid-1,v);
        return bin_search(arr,mid+1,hi,v);

    }
}
