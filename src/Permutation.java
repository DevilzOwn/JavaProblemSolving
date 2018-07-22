public class Permutation {
    static int count =0;
    private int[] swap(int[] A,int i,int j){
        int temp;
        temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        return A;
    }
    public void permutations(int[] A, int start, int end){
        int n=A.length, i,j, temp;
        if(start == end){
            for(j=0;j<A.length;j++){
                System.out.print(A[j]);
                count++;
            }
            System.out.println(" " + count);
        }
        for(i=start;i<=end;i++){
            A = swap(A, start, i);
            permutations(A, start+1, end);
            A = swap(A, i, start);
        }
    }


}
