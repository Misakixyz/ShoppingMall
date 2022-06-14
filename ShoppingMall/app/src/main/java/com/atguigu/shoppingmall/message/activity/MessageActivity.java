package com.atguigu.shoppingmall.message.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.shoppingmall.R;
import com.atguigu.shoppingmall.app.GoodsInfoActivity;
import com.atguigu.shoppingmall.home.uitls.VirtualkeyboardHeight;
import com.atguigu.shoppingmall.shoppingcart.view.NumberAddSubView;
import com.atguigu.shoppingmall.utils.Constants;
import com.bumptech.glide.Glide;

public class MessageActivity extends Activity implements View.OnClickListener{
    private ImageButton ibmessagebutton1;
    private ImageButton ibmessagebutton2;
    private ImageButton ibmessagebutton3;
    private ImageButton ibmessagebutton4;

    private void findViews(){
        ibmessagebutton1 = (ImageButton) findViewById(R.id.ib_message_button1);
        ibmessagebutton2 = (ImageButton) findViewById(R.id.ib_message_button2);
        ibmessagebutton3 = (ImageButton) findViewById(R.id.ib_message_button3);
        ibmessagebutton4 = (ImageButton) findViewById(R.id.ib_message_button4);
        ibmessagebutton1.setOnClickListener(this);
        ibmessagebutton2.setOnClickListener(this);
        ibmessagebutton3.setOnClickListener(this);
        ibmessagebutton4.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        findViews();

        //showData();
        //tvShopcartEdit.setTag(ACTION_EDIT);
        //tvShopcartEdit.setText("编辑");

    }

    @Override
    public void onClick(View v){
        if (v == ibmessagebutton1) {
            String title = "@我的";
            showPopwindow(title);
        }else if (v == ibmessagebutton2){
            String title = "提醒";
            showPopwindow(title);
        }else if (v == ibmessagebutton3){
            String title = "红包";
            showPopwindow(title);
        }else if (v == ibmessagebutton4){
            String title = "优惠券";
            showPopwindow(title);
        }
    }
    private void showPopwindow(String title) {

        // 1 利用layoutInflater获得View
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.popupwindow_message_button, null);

        // 2下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
        final PopupWindow window = new PopupWindow(view,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        // 3 参数设置
        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setFocusable(true);

        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xFFFFFFFF);
        window.setBackgroundDrawable(dw);

        // 设置popWindow的显示和消失动画
        window.setAnimationStyle(R.style.mypopwindow_anim_style);


        // 4 控件处理
        TextView tvmessagepop = (TextView) view.findViewById(R.id.message_pop);

        tvmessagepop.setText(title);


        window.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                window.dismiss();
            }
        });

        // 5 在底部显示
        window.showAtLocation(MessageActivity.this.findViewById(R.id.activity_main_root),
                Gravity.BOTTOM, 0, VirtualkeyboardHeight.getBottomStatusHeight(MessageActivity.this));

    }
}
