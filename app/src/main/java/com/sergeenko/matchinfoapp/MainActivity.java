package com.sergeenko.matchinfoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.LayoutDirection;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.Toolbar;

import com.sergeenko.matchinfoapp.databinding.ActivityMainBinding;

import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

@AndroidEntryPoint
public class MainActivity extends BaseActivity<MainPresenter, ActivityMainBinding> implements MainView, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.videoView.setOnErrorListener(this);
        binding.videoView.setOnPreparedListener(this);
        presenter.getMatches();
        presenter.getLinks();
        binding.videoView.setOnClickListener(
                (view)->{
                    binding.play.setVisibility(binding.play.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
                }
        );
        binding.play.setOnClickListener((view)->{
            if(binding.videoView.isPlaying()){
                binding.videoView.pause();
            }else {
                binding.videoView.start();
            }

            view.setActivated(binding.videoView.isPlaying());
        });
    }

    @Override
    ActivityMainBinding bind(LayoutInflater layoutInflater) {
        return ActivityMainBinding.inflate(layoutInflater);
    }


    @Override
    public void updateTournament(Root tournament) {
        binding.matchName.setText(tournament.tournament.name_rus + "(" + tournament.tournament.name_eng + ")");
        binding.matchDate.setText(tournament.date);

        binding.teamOne.setText(tournament.team1.name_rus + "(" + tournament.team1.name_eng + ")");
        binding.teamTwo.setText(tournament.team2.name_rus + "(" + tournament.team2.name_eng + ")");

        binding.scoreTeamOne.setText(String.valueOf(tournament.team1.score));
        binding.scoreTeamTwo.setText(String.valueOf(tournament.team2.score));
    }

    @Override
    public void updateUrls(List<UrlResponse> urlResponse) {

    }

    @Override
    public void setUrlsList(UrlListAdapter adapter) {
        binding.buttonList.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));
        binding.buttonList.setAdapter(adapter);
        adapter.setOnClickListener(
                (url)->{
                    showLoading();
                    binding.videoView.setVideoPath(url.url);
                }
        );
    }

    @Override
    public void showLoading() {
        binding.loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void closeLoading() {
        binding.loading.setVisibility(View.GONE);
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        showToast("error " + what);
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
        closeLoading();
        binding.play.setActivated(binding.videoView.isPlaying());
    }
}