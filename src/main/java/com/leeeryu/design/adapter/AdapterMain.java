package com.leeeryu.design.adapter;

import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 자바에서도 직접적으로 메서드를 호출하지 않고 중간에
 * 어댑터를 거쳐서 메서드를 호출하도록 하는 패턴이 바로 어댑터 패턴(Adapter Pattern) 입니다.
 * 아래는 Adapter 디자인 패턴 테이블입니다.
 */
public class AdapterMain {
    public static void main(String[] args) {
        ChannelInboundHandlerAdapter adapter = new ChannelInboundHandlerAdapter();
    }
}
