package com.example.suts.mytestapplication1.component.recyclerview;

import com.example.suts.mytestapplication1.component.recyclerview.adapter.MultiItemRecylerViewAdapter;
import com.example.suts.mytestapplication1.component.recyclerview.bean.Ball;
import com.example.suts.mytestapplication1.component.recyclerview.bean.Birds;
import com.example.suts.mytestapplication1.component.recyclerview.bean.MySection;
import com.example.suts.mytestapplication1.component.recyclerview.bean.StarPeople;
import com.example.suts.mytestapplication1.component.recyclerview.bean.StarPeopleMultiItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suts on 2017/8/31.
 */

public class RecyclerViewDataServer {

    public static List<Birds> getBirdDataList(){
        List<Birds> list = new ArrayList<>();
        list.add(new Birds("大熊猫", "China", "http://img1.imgtn.bdimg.com/it/u=1495426651,3979437573&fm=214&gp=0.jpg", 1001));
        list.add(new Birds("袋鼠", "Australian", "http://img3.imgtn.bdimg.com/it/u=3910572047,3453464126&fm=26&gp=0.jpg", 1002));
        list.add(new Birds("棕熊", "US", "http://img3.imgtn.bdimg.com/it/u=3261250543,1622072640&fm=26&gp=0.jpg", 1003));
        list.add(new Birds("眼镜蛇", "India", "http://tx.haiqq.com/uploads/allimg/150323/150P54a9-3.jpg", 1004));
        return list;
    }

    public static List<MySection> getSectionDataList(){
        List<MySection> list = new ArrayList<>();
        list.add(new MySection(true, "篮球"));

        list.add(new MySection(new Ball("篮球", "斯伯丁", "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=483537394,3698489359&fm=26&gp=0.jpg", "美国", 1008)));
        list.add(new MySection(new Ball("篮球", "李宁篮球", "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3232506039,4016468718&fm=26&gp=0.jpg", "中国", 1009)));
        list.add(new MySection(new Ball("篮球", "安踏篮球", "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3305921507,4032821659&fm=26&gp=0.jpg", "中国", 1010)));
        list.add(new MySection(true, "皮球"));
        list.add(new MySection(new Ball("皮球", "西瓜色皮球", "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3426287620,2324539817&fm=26&gp=0.jpg", "中国", 1011)));
        list.add(new MySection(true, "乒乓球"));
        list.add(new MySection(new Ball("乒乓球", "乒乓球", "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2455662099,2969274027&fm=26&gp=0.jpg", "中国", 1012)));

        return list;
    }

    public static List<StarPeopleMultiItem> getMultiItemDataList(){
        List<StarPeopleMultiItem> list = new ArrayList<>();
        list.add(new StarPeopleMultiItem(new StarPeople("范冰冰", "女人", "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=876039821,1890194087&fm=26&gp=0.jpg"), MultiItemRecylerViewAdapter.TYPE_1));
        list.add(new StarPeopleMultiItem(new StarPeople("赵丽颖", "女人", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2274113631,4058512382&fm=26&gp=0.jpg"), MultiItemRecylerViewAdapter.TYPE_1));
        list.add(new StarPeopleMultiItem(new StarPeople("杨幂", "女人", "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2088373044,4137871296&fm=11&gp=0.jpg"), MultiItemRecylerViewAdapter.TYPE_2));
        list.add(new StarPeopleMultiItem(new StarPeople("唐嫣", "女人", "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1910242785,133556208&fm=26&gp=0.jpg"), MultiItemRecylerViewAdapter.TYPE_1));
        list.add(new StarPeopleMultiItem(new StarPeople("高圆圆", "女人", "https://ss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D220/sign=792a7d82ae0f4bfb93d09956334f788f/a8ec8a13632762d00c2bb6a2aaec08fa513dc692.jpg"), MultiItemRecylerViewAdapter.TYPE_2));
        list.add(new StarPeopleMultiItem(new StarPeople("郑爽", "女人", "https://gss2.bdstatic.com/9fo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike150%2C5%2C5%2C150%2C50/sign=658b6bc18082b90129a0cb6112e4c212/f3d3572c11dfa9ec206416f168d0f703908fc18a.jpg"), MultiItemRecylerViewAdapter.TYPE_1));

        return list;
    }


}
