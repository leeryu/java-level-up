package com.leeeryu.thread;

public class MusicBoxMain {
    public static void main(String[] args) {
        final MusicBox musicBox = new MusicBox();
        MusicPlayer sanguck = new MusicPlayer(1, musicBox);
        MusicPlayer sohee = new MusicPlayer(2, musicBox);
        MusicPlayer jieun = new MusicPlayer(3, musicBox);

        sanguck.start();
        sohee.start();
        jieun.start();
    }
}
