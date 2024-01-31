package temp;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        permutation(list,0,2);
    }
    public static void permutation(List<Integer> list, int start, int end){
        if(start == end){
            System.out.println(list);
        }

        for(int i=start;i<=end;i++){
            swap(list,start,i);
            permutation(list,start+1,end);
            swap(list,start,i);
        }
    }

    public static void swap(List<Integer> list, int i,int j){
        int temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }
}

