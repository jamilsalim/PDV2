package br.com.trainning.pdv2.ui;

import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;

public class BaseActivity extends AppCompatActivity {


    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }
}
