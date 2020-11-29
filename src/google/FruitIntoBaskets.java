package google;

import java.util.Arrays;

public class FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        int i = 0, k = 0, j =0, max = Integer.MIN_VALUE, temp;
        int[][] map = new int[2][2];
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 2; j++) {
                map[i][j] = 0;
            }
        }
        map[0][0] = -1;
        map[1][0] = -1;
        i=0;
        for (k = 0;k<tree.length;k++){
            if (map[0][0] == tree[k]) {
                map[0][1]++;
            } else if (map[1][0] == tree[k]) {
                map[1][1]++;
            } else if (map[0][0] == -1) {
                map[0][0] = tree[k];
                map[0][1]++;
            } else if (map[1][0] == -1) {
                map[1][0] = tree[k];
                map[1][1]++;
            } else {
                temp = tree[k-1];
                if(map[0][0] == tree[k-1]){
                    map[1][0] = tree[k];
                    map[1][1] = 1;
                    map[0][1] = 0;
                    for(j=k-1;j>=i && temp==tree[j];j--){
                        map[0][1]++;
                    }
                } else{
                    map[0][0] = tree[k];
                    map[0][1] = 1;
                    map[1][1] = 0;
                    for(j=k-1;j>=i && temp==tree[j];j--){
                        map[1][1]++;
                    }
                }
            }
            if(max<map[0][1] + map[1][1]) {
                max = map[0][1] + map[1][1];
            }
        }
        return max;
    }

}
