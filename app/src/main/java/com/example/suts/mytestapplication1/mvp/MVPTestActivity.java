package com.example.suts.mytestapplication1.mvp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.suts.mytestapplication1.BaseActivity;
import com.example.suts.mytestapplication1.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MVPTestActivity extends BaseActivity implements LoginView {

    @BindView(R.id.et_loginName)
    EditText etLoginName;
    @BindView(R.id.et_loginPassword)
    EditText etLoginPassword;

    @BindView(R.id.btn_loginEnsure)
    Button btnLoginEnsure;

    ProgressDialog progressDialog;
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvptest);
        ButterKnife.bind(this);

        createProgressDialog();
        loginPresenter = new LoginPresenterImpl(this);

    }

    @OnClick(R.id.btn_loginEnsure)
    public void onViewClicked() {
        if (loginPresenter != null){
            loginPresenter.validateCredential(etLoginName.getText().toString(), etLoginPassword.getText().toString());
        }

    }

    public void createProgressDialog(){
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("登陆中...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestroy();
    }

    @Override
    public void showProgressDialog() {
        if (progressDialog ==  null){
            createProgressDialog();
        }
        progressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        if (progressDialog != null){
            progressDialog.dismiss();
        }
    }

    @Override
    public void setUserNameErr() {
        Toast.makeText(this, "用户名错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setUserPasswordErr() {
        Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToHome() {
        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
    }

}
