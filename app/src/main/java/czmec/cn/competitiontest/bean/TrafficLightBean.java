package czmec.cn.competitiontest.bean;

/**
 * Created by 风雨诺 on 2019/1/15.
 */

public class TrafficLightBean {

    /**
     * serverInfo : {"RedTime":"25","GreenTime":"55","YellowTime":"5"}
     */

    private ServerInfoBean serverInfo;

    public ServerInfoBean getServerInfo() {
        return serverInfo;
    }

    public void setServerInfo(ServerInfoBean serverInfo) {
        this.serverInfo = serverInfo;
    }

    public static class ServerInfoBean {
        /**
         * RedTime : 25
         * GreenTime : 55
         * YellowTime : 5
         */

        private String RedTime;
        private String GreenTime;
        private String YellowTime;

        public String getRedTime() {
            return RedTime;
        }

        public void setRedTime(String RedTime) {
            this.RedTime = RedTime;
        }

        public String getGreenTime() {
            return GreenTime;
        }

        public void setGreenTime(String GreenTime) {
            this.GreenTime = GreenTime;
        }

        public String getYellowTime() {
            return YellowTime;
        }

        public void setYellowTime(String YellowTime) {
            this.YellowTime = YellowTime;
        }
    }
}
