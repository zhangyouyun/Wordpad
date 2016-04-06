package com.rj.wordpad.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.rj.wordpad.R;
import com.rj.wordpad.Util.DensityUtil;
import com.rj.wordpad.entity.ButtonItem;

import java.util.ArrayList;

/**
 * Created by Auser on 2016/3/7.
 */
public class CustomButton extends LinearLayout implements View.OnClickListener {
    private ArrayList<ButtonItem> item = new ArrayList<>();
    private Context mContext;
    private PaintView mPaintView;
    private Boolean isEarse = false;
    private int select_handwrite_size_index = 0;
    private Bitmap mSignBitmap = null;
    private String json = "";
    private Bitmap mBitmap;
    private float x, y;

    public CustomButton(Context context) {
        super(context);
        mContext = context;
        OuterLayout();
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        OuterLayout();
    }

    //    //下划线
//    public View Line() {
//        LinearLayout.LayoutParams lineparams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 2);
//        ImageView line = new ImageView(mContext);
//        line.setBackgroundColor(Color.BLACK);
//        line.setLayoutParams(lineparams);
//        return line;
//    }
    public void OuterLayout() {
        /*获取屏幕宽高*/
        WindowManager manager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(dm);
        mPaintView = new PaintView(mContext, dm.widthPixels, dm.heightPixels);
        setOrientation(LinearLayout.VERTICAL);
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));

    }

    public void CreateLayout(ArrayList<ButtonItem> buttonItem) {
        /*当前屏幕长度宽度*/
        item = buttonItem;
        /*外面的布局*/
        LinearLayout buttonLayout = new LinearLayout(mContext);
        LayoutParams buttonparams = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);

      /*  画笔存在问题*/
        LayoutParams ScrollView = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        buttonLayout.setOrientation(LinearLayout.HORIZONTAL);
        buttonLayout.setLayoutParams(buttonparams);
        buttonLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        buttonLayout.setBackgroundColor(Color.WHITE);
        for (int i = 0; i < buttonItem.size(); i++) {
            ButtonItem buttonitem = buttonItem.get(i);
            buttonLayout.addView(getItemView(buttonitem));

        }
        buttonLayout.setBackground(getResources().getDrawable(R.drawable.normal));

        /*滚动条*/
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(mContext);
        horizontalScrollView.setLayoutParams(ScrollView);
        horizontalScrollView.setSmoothScrollingEnabled(true);
        horizontalScrollView.setFillViewport(true);
        horizontalScrollView.addView(buttonLayout);

        this.addView(horizontalScrollView);
        this.addView(mPaintView);
    }


    public View getItemView(final ButtonItem buttonitem) {
        LinearLayout layout = new LinearLayout(mContext);
        LayoutParams params1 = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT, 1.0F);
         /* 边距*/
        params1.setMargins(DensityUtil.px2dip(mContext, 3), DensityUtil.px2dip(mContext, 5),
                DensityUtil.px2dip(mContext, 3), DensityUtil.px2dip(mContext, 5));
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setGravity(Gravity.CENTER);
        layout.setLayoutParams(params1);

        Button button = new Button(mContext);
        button.setText(buttonitem.getButtonName());
        button.setTextColor(buttonitem.getButtonColor());
        button.setId(buttonitem.getId());
        button.setTag(buttonitem);
        button.setOnClickListener(this);
        button.setGravity(Gravity.CENTER);
        if (buttonitem.getIsCheck()) {
            button.setText(buttonitem.getButtonName());
        } else {
            button.setText(buttonitem.getCheckName());
        }
        button.setBackground(null);
        button.setBackground(getResources().getDrawable(R.drawable.selector));
        layout.addView(button);

        return layout;
    }

    //监听
    private ButtonListener buttonListener;
    public ButtonListener getButtonListener() {
        return buttonListener;
    }
    public void setButtonListener(ButtonListener buttonListener) {
        this.buttonListener = buttonListener;
    }
    public void onClick(View v) {
        ButtonItem buttonItem = (ButtonItem) v.getTag();
        buttonItem.setIsCheck(!buttonItem.getIsCheck());
        if (buttonListener != null) {
            buttonListener.showTip(buttonItem);
        }
        switch (buttonItem.getId()) {
            case 1:
                /*保存*/
                mPaintView.Save();
                break;
            case 2:
               /* 字体大小*/
                mPaintView.showPaintSizeDialog(v);
                break;
            case 3:
               /* 颜色选择*/
                mPaintView.showPaintColorDialog(v);
                break;
            case 4:
                /*撤销*/
                mPaintView.Revoke();
                break;
            case 5:
              /*  清空*/
                mPaintView.ClearPath();
                break;
            case 6:
                /*橡皮擦*/
                mPaintView.isEraser(true);
                break;
            case 7:
                /*恢复*/
                mPaintView.Recover();
                break;
            case 8:
                /*画笔*/
                mPaintView.isEraser(false);
                break;
            case 9:
                /*上次*/
                mPaintView.lastTime();
                /*刷新*/
                invalidate();
                break;
            default:
                break;
        }
    }
    //正常的回调接口
    public interface ButtonListener {
        void showTip(ButtonItem buttonItem);
    }
}
