package cn.zhaoliang5156.sensortest.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Activity的基类
 * 需求：封装Activity的共用方法
 *
 * @author zhaoliang
 * @version 1.0
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(initLayout());
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        initView();
        initListener();
        initData();
    }

    /**
     * 展示数据
     */
    protected abstract void initData();

    /**
     * 初始化点击事件
     */
    protected abstract void initListener();

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 初始化布局
     *
     * @return 布局文件的id
     */
    protected abstract int initLayout();
}
