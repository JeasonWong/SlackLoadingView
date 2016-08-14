package me.wangyuwei.slacklogo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSeekBar;
import android.view.View;
import android.widget.SeekBar;

import me.wangyuwei.slackloadingview.SlackLoadingView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private SlackLoadingView mLoadingView;
    private AppCompatSeekBar mSbSize, mSbDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLoadingView = (SlackLoadingView) findViewById(R.id.loading_view);
        mSbSize = (AppCompatSeekBar) findViewById(R.id.sb_size);
        mSbDuration = (AppCompatSeekBar) findViewById(R.id.sb_duration);

        mSbSize.setOnSeekBarChangeListener(this);
        mSbDuration.setOnSeekBarChangeListener(this);
    }

    public void btnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                mLoadingView.start();
                break;
            case R.id.btn_reset:
                mLoadingView.reset();
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.sb_size:
                mLoadingView.setLineLength(progress / 100f);
                break;
            case R.id.sb_duration:
                mLoadingView.setDuration(progress / 100f);
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
