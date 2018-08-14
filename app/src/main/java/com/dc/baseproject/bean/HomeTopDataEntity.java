package com.dc.baseproject.bean;

import java.util.List;

/**
 * @ClassName: HomeTopDataEntity
 * @Description:首页第一个接口数据实体，轮播图等
 * @Author: dingchao
 * @Date: 2018/8/13 13:53
 */
public class HomeTopDataEntity {

    /**
     * msg : 获取信息成功!
     * code : 200
     * data : {"imgUrl":[{"flag":true,"urlPC":"http://www.youpuchina.com/turnShop.html","imgId":null,"artitleId":null,"title":"","urlApp":"http://m.zpb.youpuchina.com/#/turnShop","url":"http://up-img.oss-cn-beijing.aliyuncs.com/article/20180517/6qRfEfoKYMxGDHfzIFxqiaEk7uBxMbs2.jpg"},{"flag":false,"urlPC":"","imgId":null,"artitleId":33,"title":"","urlApp":"","url":"http://up-img.oss-cn-beijing.aliyuncs.com/article/20180517/DTzxUYaJEHjwZBJbKtgoufCDKzpvTVS9.jpg"},{"flag":false,"urlPC":null,"imgId":null,"artitleId":33,"title":"","urlApp":null,"url":"http://up-img.oss-cn-beijing.aliyuncs.com/upload/20141209512150.JPG"},{"flag":false,"urlPC":null,"imgId":null,"artitleId":34,"title":"","urlApp":null,"url":""},{"flag":false,"urlPC":null,"imgId":null,"artitleId":33,"title":"","urlApp":null,"url":"http://up-img.oss-cn-beijing.aliyuncs.com/upload/WechatIMG74.png"},{"flag":false,"urlPC":null,"imgId":null,"artitleId":33,"title":"","urlApp":null,"url":"http://up-img.oss-cn-beijing.aliyuncs.com/upload/WechatIMG74.png"}],"zhpUrl":"http://api.zpb.youpuchina.com/turnShop.html","zpUrl":"http://api.zpb.youpuchina.com/seekShop.html","shopLineNum":57786,"shopNewNum":673,"title":[{"id":47,"title":"优铺租赁业务"},{"id":46,"title":"优铺专访"},{"id":44,"title":"优铺专访丨合创中国董事长弓超：要办一座商业地产的\u201c专科医院\u201d"}],"peopleNum":161604,"url":"http://api.zpb.youpuchina.com/consult.html"}
     * status : 0
     */

    private String msg;
    private int code;
    private DataBean data;
    private String status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class DataBean {
        /**
         * imgUrl : [{"flag":true,"urlPC":"http://www.youpuchina.com/turnShop.html","imgId":null,"artitleId":null,"title":"","urlApp":"http://m.zpb.youpuchina.com/#/turnShop","url":"http://up-img.oss-cn-beijing.aliyuncs.com/article/20180517/6qRfEfoKYMxGDHfzIFxqiaEk7uBxMbs2.jpg"},{"flag":false,"urlPC":"","imgId":null,"artitleId":33,"title":"","urlApp":"","url":"http://up-img.oss-cn-beijing.aliyuncs.com/article/20180517/DTzxUYaJEHjwZBJbKtgoufCDKzpvTVS9.jpg"},{"flag":false,"urlPC":null,"imgId":null,"artitleId":33,"title":"","urlApp":null,"url":"http://up-img.oss-cn-beijing.aliyuncs.com/upload/20141209512150.JPG"},{"flag":false,"urlPC":null,"imgId":null,"artitleId":34,"title":"","urlApp":null,"url":""},{"flag":false,"urlPC":null,"imgId":null,"artitleId":33,"title":"","urlApp":null,"url":"http://up-img.oss-cn-beijing.aliyuncs.com/upload/WechatIMG74.png"},{"flag":false,"urlPC":null,"imgId":null,"artitleId":33,"title":"","urlApp":null,"url":"http://up-img.oss-cn-beijing.aliyuncs.com/upload/WechatIMG74.png"}]
         * zhpUrl : http://api.zpb.youpuchina.com/turnShop.html
         * zpUrl : http://api.zpb.youpuchina.com/seekShop.html
         * shopLineNum : 57786
         * shopNewNum : 673
         * title : [{"id":47,"title":"优铺租赁业务"},{"id":46,"title":"优铺专访"},{"id":44,"title":"优铺专访丨合创中国董事长弓超：要办一座商业地产的\u201c专科医院\u201d"}]
         * peopleNum : 161604
         * url : http://api.zpb.youpuchina.com/consult.html
         */

        private String zhpUrl;
        private String zpUrl;
        private int shopLineNum;
        private int shopNewNum;
        private int peopleNum;
        private String url;
        private List<ImgUrlBean> imgUrl;
        private List<TitleBean> title;

        public String getZhpUrl() {
            return zhpUrl;
        }

        public void setZhpUrl(String zhpUrl) {
            this.zhpUrl = zhpUrl;
        }

        public String getZpUrl() {
            return zpUrl;
        }

        public void setZpUrl(String zpUrl) {
            this.zpUrl = zpUrl;
        }

        public int getShopLineNum() {
            return shopLineNum;
        }

        public void setShopLineNum(int shopLineNum) {
            this.shopLineNum = shopLineNum;
        }

        public int getShopNewNum() {
            return shopNewNum;
        }

        public void setShopNewNum(int shopNewNum) {
            this.shopNewNum = shopNewNum;
        }

        public int getPeopleNum() {
            return peopleNum;
        }

        public void setPeopleNum(int peopleNum) {
            this.peopleNum = peopleNum;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<ImgUrlBean> getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(List<ImgUrlBean> imgUrl) {
            this.imgUrl = imgUrl;
        }

        public List<TitleBean> getTitle() {
            return title;
        }

        public void setTitle(List<TitleBean> title) {
            this.title = title;
        }

        public static class ImgUrlBean {
            /**
             * flag : true
             * urlPC : http://www.youpuchina.com/turnShop.html
             * imgId : null
             * artitleId : null
             * title :
             * urlApp : http://m.zpb.youpuchina.com/#/turnShop
             * url : http://up-img.oss-cn-beijing.aliyuncs.com/article/20180517/6qRfEfoKYMxGDHfzIFxqiaEk7uBxMbs2.jpg
             */

            private boolean flag;
            private String urlPC;
            private Object imgId;
            private Object artitleId;
            private String title;
            private String urlApp;
            private String url;

            public boolean isFlag() {
                return flag;
            }

            public void setFlag(boolean flag) {
                this.flag = flag;
            }

            public String getUrlPC() {
                return urlPC;
            }

            public void setUrlPC(String urlPC) {
                this.urlPC = urlPC;
            }

            public Object getImgId() {
                return imgId;
            }

            public void setImgId(Object imgId) {
                this.imgId = imgId;
            }

            public Object getArtitleId() {
                return artitleId;
            }

            public void setArtitleId(Object artitleId) {
                this.artitleId = artitleId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrlApp() {
                return urlApp;
            }

            public void setUrlApp(String urlApp) {
                this.urlApp = urlApp;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class TitleBean {
            /**
             * id : 47
             * title : 优铺租赁业务
             */

            private int id;
            private String title;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
