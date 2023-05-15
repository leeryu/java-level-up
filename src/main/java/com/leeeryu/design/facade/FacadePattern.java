package com.leeeryu.design.facade;

import java.util.Map;

/**
 * 퍼사드 패턴은 서브시스템을 더 쉽게 사용할 수 있도록 higher-level 인터페이스를 정의하고, 제공합니다.
 * 퍼사드 패턴은 클라이언트 어플리케이션의 헬퍼 역할을 하는 것이지, 서브시스템 인터페이스를 숨기는 것은 아닙니다.
 * 퍼사드 패턴은 특정 기능에 대해 인터페이스의 수가 확장되고(위 예제로 치면 디비 종류나 리포트 종류가 늘어난다는 등), 시스템이 복잡해질 수 있는 상황에서 사용하기 적합합니다.
 * 퍼사드 패턴은 비슷한 작업을 해야하는 다양한 인터페이스들 중 하나의 인터페이스를 클라이언트에 제공해야 할 때 적용하는 것이 좋습니다.
 * 팩토리 패턴과 종종 함께 사용됩니다.
 */
public class FacadePattern {
    public static void main(String[] args) {
        new MyLocFacade().printMyAddress();
    }
}

class GeoLocation {
    public GeoLocation() {
    }

    public double[] getGeoLoc() {
        return new double[]{0, 0};
    }
}

class InternetConnection {
    public InternetConnection() {
    }

    public boolean isConnected() {
        return true;
    }

    public void connect() {
        if (this.isConnected()) {
            System.out.println("Already connected");
            return;
        } else {
            System.out.println("Connected");
        }
    }

    public String getData(String url, double[] geoLoc) {
        return null;
    }

    public void disconnect() {
        System.out.println("Disconnected");
    }
}

class Json {
    public Json() {
    }

    public Map<String, Object> parse(String data) {
        return Map.of("address", "용인시 처인구 포곡읍 전대로 120번길 ");
    }
}

class MyLocFacade {
    public void printMyAddress() {
        final double[] geoLoc = new GeoLocation().getGeoLoc();
        final InternetConnection internetConnection = new InternetConnection();
        internetConnection.connect();

        String data = internetConnection.getData("http://www.google.com", geoLoc);

        internetConnection.disconnect();

        final Map<String, Object> address = (new Json()).parse(data);

        System.out.println(address.get("address"));
    }
}
