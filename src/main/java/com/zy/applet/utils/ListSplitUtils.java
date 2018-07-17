package com.zy.applet.utils;

import java.util.ArrayList;
import java.util.List;

public class ListSplitUtils {

    public static List<List>  createList(List targe,int size) {
        List<List> listArr = new ArrayList<List>();
        //获取被拆分的数组个数
        int arrSize = targe.size()%size==0?targe.size()/size:targe.size()/size+1;
        for(int i=0;i<arrSize;i++) {
            List sub = new ArrayList();
            //把指定索引数据放入到list中
            for(int j=i*size;j<=size*(i+1)-1;j++) {
                if(j<=targe.size()-1) {
                    sub.add(targe.get(j));
                }
            }
            listArr.add(sub);
        }
        return listArr;
    }


}
