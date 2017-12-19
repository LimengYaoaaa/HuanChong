package com.jiyun.huanchong.ui.activity.bean;

import java.util.List;

/**
 * Created by hp on 2017/12/19.
 */

public class OrderBean {

    /**
     * ret : true
     * desc : [{"orderState":35,"usersInfo":"{\"position\":0,\"birthday\":795628800000,\"userImage\":\"/a87ff679a2f3e71d9181a67b7542122c/IMG_20160410_174931.png\",\"id\":0,\"family\":\"博美之家\",\"userId\":\"a87ff679a2f3e71d9181a67b7542122c\",\"userName\":\"于洪乾\",\"userPhone\":15910721339,\"qq\":5716185877,\"isUse\":0,\"identityCard\":0,\"intro\":\"大型宠物寄养乐园有点像升级版的宠物店，这里的活动空间大，宠物们可以不用住在小小的笼子里，它们有自己的活动空间，而且不会与其他狗狗接触，生活环境很安全。可即便如此，大型宠物寄养乐园可能还是无法一对一照顾到每只狗的所有需求，主人最好考虑清楚以后再选择如何寄养或是否寄养等。\",\"address\":\"北京市昌平区沙河沙杨路18号，北京科技职业学院21公寓楼539\",\"userSex\":1,\"realName\":\"于洪乾\",\"wechat\":\"yhq1913_wechat\"}","usersId":"a87ff679a2f3e71d9181a67b7542122c","serviceEndTime":1460519432000,"id":0,"orderItemsInfo":"[{\"id\":0,\"petPricingCode\":\"13\",\"petImage\":\"/a87ff679a2f3e71d9181a67b7542122c/IMG_20160408_112916.png\",\"petId\":\"3\",\"petDuration\":22,\"price\":22,\"serviceCode\":\"2\",\"servicePrice\":80,\"serviceName\":\"接送\"}]","paidUpAmount":200,"orderAmount":200,"userWord":"很好","userId":"a87ff679a2f3e71d9181a67b7542122c","serviceBeginTime":1415072439000,"orderId":"3"}]
     */

    private boolean ret;
    private List<DescBean> desc;

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public List<DescBean> getDesc() {
        return desc;
    }

    public void setDesc(List<DescBean> desc) {
        this.desc = desc;
    }

    public static class DescBean {
        /**
         * orderState : 35
         * usersInfo : {"position":0,"birthday":795628800000,"userImage":"/a87ff679a2f3e71d9181a67b7542122c/IMG_20160410_174931.png","id":0,"family":"博美之家","userId":"a87ff679a2f3e71d9181a67b7542122c","userName":"于洪乾","userPhone":15910721339,"qq":5716185877,"isUse":0,"identityCard":0,"intro":"大型宠物寄养乐园有点像升级版的宠物店，这里的活动空间大，宠物们可以不用住在小小的笼子里，它们有自己的活动空间，而且不会与其他狗狗接触，生活环境很安全。可即便如此，大型宠物寄养乐园可能还是无法一对一照顾到每只狗的所有需求，主人最好考虑清楚以后再选择如何寄养或是否寄养等。","address":"北京市昌平区沙河沙杨路18号，北京科技职业学院21公寓楼539","userSex":1,"realName":"于洪乾","wechat":"yhq1913_wechat"}
         * usersId : a87ff679a2f3e71d9181a67b7542122c
         * serviceEndTime : 1460519432000
         * id : 0
         * orderItemsInfo : [{"id":0,"petPricingCode":"13","petImage":"/a87ff679a2f3e71d9181a67b7542122c/IMG_20160408_112916.png","petId":"3","petDuration":22,"price":22,"serviceCode":"2","servicePrice":80,"serviceName":"接送"}]
         * paidUpAmount : 200
         * orderAmount : 200
         * userWord : 很好
         * userId : a87ff679a2f3e71d9181a67b7542122c
         * serviceBeginTime : 1415072439000
         * orderId : 3
         */

        private int orderState;
        private String usersInfo;
        private String usersId;
        private long serviceEndTime;
        private int id;
        private String orderItemsInfo;
        private int paidUpAmount;
        private int orderAmount;
        private String userWord;
        private String userId;
        private long serviceBeginTime;
        private String orderId;

        public int getOrderState() {
            return orderState;
        }

        public void setOrderState(int orderState) {
            this.orderState = orderState;
        }

        public String getUsersInfo() {
            return usersInfo;
        }

        public void setUsersInfo(String usersInfo) {
            this.usersInfo = usersInfo;
        }

        public String getUsersId() {
            return usersId;
        }

        public void setUsersId(String usersId) {
            this.usersId = usersId;
        }

        public long getServiceEndTime() {
            return serviceEndTime;
        }

        public void setServiceEndTime(long serviceEndTime) {
            this.serviceEndTime = serviceEndTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOrderItemsInfo() {
            return orderItemsInfo;
        }

        public void setOrderItemsInfo(String orderItemsInfo) {
            this.orderItemsInfo = orderItemsInfo;
        }

        public int getPaidUpAmount() {
            return paidUpAmount;
        }

        public void setPaidUpAmount(int paidUpAmount) {
            this.paidUpAmount = paidUpAmount;
        }

        public int getOrderAmount() {
            return orderAmount;
        }

        public void setOrderAmount(int orderAmount) {
            this.orderAmount = orderAmount;
        }

        public String getUserWord() {
            return userWord;
        }

        public void setUserWord(String userWord) {
            this.userWord = userWord;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public long getServiceBeginTime() {
            return serviceBeginTime;
        }

        public void setServiceBeginTime(long serviceBeginTime) {
            this.serviceBeginTime = serviceBeginTime;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }
    }
}
