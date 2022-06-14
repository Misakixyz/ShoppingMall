package com.atguigu.shoppingmall.message.fragment;

import android.app.Notification;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.atguigu.shoppingmall.R;
import com.atguigu.shoppingmall.app.MainActivity;
import com.atguigu.shoppingmall.base.BaseFragment;
import com.atguigu.shoppingmall.home.bean.GoodsBean;
import com.atguigu.shoppingmall.home.uitls.VirtualkeyboardHeight;
import com.atguigu.shoppingmall.message.adapter.MessageAdapter;
import com.atguigu.shoppingmall.shoppingcart.adapter.ShopCartAdapter;
import com.atguigu.shoppingmall.shoppingcart.utils.CartProvider;

import java.util.List;

//import android.support.v4.app.Fragment;

public class MessageFragment extends BaseFragment {
    private ImageButton ibmessagebutton1;
    private ImageButton ibmessagebutton2;
    private ImageButton ibmessagebutton3;
    private ImageButton ibmessagebutton4;
    private MessageAdapter adapter;
    private RecyclerView recyclerview;


    private void findViews(View view) {
        ibmessagebutton1 = (ImageButton) view.findViewById(R.id.ib_message_button1);
        ibmessagebutton2 = (ImageButton) view.findViewById(R.id.ib_message_button2);
        ibmessagebutton3 = (ImageButton) view.findViewById(R.id.ib_message_button3);
        ibmessagebutton4 = (ImageButton) view.findViewById(R.id.ib_message_button4);

    }

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_message, null);
        findViews(view);
        initListener();
        //initPopupWindow();
        //onClick(view);
        return view;
    }

    @Override
    public void initData() {
        initListener();

        //showData();
    }
    /*private void showData() {

        //CartProvider cartProvider = CartProvider.getInstance();
        List<MessageAdapter> datas = cartProvider.getDataFromLocal();
        if (datas != null && datas.size() > 0) {
            tvShopcartEdit.setVisibility(View.VISIBLE);

            adapter = new ShopCartAdapter(mContext, datas, tvShopcartTotal, cartProvider, checkboxAll, cbAll);
            recyclerview.setLayoutManager(new LinearLayoutManager(mContext));
            recyclerview.setAdapter(adapter);
            ll_empty_shopcart.setVisibility(View.GONE);
        } else {
            //显示空的
            tvShopcartEdit.setVisibility(View.GONE);
            ll_empty_shopcart.setVisibility(View.VISIBLE);


        }

    }*/

    private void initListener() {
        ibmessagebutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = "@我的";
                showPopwindow(title);
                Log.e("555555555","123123123");
            }
        });
        ibmessagebutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = "提醒";
                showPopwindow(title);
            }
        });
        ibmessagebutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = "红包";
                showPopwindow(title);
            }
        });
        ibmessagebutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = "优惠券";
                showPopwindow(title);
            }
        });

    }




    private void showPopwindow(String title) {

        // 1 利用layoutInflater获得View
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.popupwindow_message_button, null);

        // 2下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
        final PopupWindow window = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        // 3 参数设置
        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setFocusable(true);

        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xFFFFFFFF);
        window.setBackgroundDrawable(dw);

        // 设置popWindow的显示和消失动画
        window.setAnimationStyle(R.style.mypopwindow_anim_style);
        //window.setElevation(200);

        // 4 控件处理
        TextView tvmessagepop = (TextView) view.findViewById(R.id.message_pop);
        ImageButton tvmessagepopbutton = (ImageButton) view.findViewById(R.id.message_pop_button);
        tvmessagepop.setText(title);

        tvmessagepopbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                window.dismiss();
            }
        });
        window.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                window.dismiss();
            }
        });

        // 5 在底部显示
        window.showAtLocation(MessageFragment.this.getView().findViewById(R.id.message_recyclerview),Gravity.BOTTOM,0,0);
    }

}
