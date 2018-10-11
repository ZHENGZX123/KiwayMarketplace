package cn.kiway.mp.bean;

import java.util.List;

public class AppDetailBean {
    /**
     * statusCode : 200
     * data : {"app":{"id":"6bb92ae37f264204ac82f4654d5c72e4","appName":"钉钉","appType":5,"introduce":"钉钉办公",
     * "downUrl":"http://192.168.8.51:8087/static/other/20180816/825456c6c1aa4e0398ce89357c8d2b30.exe",
     * "version":"12.0","userId":"28d1b89d636c446a94964ae7b0e39936",
     * "appIcon":"http://192.168.8.51:8087/static/image/20180816/798e1ad565cb479fab91ebc748608773.jpg",
     * "downNumber":null,"screenshot":null,"createTime":1534407291000,"updateTime":1534407291000,"size":111526448,
     * "projectId":null,"ischeck":1,"family":0,"cuserId":null,"classifyType":2,"packageName":"DingTalk","star":0,
     * "suffix":".exe"},"user":{"id":"28d1b89d636c446a94964ae7b0e39936","userName":"123","password":"123456",
     * "nickName":"张三","company":null,"email":"1234567890@qq.com","phone":"12345678910","createTime":1534298652000,
     * "iscompany":0,"adress":"深圳南山",
     * "img":"http://192.168.8.51:8087/static/image/20180810/8c3b704ea22f42049b8f6950d7ff9c42.jpg",
     * "business":"420984199606080000","isadmin":0,"ischeck":1,
     * "userImg":"http://192.168.8.51:8087/static/image/20180810/0b8f4e78ad534ed8ab865879c332b315.jpg",
     * "companyPhone":"undefined","companyPerson":"undefined","cuserId":null},
     * "coments":[{"commentId":"936a90e149c04f44a79d2f170ce442d3","comment":"很不错的应用，五星好评",
     * "userId":"67ddca343b774c268bd3b7ee364a7ba1","userName":"王五",
     * "avater":"http://192.168.8.51:8087/static/image/20180816/9aad89a6fe064832beb6e2b6a9bc8839.jpg",
     * "createTime":1534474045743}]}
     * errorMsg : null
     */

    private int statusCode;
    private DataBean data;
    private String errorMsg;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataBean {
        /**
         * app : {"id":"6bb92ae37f264204ac82f4654d5c72e4","appName":"钉钉","appType":5,"introduce":"钉钉办公",
         * "downUrl":"http://192.168.8.51:8087/static/other/20180816/825456c6c1aa4e0398ce89357c8d2b30.exe",
         * "version":"12.0","userId":"28d1b89d636c446a94964ae7b0e39936",
         * "appIcon":"http://192.168.8.51:8087/static/image/20180816/798e1ad565cb479fab91ebc748608773.jpg",
         * "downNumber":null,"screenshot":null,"createTime":1534407291000,"updateTime":1534407291000,
         * "size":111526448,"projectId":null,"ischeck":1,"family":0,"cuserId":null,"classifyType":2,
         * "packageName":"DingTalk","star":0,"suffix":".exe"}
         * user : {"id":"28d1b89d636c446a94964ae7b0e39936","userName":"123","password":"123456","nickName":"张三",
         * "company":null,"email":"1234567890@qq.com","phone":"12345678910","createTime":1534298652000,"iscompany":0,
         * "adress":"深圳南山","img":"http://192.168.8.51:8087/static/image/20180810/8c3b704ea22f42049b8f6950d7ff9c42.jpg
         * ","business":"420984199606080000","isadmin":0,"ischeck":1,
         * "userImg":"http://192.168.8.51:8087/static/image/20180810/0b8f4e78ad534ed8ab865879c332b315.jpg",
         * "companyPhone":"undefined","companyPerson":"undefined","cuserId":null}
         * coments : [{"commentId":"936a90e149c04f44a79d2f170ce442d3","comment":"很不错的应用，五星好评",
         * "userId":"67ddca343b774c268bd3b7ee364a7ba1","userName":"王五",
         * "avater":"http://192.168.8.51:8087/static/image/20180816/9aad89a6fe064832beb6e2b6a9bc8839.jpg",
         * "createTime":1534474045743}]
         */

        private AppBean app;
        private UserBean user;
        private List<ComentsBean> coments;

        public AppBean getApp() {
            return app;
        }

        public void setApp(AppBean app) {
            this.app = app;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public List<ComentsBean> getComents() {
            return coments;
        }

        public void setComents(List<ComentsBean> coments) {
            this.coments = coments;
        }

        public static class AppBean {
            /**
             * id : 6bb92ae37f264204ac82f4654d5c72e4
             * appName : 钉钉
             * appType : 5
             * introduce : 钉钉办公
             * downUrl : http://192.168.8.51:8087/static/other/20180816/825456c6c1aa4e0398ce89357c8d2b30.exe
             * version : 12.0
             * userId : 28d1b89d636c446a94964ae7b0e39936
             * appIcon : http://192.168.8.51:8087/static/image/20180816/798e1ad565cb479fab91ebc748608773.jpg
             * downNumber : null
             * screenshot : null
             * createTime : 1534407291000
             * updateTime : 1534407291000
             * size : 111526448
             * projectId : null
             * ischeck : 1
             * family : 0
             * cuserId : null
             * classifyType : 2
             * packageName : DingTalk
             * star : 0
             * suffix : .exe
             */

            private String id = "";
            private String appName = "";
            private int appType;
            private String introduce = "";
            private String downUrl = "";
            private String version = "";
            private String userId = "";
            private String appIcon = "";
            private long downNumber;
            private String screenshot = "";
            private long createTime;
            private long updateTime;
            private int size;
            private String projectId = "";
            private int ischeck;
            private int family;
            private String cuserId = "";
            private int classifyType;
            private String packageName = "";
            private int star;
            private String suffix = "";

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getAppName() {
                return appName;
            }

            public void setAppName(String appName) {
                this.appName = appName;
            }

            public int getAppType() {
                return appType;
            }

            public void setAppType(int appType) {
                this.appType = appType;
            }

            public String getIntroduce() {
                return introduce;
            }

            public void setIntroduce(String introduce) {
                this.introduce = introduce;
            }

            public String getDownUrl() {
                return downUrl;
            }

            public void setDownUrl(String downUrl) {
                this.downUrl = downUrl;
            }

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getAppIcon() {

                return appIcon;
            }

            public void setAppIcon(String appIcon) {
                this.appIcon = appIcon;
            }

            public long getDownNumber() {
                return downNumber;
            }

            public void setDownNumber(long downNumber) {
                this.downNumber = downNumber;
            }

            public String getScreenshot() {
                return screenshot;
            }

            public void setScreenshot(String screenshot) {
                this.screenshot = screenshot;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(long updateTime) {
                this.updateTime = updateTime;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public String getProjectId() {
                return projectId;
            }

            public void setProjectId(String projectId) {
                this.projectId = projectId;
            }

            public int getIscheck() {
                return ischeck;
            }

            public void setIscheck(int ischeck) {
                this.ischeck = ischeck;
            }

            public int getFamily() {
                return family;
            }

            public void setFamily(int family) {
                this.family = family;
            }

            public String getCuserId() {
                return cuserId;
            }

            public void setCuserId(String cuserId) {
                this.cuserId = cuserId;
            }

            public int getClassifyType() {
                return classifyType;
            }

            public void setClassifyType(int classifyType) {
                this.classifyType = classifyType;
            }

            public String getPackageName() {
                return packageName;
            }

            public void setPackageName(String packageName) {
                this.packageName = packageName;
            }

            public int getStar() {
                return 5;
            }

            public void setStar(int star) {
                this.star = star;
            }

            public String getSuffix() {
                return suffix;
            }

            public void setSuffix(String suffix) {
                this.suffix = suffix;
            }
        }

        public static class UserBean {
            /**
             * id : 28d1b89d636c446a94964ae7b0e39936
             * userName : 123
             * password : 123456
             * nickName : 张三
             * company : ""
             * email : 1234567890@qq.com
             * phone : 12345678910
             * createTime : 1534298652000
             * iscompany : 0
             * adress : 深圳南山
             * img : http://192.168.8.51:8087/static/image/20180810/8c3b704ea22f42049b8f6950d7ff9c42.jpg
             * business : 420984199606080000
             * isadmin : 0
             * ischeck : 1
             * userImg : http://192.168.8.51:8087/static/image/20180810/0b8f4e78ad534ed8ab865879c332b315.jpg
             * companyPhone : ""
             * companyPerson : ""
             * cuserId : ""
             */

            private String id = "";
            private String userName = "";
            private String password = "";
            private String nickName = "";
            private String company = "";
            private String email = "";
            private String phone = "";
            private long createTime;
            private int iscompany;
            private String adress = "";
            private String img = "";
            private String business = "";
            private int isadmin;
            private int ischeck;
            private String userImg = "";
            private String companyPhone = "";
            private String companyPerson = "";
            private String cuserId = "";

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public int getIscompany() {
                return iscompany;
            }

            public void setIscompany(int iscompany) {
                this.iscompany = iscompany;
            }

            public String getAdress() {
                return adress;
            }

            public void setAdress(String adress) {
                this.adress = adress;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getBusiness() {
                return business;
            }

            public void setBusiness(String business) {
                this.business = business;
            }

            public int getIsadmin() {
                return isadmin;
            }

            public void setIsadmin(int isadmin) {
                this.isadmin = isadmin;
            }

            public int getIscheck() {
                return ischeck;
            }

            public void setIscheck(int ischeck) {
                this.ischeck = ischeck;
            }

            public String getUserImg() {
                return userImg;
            }

            public void setUserImg(String userImg) {
                this.userImg = userImg;
            }

            public String getCompanyPhone() {
                return companyPhone;
            }

            public void setCompanyPhone(String companyPhone) {
                this.companyPhone = companyPhone;
            }

            public String getCompanyPerson() {
                return companyPerson;
            }

            public void setCompanyPerson(String companyPerson) {
                this.companyPerson = companyPerson;
            }

            public String getCuserId() {
                return cuserId;
            }

            public void setCuserId(String cuserId) {
                this.cuserId = cuserId;
            }
        }

        public static class ComentsBean {
            /**
             * commentId : 936a90e149c04f44a79d2f170ce442d3
             * comment : 很不错的应用，五星好评
             * userId : 67ddca343b774c268bd3b7ee364a7ba1
             * userName : 王五
             * avater : http://192.168.8.51:8087/static/image/20180816/9aad89a6fe064832beb6e2b6a9bc8839.jpg
             * createTime : 1534474045743
             */

            private String commentId = "";
            private String comment = "";
            private String userId = "";
            private String userName = "";
            private String avater = "";
            private long createTime;

            public String getCommentId() {
                return commentId;
            }

            public void setCommentId(String commentId) {
                this.commentId = commentId;
            }

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getUserName() {
                if (userName == null || userName.equals(""))
                    userName = "匿名网友";
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getAvater() {
                return avater;
            }

            public void setAvater(String avater) {
                this.avater = avater;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }
        }
    }

//    /**
//     * id : 1631363
//     * name : 黑马程序员
//     * packageName : com.itheima.www
//     * iconUrl : app/com.itheima.www/icon.jpg
//     * stars : 5.0
//     * downloadNum : 40万+
//     * version : 1.1.0605.0
//     * date : 2015-06-10
//     * size : 91767
//     * downloadUrl : app/com.itheima.www/com.itheima.www.apk
//     * des :
// 黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员黑马程序员
//     * author : 黑马程序员
//     * screen : ["app/com.itheima.www/screen0.jpg","app/com.itheima.www/screen1.jpg","app/com.itheima
// .www/screen2.jpg","app/com.itheima.www/screen3.jpg","app/com.itheima.www/screen4.jpg"]
//     * safe : [{"safeUrl":"app/com.itheima.www/safeicon0.jpg","safeDesUrl":"app/com.itheima.www/safedesurl0.jpg",
// "safeDes":"已通过安智市场安全检测，请放心使用","safeDesColor":0},{"safeUrl":"app/com.itheima.www/safeicon1.jpg",
// "safeDesUrl":"app/com.itheima.www/safeDesUrl1.jpg","safeDes":"无任何形式的广告","safeDesColor":0}]
//     */
//
//    private int id;
//    private String name;
//    private String packageName;
//    private String iconUrl;
//    private float stars;
//    private String downloadNum;
//    private String version;
//    private String date;
//    private int size;
//    private String downloadUrl;
//    private String des;
//    private String author;
//    private List<String> screen;
//    /**
//     * safeUrl : app/com.itheima.www/safeicon0.jpg
//     * safeDesUrl : app/com.itheima.www/safedesurl0.jpg
//     * safeDes : 已通过安智市场安全检测，请放心使用
//     * safeDesColor : 0
//     */
//
//    private List<SafeBean> safe;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPackageName() {
//        return packageName;
//    }
//
//    public void setPackageName(String packageName) {
//        this.packageName = packageName;
//    }
//
//    public String getIconUrl() {
//        return iconUrl;
//    }
//
//    public void setIconUrl(String iconUrl) {
//        this.iconUrl = iconUrl;
//    }
//
//    public float getStars() {
//        return stars;
//    }
//
//    public void setStars(float stars) {
//        this.stars = stars;
//    }
//
//    public String getDownloadNum() {
//        return downloadNum;
//    }
//
//    public void setDownloadNum(String downloadNum) {
//        this.downloadNum = downloadNum;
//    }
//
//    public String getVersion() {
//        return version;
//    }
//
//    public void setVersion(String version) {
//        this.version = version;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
//
//    public int getSize() {
//        return size;
//    }
//
//    public void setSize(int size) {
//        this.size = size;
//    }
//
//    public String getDownloadUrl() {
//        return downloadUrl;
//    }
//
//    public void setDownloadUrl(String downloadUrl) {
//        this.downloadUrl = downloadUrl;
//    }
//
//    public String getDes() {
//        return des;
//    }
//
//    public void setDes(String des) {
//        this.des = des;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public List<String> getScreen() {
//        return screen;
//    }
//
//    public void setScreen(List<String> screen) {
//        this.screen = screen;
//    }
//
//    public List<SafeBean> getSafe() {
//        return safe;
//    }
//
//    public void setSafe(List<SafeBean> safe) {
//        this.safe = safe;
//    }
//
//    public static class SafeBean {
//        private String safeUrl;
//        private String safeDesUrl;
//        private String safeDes;
//        private int safeDesColor;
//
//        public String getSafeUrl() {
//            return safeUrl;
//        }
//
//        public void setSafeUrl(String safeUrl) {
//            this.safeUrl = safeUrl;
//        }
//
//        public String getSafeDesUrl() {
//            return safeDesUrl;
//        }
//
//        public void setSafeDesUrl(String safeDesUrl) {
//            this.safeDesUrl = safeDesUrl;
//        }
//
//        public String getSafeDes() {
//            return safeDes;
//        }
//
//        public void setSafeDes(String safeDes) {
//            this.safeDes = safeDes;
//        }
//
//        public int getSafeDesColor() {
//            return safeDesColor;
//        }
//
//        public void setSafeDesColor(int safeDesColor) {
//            this.safeDesColor = safeDesColor;
//        }
//    }


}
