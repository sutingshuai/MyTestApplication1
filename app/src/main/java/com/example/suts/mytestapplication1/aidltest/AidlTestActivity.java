package com.example.suts.mytestapplication1.aidltest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.suts.mytestapplication1.BaseActivity;
import com.example.suts.mytestapplication1.Book;
import com.example.suts.mytestapplication1.IMyAidlInterface;
import com.example.suts.mytestapplication1.R;
import com.orhanobut.logger.Logger;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AidlTestActivity extends BaseActivity {

    IMyAidlInterface iMyAidlInterface;
    List<Book> books;
    @BindView(R.id.btn_getBooks)
    Button btnGetBooks;
    @BindView(R.id.btn_aidl_addBookIn)
    Button btnAidlAddBookIn;
    @BindView(R.id.btn_aidl_getBookCount)
    Button btnAidlGetBookCount;
    @BindView(R.id.btn_aidl_getBook)
    Button btnAidlGetBook;
    @BindView(R.id.btn_aidl_setBookPrice)
    Button btnAidlSetBookPrice;
    @BindView(R.id.btn_aidl_setBookName)
    Button btnAidlSetBookName;
    @BindView(R.id.btn_aidl_addBookOut)
    Button btnAidlAddBookOut;
    @BindView(R.id.btn_aidl_addBookInOut)
    Button btnAidlAddBookInOut;
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Logger.e("service has been connected!");
            iMyAidlInterface = IMyAidlInterface.Stub.asInterface(iBinder);
            if (iMyAidlInterface != null) {
                try {
                    books = iMyAidlInterface.getBooks();
                    Logger.e("服务中的书：" + books.toString());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl_test);
        ButterKnife.bind(this);

        FragmentManager fragmentManager = getSupportFragmentManager();

    }

    @Override
    protected void onStart() {
        super.onStart();
        attemptToConnectService();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(mConnection);
    }

    public void attemptToConnectService() {
        Intent intent = new Intent();
        intent.setAction("com.example.suts.mytestapplication1.AIDL_TEST_ACTION");
        intent.setPackage("com.example.suts.mytestapplication1");
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    @OnClick({R.id.btn_getBooks, R.id.btn_aidl_addBookIn, R.id.btn_aidl_getBookCount, R.id.btn_aidl_getBook, R.id.btn_aidl_setBookPrice, R.id.btn_aidl_setBookName, R.id.btn_aidl_addBookOut, R.id.btn_aidl_addBookInOut})
    public void onViewClicked(View view){
        switch (view.getId()) {
            case R.id.btn_getBooks:
                try {
                    books = iMyAidlInterface.getBooks();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                Logger.e("获取服务中输的信息" + books);
                break;
            case R.id.btn_aidl_addBookIn:
                Book bookin = new Book(68, "精通android studio", "毕小朋");
                try {
                    iMyAidlInterface.addBookIn(bookin);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                Logger.e("bookin添加了一本新书" + bookin);
                break;
            case R.id.btn_aidl_getBookCount:
                try {
                    Logger.e("获取服务中书的数量：" + iMyAidlInterface.getBookCount());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_aidl_getBook:
                try {
                    Logger.e("获取服务中的第一本书：" + iMyAidlInterface.getBook());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_aidl_setBookPrice:
                try {
                    iMyAidlInterface.setBookPrice(books.get(0), 1000);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_aidl_setBookName:
                try {
                    iMyAidlInterface.setBookName(books.get(0), "New Book Name");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_aidl_addBookOut:
                Book bookout = new Book(68, "精通android studio", "毕小朋");
                try {
                    iMyAidlInterface.addBookIn(bookout);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                Logger.e("bookout添加了一本新书" + bookout);
                break;
            case R.id.btn_aidl_addBookInOut:
                Book bookinout = new Book(68, "精通android studio", "毕小朋");
                try {
                    iMyAidlInterface.addBookIn(bookinout);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                Logger.e("bookinout添加了一本新书" + bookinout);
                break;
        }
    }
}
