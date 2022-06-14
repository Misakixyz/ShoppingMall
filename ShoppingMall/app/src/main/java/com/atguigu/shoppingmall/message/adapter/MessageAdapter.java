package com.atguigu.shoppingmall.message.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.shoppingmall.R;
import com.atguigu.shoppingmall.home.bean.GoodsBean;
import com.atguigu.shoppingmall.message.bean.MessageBean;
import com.atguigu.shoppingmall.shoppingcart.adapter.ShopCartAdapter;
import com.atguigu.shoppingmall.shoppingcart.utils.CartProvider;
import com.atguigu.shoppingmall.shoppingcart.view.NumberAddSubView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;

    private ImageButton ibmessageicon;
    private TextView messagename;
    private TextView messagetime;
    private TextView messagetxt;
    private List<MessageBean> datas;

    public MessageAdapter(Context context, final List<MessageBean> datas, ImageButton ibmessageicon, TextView messagename, TextView messagetime, TextView messagetxt) {
        this.mContext = context;
        this.datas = datas;
        this.ibmessageicon = ibmessageicon;
        this.messagename = messagename;
        this.messagetime = messagetime;
        this.messagetxt = messagetxt;

        

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MessageAdapter.ViewHolder(View.inflate(mContext, R.layout.item_message, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MessageAdapter.ViewHolder viewHolder = (MessageAdapter.ViewHolder) holder;
        //viewHolder.setData(datas.get(position));

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageButton tvibmessageicon;
        private TextView tvmessagename;
        private TextView tvmessagetime;
        private TextView tvmessagetxt;

        ViewHolder(View itemView) {
            super(itemView);
            tvibmessageicon = (ImageButton) itemView.findViewById(R.id.ib_message_icon);
            tvmessagename = (TextView) itemView.findViewById(R.id.message_name);
            tvmessagetime = (TextView) itemView.findViewById(R.id.message_time);
            tvmessagetxt = (TextView) itemView.findViewById(R.id.message_txt);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (onItemClickListener != null) {
//                        onItemClickListener.onItemClickListener(v, getLayoutPosition());
//                    }
//                }
//            });
        }


    }
}
