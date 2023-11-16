package com.ramotion.fluidslider.channel;

import java.io.File;

public class ChannelTest {

    public static void main(String[] args) {
        File sourceDir = new File("/Users/wutianlong/Downloads/SHAREit-Release-VIVO_TOOLS-4063262-all_yO9y.apk");
        ChannelInfo channelInfo = ChannelReader.get(sourceDir);
        System.out.println("===== " + channelInfo  );
    }

    /*public static void main(String[] args) {
            File sourceDir = new File("/Users/wutianlong/Downloads/SHAREit-Release-VIVO_TOOLS-4063261-all_HNQr.apk");
            ChannelInfo channelInfo = ChannelReader.get(sourceDir);
            System.out.println("===== " + channelInfo + "   "+ channelInfo.getChannel() );
    }*/


}