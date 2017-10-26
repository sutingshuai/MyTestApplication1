package com.example.suts.mytestapplication1.myviews.game2048;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;


import com.example.suts.mytestapplication1.Game2048Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15423 on 2017/10/13.
 */

public class GameView extends GridLayout {


//    public GameView(Context context) {
//        super(context);
//        initGameView();
//
//        addCard(400,400);
//
//    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initGameView();
        //addCard(200,230);
    }

//    public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        initGameView();
//        addCard(400,400);
//    }

    private void initGameView() {
        Game2048Activity.getMainActivity().OpenMusic();
        setColumnCount(4);
        setBackgroundColor(0xffbbada0);
        //首先要判断永辉的意图，分为上下左右滑动
        setOnTouchListener(new OnTouchListener() {
            //定义起点和中点变量
            private float startX, startY, offSetX, offSetY;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //判断用户的意图
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = motionEvent.getX();
                        startY = motionEvent.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        offSetX = motionEvent.getX() - startX;
                        offSetY = motionEvent.getY() - startY;


                        //如果偏移量X>Y,说明用户，向左移动
                        if (Math.abs(offSetX) > Math.abs(offSetY)) {
                            if (offSetX < -5) {
                                System.out.println("left");
                                swipeLeft();
                            } else if (offSetY > 5) {
                                System.out.println("right");
                                swipeRight();
                            }
                        } else {
                            if (offSetY > 5) {
                                System.out.println("down");
                                swipeDown();
                            } else if (offSetY < -5) {
                                System.out.println("up");
                                swipeUp();
                            }
                        }

                        break;
                }
                return true;
            }
        });
    }




    //    onSizeChanged() 在控件大小发生改变时调用。所以这里初始化会被调用一次
//    作用：获取控件的宽和高度
//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        super.onSizeChanged(w, h, oldw, oldh);
//
//        int cardWidth = (Math.min(w, h) -10) / 4;
//        addCard(cardWidth, cardWidth);
//        startGame();  //haha 尴尬了！
//    }

    //我在这里把onSizeChanged换成了onFinishInflate这个，但是在这里想获得屏幕的宽高得自己想办法写进去
    //写死了是吧，你现在还能

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();//查一下这个方法
        int cardWidth = (Math.min(1024, 1920) - 10) / 4;
        addCard(cardWidth, cardWidth);
        startGame();  //haha 尴尬了！
    }

    private void addCard(int cardWidth, int cardHeight) {
        Card card = null;
        //添加16张图片
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                card = new Card(getContext());
                card.setNum(0);

                addView(card, cardWidth, cardHeight);
                cardsMap[x][y] = card;

            }
        }

    }

    //开始游戏
    private void startGame() {
       // MainActivity.getMainActivity().clearScore();

        //清理所有的的数据
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                cardsMap[y][x].setNum(0);
            }
        }
        addRandomSum();  ///看看 这里不是添加随机数 你在mainactivity startgame

        addRandomSum();


    }

    //定义方法生成一个随机数
    private void addRandomSum() {

        // MainActivity.getMainActivity().clearScore();
        //添加随机数之前，清空
        emptyPoints.clear();

        //对二二维数组进行遍历
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (cardsMap[x][y].getNum() <= 0) {
                    emptyPoints.add(new Point(x, y));
                }
            }
        }
        Point point = emptyPoints.remove((int) (Math.random() * emptyPoints.size()));
        System.out.println(point + "-----------------------------------");

        cardsMap[point.y][point.x].setNum(Math.random() > 0.1 ? 2 : 4);
        System.out.println(cardsMap + "111111111111111111111111111111111");


    }


    private void swipeLeft() {  //向左滑动模块
        boolean merge = false;

        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 4; y++) {

                for (int y1 = y + 1; y1 < 4; y1++) {
                    if (cardsMap[x][y1].getNum() > 0) {

                        if (cardsMap[x][y].getNum() <= 0) {
                            cardsMap[x][y].setNum(cardsMap[x][y1].getNum());
                            cardsMap[x][y1].setNum(0);

                            y--;
                            merge = true;
                        } else if (cardsMap[x][y].equals(cardsMap[x][y1])) {
                            cardsMap[x][y].setNum(cardsMap[x][y].getNum() * 2);
                            cardsMap[x][y1].setNum(0);

                            Game2048Activity.getMainActivity().addScore(cardsMap[x][y].getNum());
                            merge = true;
                        }
                        break;
                    }
                }
            }
        }
        if (merge) {
            addRandomSum();
            Game2048Activity.getMainActivity().GameMusic();
        }
    }
    private void swipeRight() {
        //MainActivity.getMainActivity().GameMusic();
        boolean merge = false;

        for (int x = 0; x < 4; x++) {
            for (int y = 3; y >= 0; y--) {

                for (int y1 = y - 1; y1 >= 0; y1--) {
                    if (cardsMap[x][y1].getNum() > 0) {

                        if (cardsMap[x][y].getNum() <= 0) {
                            cardsMap[x][y].setNum(cardsMap[x][y1].getNum());
                            cardsMap[x][y1].setNum(0);

                            y++;
                            merge = true;
                        } else if (cardsMap[x][y].equals(cardsMap[x][y1])) {
                            cardsMap[x][y].setNum(cardsMap[x][y].getNum() * 2);
                            cardsMap[x][y1].setNum(0);

                            Game2048Activity.getMainActivity().addScore(cardsMap[x][y].getNum());
                            merge = true;
                        }
                        break;
                    }
                }
            }
        }
        if (merge) {
            addRandomSum();
            Game2048Activity.getMainActivity().GameMusic();
        }
    }

    private void swipeUp() {
        boolean merge = false;
       // MainActivity.getMainActivity().GameMusic();
        for (int y = 0; y < 4; y++) {   //向右遍历
            for (int x = 0; x < 4; x++) {

                for (int x1 = x + 1; x1 < 4; x1++) {
                    if (cardsMap[x1][y].getNum() > 0) {

                        if (cardsMap[x][y].getNum() <= 0) {
                            cardsMap[x][y].setNum(cardsMap[x1][y].getNum());
                            cardsMap[x1][y].setNum(0);
                            x--;
                            merge = true;
                        } else if (cardsMap[x][y].equals(cardsMap[x1][y])) {  //合并
                            cardsMap[x][y].setNum(cardsMap[x][y].getNum() * 2);
                            cardsMap[x1][y].setNum(0);

                            Game2048Activity.getMainActivity().addScore(cardsMap[x][y].getNum());  //记分的方式
                            merge = true;
                        }
                        break;
                    }
                }
            }
        }
        if (merge) {   //判断是否合并，若合并了，则添加一个随机数
            addRandomSum();
            Game2048Activity.getMainActivity().GameMusic();
        }
    }
    private void swipeDown() {
       // MainActivity.getMainActivity().GameMusic();
        boolean merge = false;
        for (int y = 0; y < 4; y++) {   //向左遍历
            for (int x = 3; x >= 0; x--) {

                for (int x1 = x - 1; x1 >= 0; x1--) {
                    if (cardsMap[x1][y].getNum() > 0) {

                        if (cardsMap[x][y].getNum() <= 0) {
                            cardsMap[x][y].setNum(cardsMap[x1][y].getNum());
                            cardsMap[x1][y].setNum(0);

                            x++;
                            merge = true;
                        } else if (cardsMap[x][y].equals(cardsMap[x1][y])) {
                            cardsMap[x][y].setNum(cardsMap[x][y].getNum() * 2);
                            cardsMap[x1][y].setNum(0);

                            Game2048Activity.getMainActivity().addScore(cardsMap[x][y].getNum());
                            merge = true;
                        }
                        break;
                    }
                }
            }
        }
        if (merge) {
            addRandomSum();
            Game2048Activity.getMainActivity().GameMusic();
        }

    }
    private Card[][] cardsMap = new Card[4][4];
    private List<Point> emptyPoints = new ArrayList<Point>();
}
