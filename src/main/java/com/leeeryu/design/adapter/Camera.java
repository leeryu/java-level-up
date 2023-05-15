package com.leeeryu.design.adapter;

public class Camera {
    void connectCamA() {
        System.out.println("CamA connected");
    }

    void connectCamB() {
        System.out.println("CamB connected");
    }

    public static void main(String[] args) {
        Camera camera = new CameraAdapter();
        camera.connectCamA();
        camera.connectCamB();
    }
}

interface Connectable {
    void connectCamA();
    void connectCamB();
}

class CameraAdapter extends Camera implements Connectable {
    @Override
    public void connectCamA() {
        System.out.println("CamA Adapter connected");
    }

    @Override
    public void connectCamB() {
        super.connectCamB();
    }
}
