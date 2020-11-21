public class CountNumbers {
    int count(int x, int y, int z){
        int count = 0;
        if(x == 0) return 0;
        if(y==0) y =1;

        for(int i=y;i<=z;i++){
            int mask1 = calculateMask((long)i);
            int mask2 = calculateMask((long)x*i);
            int flag = mask1 & mask2;
            if(flag ==0) count++;
        }
        System.out.println(count);
        return count;
    }

    int calculateMask(long num){
        int mask = 0;
        while (num > 0) {
            mask = mask | (1 << (num % 10));
            num /= 10;
        }
        return mask;
    }
}
