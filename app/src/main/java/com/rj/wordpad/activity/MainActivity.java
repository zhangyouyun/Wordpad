package com.rj.wordpad.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.rj.wordpad.R;
import com.rj.wordpad.entity.ButtonItem;
import com.rj.wordpad.view.CustomButton;

import java.util.ArrayList;

/**
 * Created by zhangyouyun  on 2016/2/29.
 */
public class MainActivity extends Activity {
    CustomButton customButton;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wordpad);
        addView();
    }
    private void addView() {
        //传入参数
        ArrayList<ButtonItem> buttonList = new ArrayList<>();
        ButtonItem buttonItem = new ButtonItem();
        buttonItem.setButtonName("保存");
        buttonItem.setButtonColor(Color.BLACK);
        buttonItem.setId(1);
        buttonItem.setIsCheck(true);
//--------------------------
        ButtonItem buttonItem1 = new ButtonItem();
        buttonItem1.setButtonName("大小");
        buttonItem1.setButtonColor(Color.BLACK);
        buttonItem1.setId(2);
        buttonItem1.setIsCheck(true);
//--------------------------
        ButtonItem buttonItem2 = new ButtonItem();
        buttonItem2.setButtonName("颜色");
        buttonItem2.setButtonColor(Color.BLACK);
        buttonItem2.setId(3);
        buttonItem2.setIsCheck(true);
//--------------------------
        ButtonItem buttonItem3 = new ButtonItem();
        buttonItem3.setButtonName("撤销");
        buttonItem3.setButtonColor(Color.BLACK);
        buttonItem3.setId(4);
        buttonItem3.setIsCheck(true);
//--------------------------
        ButtonItem buttonItem4 = new ButtonItem();
        buttonItem4.setButtonName("清空");
        buttonItem4.setButtonColor(Color.BLACK);
        buttonItem4.setId(5);
        buttonItem4.setIsCheck(true);
//--------------------------
        ButtonItem buttonItem5 = new ButtonItem();
        buttonItem5.setButtonName("橡皮");
        buttonItem5.setButtonColor(Color.BLACK);
        buttonItem5.setId(6);
        buttonItem5.setIsCheck(true);
//--------------------------
        ButtonItem buttonItem6 = new ButtonItem();
        buttonItem6.setButtonName("恢复");
        buttonItem6.setButtonColor(Color.BLACK);
        buttonItem6.setId(7);
        buttonItem6.setIsCheck(true);
//--------------------------
        ButtonItem buttonItem7 = new ButtonItem();
        buttonItem7.setButtonName("画笔");
        buttonItem7.setButtonColor(Color.BLACK);
        buttonItem7.setId(8);
        buttonItem7.setIsCheck(true);
//--------------------------
        ButtonItem buttonItem8 = new ButtonItem();
        buttonItem8.setButtonName("上次");
        buttonItem8.setButtonColor(Color.BLACK);
        buttonItem8.setId(9);
        buttonItem8.setIsCheck(true);
//--------------------------
        buttonList.add(buttonItem);
        buttonList.add(buttonItem1);
        buttonList.add(buttonItem2);
        buttonList.add(buttonItem3);
        buttonList.add(buttonItem4);
        buttonList.add(buttonItem5);
        buttonList.add(buttonItem6);
        buttonList.add(buttonItem7);
        buttonList.add(buttonItem8);
//--------------------------

        customButton = (CustomButton) findViewById(R.id.custombutton);
        customButton.CreateLayout(buttonList);
        customButton.setButtonListener(new CustomButton.ButtonListener() {
            public void showTip(ButtonItem buttonItem) {
                Toast.makeText(getApplicationContext(), "" + buttonItem.getButtonName(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
