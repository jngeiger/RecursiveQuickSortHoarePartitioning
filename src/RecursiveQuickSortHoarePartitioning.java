import java.util.Arrays;

public class RecursiveQuickSortHoarePartitioning {
    public static void main(String[] args)
    {
        int[] array = {100,5151,23,99,3122,1};
        RecursiveQuickSortHoarePartitioning q = new RecursiveQuickSortHoarePartitioning();
        q.quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));

    }

    public void quickSort(int[] array, int l, int r)
    {
        if (r-l < 1)
        {
            return;
        }
        else {
            int pivot = _partitionHoare(array,l,r);
            quickSort(array,l,pivot);
            quickSort(array,pivot+1,r);
        }
    }

    private int _partitionHoare(int[] array,int l, int r)
    {
        int pivot = array[l];
        return _partitionHoareRec(array,l,r,pivot);
    }
    private int _partitionHoareRec(int[] array,int lidx, int ridx, int pivot)
    {
        if (lidx >= ridx)
            return ridx;
        lidx = _goUpLeft(array,lidx,ridx,pivot);
        ridx = _goDownRight(array,lidx,ridx,pivot);
        swapAtIndex(array,lidx,ridx);
        return _partitionHoareRec(array,lidx,ridx,pivot);

    }
    private int _goUpLeft(int[] array, int lidx, int ridx, int pivot)
    {
        if (array[lidx] < pivot)
            _partitionHoareRec(array,++lidx,ridx,pivot);
        return lidx;
    }

    private int _goDownRight(int[] array, int lidx, int ridx, int pivot)
    {
        if (array[ridx] > pivot)
            _partitionHoareRec(array,lidx,--ridx,pivot);
        return ridx;
    }
    private void swapAtIndex(int[] array, int one, int two)
    {
        int temp = array[one];
        array[one] = array[two];
        array[two] = temp;
    }
}
