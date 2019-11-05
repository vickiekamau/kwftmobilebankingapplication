package com.example.administrator.kwft.activity.Account_info;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.kwft.R;
import com.example.administrator.kwft.api.ApiClient;
import com.example.administrator.kwft.api.ApiInterface;
import com.example.administrator.kwft.model.Account;
import com.example.administrator.kwft.utils.PreferenceUtils;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountActivity extends AppCompatActivity implements AccountView {

    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    TextView accNo,accName,time;

    AccountPresenter accountPresenter;
    AccountAdapter accountAdapter;
    AccountAdapter.ItemClickListener itemClickListener;

    List<Account> accounts;
   // private AccountView accountView;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_information);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        accNo = findViewById(R.id.accNo);
        accName = findViewById(R.id.txt_name);
        time = findViewById(R.id.txt_time);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        int acc_no = PreferenceUtils.getAccountNo(this);
        accNo.setText(String.valueOf(acc_no));
        String accountName = PreferenceUtils.getAccountName(this);
        accName.setText(accountName);
        time.setText(greetings());

        accountPresenter = new AccountPresenter(this);
        accountPresenter.statement();

        swipeRefreshLayout.setOnRefreshListener(() -> accountPresenter.statement()
        );
        itemClickListener = ((view, position) -> {
           int acc = accounts.get(position).getAccount_no();
           Toast.makeText(this,acc,Toast.LENGTH_SHORT).show();
        });


    }

      @Override
      public void showLoading() {
        swipeRefreshLayout.setRefreshing(true);
    }

      @Override
      public void hideLoading() {
        swipeRefreshLayout.setRefreshing(false);
    }

     @Override
     public void onGetResult(List<Account>account){
        accountAdapter = new AccountAdapter(this,account,itemClickListener);
        accountAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(accountAdapter);
        accounts = account;
     }


    @Override
    public void onErrorLoading(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
    public String greetings(){
        String greeting = null;
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);

        if(hour>=1 && hour<=12){
            greeting = "Good Morning";
        }else if(hour>=12 && hour<=16){
            greeting = "Good Afternoon";
        } else if(hour>=16 && hour<=21){
            greeting = "Good Evening";
        }else if(hour>=21 && hour<=24){
            greeting = "Good Night";
        }
        return greeting;
    }

}
