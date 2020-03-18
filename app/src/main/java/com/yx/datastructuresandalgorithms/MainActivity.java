package com.yx.datastructuresandalgorithms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DoublePointLinkedList doublePointLinkedList = new DoublePointLinkedList();
//        doublePointLinkedList.addHead(1);
//        doublePointLinkedList.addHead(2);
//        doublePointLinkedList.addHead(3);
//        doublePointLinkedList.addHead(4);
//        doublePointLinkedList.addTail(0);
//        doublePointLinkedList.disPlay();

//        QueueLinkedList queueLinkedList = new QueueLinkedList();
//        queueLinkedList.insert(5);
//        queueLinkedList.insert(6);
//        queueLinkedList.insert(9);
//        queueLinkedList.insert(8);
//        queueLinkedList.delete();
//        queueLinkedList.disPlay();

//        OrderLinkedList orderLinkedList = new OrderLinkedList();
//        orderLinkedList.insert(5);
//        orderLinkedList.insert(8);
//        orderLinkedList.insert(1);
//        orderLinkedList.deleteHead();
//        orderLinkedList.disPlay();

//          TwoWayLinkedList twoWayLinkedList = new TwoWayLinkedList();
//          twoWayLinkedList.addHead(5);
//          twoWayLinkedList.addHead(4);
//          twoWayLinkedList.addHead(8);
//          twoWayLinkedList.addHead(3);
//         // twoWayLinkedList.addTail(1);
//          //twoWayLinkedList.deleteHead();
//          twoWayLinkedList.disPlay();
//          twoWayLinkedList.reverseDisPlay();

//        MyArray myArray = new MyArray();
//        myArray.add(2);
//        myArray.add(5);
//        myArray.add(8);
//        myArray.add(7);
//        myArray.add(4);
//        myArray.add(1);

        //myArray.disPlay();

//        int i = myArray.find(3);
//        int data = myArray.get(5);
//        boolean delete = myArray.delete(1);
//        boolean modify = myArray.modify(2, 9);
        //myArray.disPlay();
        //Log.i("yx", "onCreate: "+i+" "+delete+" "+modify+"  "+data);

        int[] datas = {4,0,8,2,9,1,3,5};
        NormalSortUtil.insertSort(datas);
        //int[] ints = NormalSortUtil.choiceSort(datas);
        // NormalSortUtil.disPlay(ints);


    }
}
