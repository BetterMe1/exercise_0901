package exercise.exercise_0831;

/**
 * @Description:360笔试
 * @Author:Anan
 * @Date:2019/8/31
 */

/**
 * 寻找子串
 */

/*
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] count = new int[26];
        for(int i=0; i<str.length(); i++){
            count[str.charAt(i)-'a']++;
        }
        int max = count[0];
        for(int i=0; i<count.length; i++){
            if(count[i]>max){
                max = count[i];
            }
        }
        System.out.println(max);
    }
}
*/

//散步
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] num = new int[M];
        for(int i=0; i<M; i++){
            num[i] = sc.nextInt();
        }
        boolean[] result = new boolean[N];
        for(int i=0; i<N; i++){//站的位置
            Queue<Integer> queue = new LinkedList<>();
            if(0<=i+num[0] && i+num[0]<N){
                queue.offer(i+num[0]);
            }
            if(0<=i-num[0] && i-num[0]<N){
                queue.offer(i-num[0]);
            }
            for(int j=1; j<M; j++){
                int len = queue.size();
                for(int k=0; k<len; k++){
                    int n = queue.poll();
                    if(0<=n+num[j] && n+num[j]<N){
                        queue.offer(n+num[j]);
                    }
                    if(0<=n-num[j] && n-num[j]<N){
                        queue.offer(n-num[j]);
                    }
                }
            }
            while (!queue.isEmpty()){
                int n = queue.poll();
                if(0<=n && n<N){
                    result[n] = true;
                    break;
                }
            }
        }
        int count = 0;
        for(int i=0; i<result.length; i++){
            if(result[i]){
                count++;
            }
        }
        System.out.println(count);
    }
}