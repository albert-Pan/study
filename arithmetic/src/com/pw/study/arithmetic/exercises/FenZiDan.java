package com.pw.study.arithmetic.exercises;

/**
 * 在某次实弹射击训练中，班长将十个战士围成一圈发子弹。首先，班长给第一个战士10颗，
 * 第二个战士2颗，第三个战士8颗，第四个战士22颗，第五个战士16颗，第六个战士4颗，
 * 第七个战士10颗，第八个战士6颗，第九个战士14颗，第十个战士20颗。
 * 然后按如下方法将每个战士手中的子弹进行调整：所有的战士检查自己手中的子弹数，如果子弹数为奇数，
 * 则向班长再要一颗。然后每个战士再同时将自己手中的子弹分一半给下一个战士（第10 个战士将手中的子弹分一半给第1个战士）。
 * 问需要多少次调整后，每个战士手中的子弹数都相等？每人各有多少颗子弹？
 * 要求输出每轮调整后各战士手中的子弹数。
 */
public class FenZiDan {

  public static int doFenZiDan(int [] shibing){
      int len=shibing.length;
      int times=0;
      while(true){
          int [] temp=new int [len];
          for (int i = 0; i <len ; i++) {
              int val=shibing[i];
              if(val%2!=0){
                  shibing[i]=val+1;
              }
              temp[i]=shibing[i]/2;
          }

          for (int i = 0; i <len ; i++){
             int val2= shibing[i]/2;
             if(i>0) {
                 shibing[i] = val2 + temp[i-1];
             }else {
                 shibing[i]=val2 + temp[len-1];
             }
          }

          int standard=shibing[0];
          boolean isSame=true;
          for (int i = 1; i <len ; i++){
             if(standard!=shibing[i]){
                 isSame=false;
                 break;
             }
          }
          times++;
          if(isSame){
              System.out.println("使用次数"+times);
              return shibing[0];
          }

      }
  }
    public static void fenZiDan(int[]shibing){
        int total = 0;//子弹总数
        int times = 0;//次数
        int[] temp = new int[shibing.length];//临时记录士兵第一次交出子弹后的数量
        for(int i=0;i<shibing.length;i++){
            total+=shibing[i];
        }
        while(true){//循环执行任务
            times++;
            for(int i=0;i<shibing.length;i++){
                if(shibing[i]%2!=0){
                    total++;//向班长要一颗子弹
                    temp[i] = (shibing[i]+1)/2;
                }else {
                    temp[i] =shibing[i]/2;
                }
            }
            for(int i=0;i<shibing.length;i++){
                if(i>0) {
                    shibing[i] = temp[i - 1] + temp[i];
                }else {
                    shibing[i] = temp[i]+temp[temp.length-1];
                }
                if(i!=shibing.length-1){
                    System.out.print(shibing[i]+" ");
                }else {
                    System.out.println(shibing[i]+" ");
                }
            }

            if(total%shibing.length==0){//表示可以平均分,是子弹都相等的必要不充分条件,只有此时才会进行检查
                boolean isEnd = true;
                for(int i=1;i<shibing.length;i++){
                    if(shibing[0]!=shibing[i]){
                        isEnd = false;
                        break;
                    }
                }
                if(isEnd){
                    break;
                }
            }
        }
        System.out.println("总共进行了"+times+"次");
    }




    public static void main(String[] args) {
       int [] shibing=new int []{10,2,8,22,16,4,10,6,14,20};
        //System.out.println(doFenZiDan(shibing));
        fenZiDan(shibing);
    }

}
