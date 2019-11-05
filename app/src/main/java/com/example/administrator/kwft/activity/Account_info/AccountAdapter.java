package com.example.administrator.kwft.activity.Account_info;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.kwft.R;
import com.example.administrator.kwft.api.ApiClient;
import com.example.administrator.kwft.api.ApiInterface;
import com.example.administrator.kwft.model.Account;
import com.example.administrator.kwft.model.Kwft;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.RecyclerViewAdapter> {

        private Context context;
        private List<Account> accounts;
        private ItemClickListener itemClickListener;

        public AccountAdapter(Context context, List<Account> accounts ,ItemClickListener itemClickListener) {
            this.context = context;
            this.accounts = accounts;
            this.itemClickListener = itemClickListener;
        }

        @NonNull
        @Override
        public RecyclerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_account,parent,false);
            return new RecyclerViewAdapter(view,itemClickListener);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewAdapter holder, int position) {
            Account account = accounts.get(position);

            holder.tv_id.setText(String.valueOf(account.getTransactionId()));
            holder.tv_date.setText(account.getTimeStamp());
            holder.tv_originator.setText(String.valueOf(account.getAccount_no()));
            holder.tv_destination.setText(String.valueOf(account.getAccountTo()));
            holder.tv_amount.setText(String.valueOf(account.getAmount()));
        }

        @Override
        public int getItemCount() {

            return accounts.size();
        }

        class RecyclerViewAdapter extends RecyclerView.ViewHolder implements View.OnClickListener{
            TextView tv_id,tv_date,tv_originator,tv_destination,tv_amount;
            RelativeLayout relativeLayout;
            ItemClickListener itemClickListener;
            RecyclerViewAdapter(View itemView, ItemClickListener itemClickListener){
                super(itemView);


                tv_id = itemView.findViewById(R.id.val_id);
                tv_date = itemView.findViewById(R.id.val_date);
                tv_originator = itemView.findViewById(R.id.val_originator);
                tv_destination = itemView.findViewById(R.id.val_Destination);
                tv_amount = itemView.findViewById(R.id.val_amount);
                relativeLayout = itemView.findViewById(R.id.statement);
                this.itemClickListener = itemClickListener;
                relativeLayout.setOnClickListener(this);


            }

            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(v,getAdapterPosition());
            }
        }
       public interface ItemClickListener{
            void onItemClick(View view, int position);
        }

}

