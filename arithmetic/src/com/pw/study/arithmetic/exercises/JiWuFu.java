package com.pw.study.arithmetic.exercises;

import java.util.*;

public class JiWuFu {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            Map<Integer, Integer> map = new HashMap();
            for(int i=0; i<10; i++){
                String input = scan.next();
                char[] chs = input.toCharArray();
                for(int j=0; j<chs.length; j++){
                    if(chs[j]=='1'){
                        if(map.get(j)!=null && map.get(j)>0){
                            map.put(j, map.get(j)+1);
                        }else{
                            map.put(j,1);
                        }
                    }
                }
            }
            //map中value值最小的就是最多能集齐的套数
            List list = new ArrayList(map.values());
            Collections.sort(list);
            System.out.println(list.get(0));
        }
    }

}
