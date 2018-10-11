package cn.kiway.mp.bean;

import java.util.List;


public class AppListItem {


    /**
     * data : {"totalPage":1,"list":[{"appIcon":"http://192.168.8.51:8087/static/image/20180820
     * /50207a878480418e9994ef89bf17fe8a.jpg","appName":"Sublime Text3","appType":4,"classifyType":3,
     * "createTime":1534748898000,"cuserId":"0dfaf3da5a32439bafa9fc2c40e534b8","downNumber":0,
     * "downUrl":"http://192.168.8.51:8087/static/other/20180820/a0ea8e08552341c5a71e72f8cb0eaa9f.exe","family":0,
     * "id":"2a6cc83bad7448c2b05a297963a8ae1e","introduce":"一个前端编辑器软件","ischeck":1,"packageName":"Sublime Text3",
     * "projectId":"","screenshot":"http://192.168.8.51:8087/static/image/20180820/c48190e7361c41a7ad348d49b3ce26ae
     * .jpg::http://192.168.8.51:8087/static/image/20180820/e699740b1c4d4d938b448a4fd5b74ffc
     * .jpg::http://192.168.8.51:8087/static/image/20180820/0ba26b927695477dbf3fb8aef47f03fa
     * .jpg::http://192.168.8.51:8087/static/image/20180820/217baea4418940e38567f95a6972f9e3.jpg","size":22491664,
     * "star":0,"suffix":".exe","updateTime":1534748899000,"userId":"28d1b89d636c446a94964ae7b0e39936",
     * "version":"11.0.1"},{"appIcon":"http://192.168.8.51:8087/static/image/20180817
     * /cc89f861989e42cab02c370ee722d650.jpeg","appName":"Git","appType":5,"classifyType":2,
     * "createTime":1534500398000,"cuserId":"0dfaf3da5a32439bafa9fc2c40e534b8","downNumber":0,
     * "downUrl":"http://192.168.8.51:8087/static/other/20180817/9916776e70ae4777ba97f2fe6303c793.exe","family":0,
     * "id":"476a2420b8f9439e909e12903385613d","introduce":"Git一下，在一下","ischeck":1,"packageName":"Git",
     * "projectId":"","screenshot":"","size":38755408,"star":0,"suffix":".exe","updateTime":1534500398000,
     * "userId":"9427592de3154d09825fadacdd7e7137","version":"10.0"},
     * {"appIcon":"http://192.168.8.51:8087/static/image/20180816/798e1ad565cb479fab91ebc748608773.jpg",
     * "appName":"钉钉","appType":5,"classifyType":2,"createTime":1534737408000,
     * "cuserId":"28d1b89d636c446a94964ae7b0e39936","downNumber":0,
     * "downUrl":"http://192.168.8.51:8087/static/other/20180816/825456c6c1aa4e0398ce89357c8d2b30.exe","family":0,
     * "id":"6bb92ae37f264204ac82f4654d5c72e4","introduce":"钉钉办公","ischeck":1,"packageName":"DingTalk",
     * "projectId":"","screenshot":"http://192.168.8.51:8087/static/image/20180820
     * /30b6c25498be41779c0c58c300401e30.jpg::http://192.168.8.51:8087/static/image/20180820
     * /daeccd7b114746f1b00b2d470ebb0f26.jpg","size":111526448,"star":0,"suffix":".exe","updateTime":1534737408000,
     * "userId":"28d1b89d636c446a94964ae7b0e39936","version":"12.0"},
     * {"appIcon":"http://192.168.8.51:8087/static/image/20180816/2daac6afd8214cb49f2a4e7b91866ba6.jpg",
     * "appName":"微信","appType":8,"classifyType":2,"createTime":1534735386000,"cuserId":"","downNumber":0,
     * "downUrl":"http://192.168.8.51:8087/static/other/20180816/46f8a3c6d5b94013acb764f8a44465b0.exe","family":0,
     * "id":"72673c70fdfe4b88bc5a1bdceac2ddc1","introduce":"微信聊天","ischeck":1,"packageName":"WeChat","projectId":"",
     * "screenshot":"http://192.168.8.51:8087/static/image/20180820/305be4b7e7a048f185847f7fb23ac628.jpg::http
     * ://192.168.8.51:8087/static/image/20180820/106972978e9d479194dd3488674f45f7.jpg::http://192.168.8.51:8087
     * /static/image/20180820/d90900c39dc54217912d20a800ac7ebb
     * .jpg::http://192.168.8.51:8087/static/image/20180820/f8ec41bca4a846f890a9e5e7ff66445e.jpg","size":36731584,
     * "star":0,"suffix":"null","updateTime":1534735386000,"userId":"28d1b89d636c446a94964ae7b0e39936",
     * "version":"11.0"},{"appIcon":"","appName":"百度","appType":1,"classifyType":2,"createTime":1534410123000,
     * "cuserId":"","downNumber":0,"downUrl":"https://www.baidu.com/","family":0,
     * "id":"7ec39a7fd6ae4a61be298930dfad4b50","introduce":"百度","ischeck":1,"packageName":"","projectId":"",
     * "screenshot":"","size":0,"star":0,"suffix":"","updateTime":1534410123000,
     * "userId":"28d1b89d636c446a94964ae7b0e39936","version":""},
     * {"appIcon":"http://192.168.8.51:8087/static/image/20180820/b0b8b40c1fa74c528255bee6627e07da.jpg",
     * "appName":"kiway市场应用","appType":6,"classifyType":1,"createTime":1534748922000,"cuserId":"","downNumber":0,
     * "downUrl":"https://www.baidu.com/","family":0,"id":"bf07b67a61424597a210a013689d5fb6","introduce":"市场应用，一个平台",
     * "ischeck":1,"packageName":"12.0.3","projectId":"",
     * "screenshot":"http://192.168.8.51:8087/static/image/20180820/0dc4006666524626aa4bbe35b611641e.jpg","size":0,
     * "star":0,"suffix":"null","updateTime":1534748923000,"userId":"28d1b89d636c446a94964ae7b0e39936",
     * "version":"3.0"},{"appIcon":"","appName":"4399","appType":1,"classifyType":1,"createTime":1534219564000,
     * "cuserId":"","downNumber":0,"downUrl":"http://192.168.8.51:8087/static/image/20180813
     * /d041fa65f9cb4acc8b29d752b484268e.jpg","family":0,"id":"d288070da7704ac7b17927d3ac790484",
     * "introduce":"4399小游戏","ischeck":1,"packageName":"","projectId":"","screenshot":"","size":35209,"star":0,
     * "suffix":"","updateTime":1534219564000,"userId":"28d1b89d636c446a94964ae7b0e39936","version":"2.0"},
     * {"appIcon":"","appName":"111","appType":2,"classifyType":3,"createTime":1534410126000,"cuserId":"",
     * "downNumber":0,"downUrl":"http://192.168.8.51:8087/static/image/20180814/db41aa9958784172bd0ae5bfb1604d77.jpg
     * ","family":0,"id":"d614a270d7be4d5cb89dc160a5f4ef27","introduce":"222","ischeck":1,"packageName":"",
     * "projectId":"","screenshot":"","size":33705,"star":0,"suffix":"","updateTime":1534410126000,
     * "userId":"28d1b89d636c446a94964ae7b0e39936","version":"10"}],"totalRecord":8}
     * errorMsg :
     * statusCode : 200
     */

    private DataBean data;
    private String errorMsg;
    private int statusCode;

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

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public static class DataBean {
        /**
         * totalPage : 1
         * list : [{"appIcon":"http://192.168.8.51:8087/static/image/20180820/50207a878480418e9994ef89bf17fe8a.jpg",
         * "appName":"Sublime Text3","appType":4,"classifyType":3,"createTime":1534748898000,
         * "cuserId":"0dfaf3da5a32439bafa9fc2c40e534b8","downNumber":0,
         * "downUrl":"http://192.168.8.51:8087/static/other/20180820/a0ea8e08552341c5a71e72f8cb0eaa9f.exe",
         * "family":0,"id":"2a6cc83bad7448c2b05a297963a8ae1e","introduce":"一个前端编辑器软件","ischeck":1,
         * "packageName":"Sublime Text3","projectId":"",
         * "screenshot":"http://192.168.8.51:8087/static/image/20180820/c48190e7361c41a7ad348d49b3ce26ae
         * .jpg::http://192.168.8.51:8087/static/image/20180820/e699740b1c4d4d938b448a4fd5b74ffc
         * .jpg::http://192.168.8.51:8087/static/image/20180820/0ba26b927695477dbf3fb8aef47f03fa
         * .jpg::http://192.168.8.51:8087/static/image/20180820/217baea4418940e38567f95a6972f9e3.jpg",
         * "size":22491664,"star":0,"suffix":".exe","updateTime":1534748899000,
         * "userId":"28d1b89d636c446a94964ae7b0e39936","version":"11.0.1"},
         * {"appIcon":"http://192.168.8.51:8087/static/image/20180817/cc89f861989e42cab02c370ee722d650.jpeg",
         * "appName":"Git","appType":5,"classifyType":2,"createTime":1534500398000,
         * "cuserId":"0dfaf3da5a32439bafa9fc2c40e534b8","downNumber":0,
         * "downUrl":"http://192.168.8.51:8087/static/other/20180817/9916776e70ae4777ba97f2fe6303c793.exe",
         * "family":0,"id":"476a2420b8f9439e909e12903385613d","introduce":"Git一下，在一下","ischeck":1,
         * "packageName":"Git","projectId":"","screenshot":"","size":38755408,"star":0,"suffix":".exe",
         * "updateTime":1534500398000,"userId":"9427592de3154d09825fadacdd7e7137","version":"10.0"},
         * {"appIcon":"http://192.168.8.51:8087/static/image/20180816/798e1ad565cb479fab91ebc748608773.jpg",
         * "appName":"钉钉","appType":5,"classifyType":2,"createTime":1534737408000,
         * "cuserId":"28d1b89d636c446a94964ae7b0e39936","downNumber":0,
         * "downUrl":"http://192.168.8.51:8087/static/other/20180816/825456c6c1aa4e0398ce89357c8d2b30.exe",
         * "family":0,"id":"6bb92ae37f264204ac82f4654d5c72e4","introduce":"钉钉办公","ischeck":1,
         * "packageName":"DingTalk","projectId":"",
         * "screenshot":"http://192.168.8.51:8087/static/image/20180820/30b6c25498be41779c0c58c300401e30.jpg::http
         * ://192.168.8.51:8087/static/image/20180820/daeccd7b114746f1b00b2d470ebb0f26.jpg","size":111526448,
         * "star":0,"suffix":".exe","updateTime":1534737408000,"userId":"28d1b89d636c446a94964ae7b0e39936",
         * "version":"12.0"},{"appIcon":"http://192.168.8.51:8087/static/image/20180816
         * /2daac6afd8214cb49f2a4e7b91866ba6.jpg","appName":"微信","appType":8,"classifyType":2,
         * "createTime":1534735386000,"cuserId":"","downNumber":0,
         * "downUrl":"http://192.168.8.51:8087/static/other/20180816/46f8a3c6d5b94013acb764f8a44465b0.exe",
         * "family":0,"id":"72673c70fdfe4b88bc5a1bdceac2ddc1","introduce":"微信聊天","ischeck":1,"packageName":"WeChat",
         * "projectId":"","screenshot":"http://192.168.8.51:8087/static/image/20180820
         * /305be4b7e7a048f185847f7fb23ac628.jpg::http://192.168.8.51:8087/static/image/20180820
         * /106972978e9d479194dd3488674f45f7.jpg::http://192.168.8.51:8087/static/image/20180820
         * /d90900c39dc54217912d20a800ac7ebb
         * .jpg::http://192.168.8.51:8087/static/image/20180820/f8ec41bca4a846f890a9e5e7ff66445e.jpg",
         * "size":36731584,"star":0,"suffix":"null","updateTime":1534735386000,
         * "userId":"28d1b89d636c446a94964ae7b0e39936","version":"11.0"},{"appIcon":"","appName":"百度","appType":1,
         * "classifyType":2,"createTime":1534410123000,"cuserId":"","downNumber":0,"downUrl":"https://www.baidu
         * .com/","family":0,"id":"7ec39a7fd6ae4a61be298930dfad4b50","introduce":"百度","ischeck":1,"packageName":"",
         * "projectId":"","screenshot":"","size":0,"star":0,"suffix":"","updateTime":1534410123000,
         * "userId":"28d1b89d636c446a94964ae7b0e39936","version":""},
         * {"appIcon":"http://192.168.8.51:8087/static/image/20180820/b0b8b40c1fa74c528255bee6627e07da.jpg",
         * "appName":"kiway市场应用","appType":6,"classifyType":1,"createTime":1534748922000,"cuserId":"","downNumber":0,
         * "downUrl":"https://www.baidu.com/","family":0,"id":"bf07b67a61424597a210a013689d5fb6",
         * "introduce":"市场应用，一个平台","ischeck":1,"packageName":"12.0.3","projectId":"",
         * "screenshot":"http://192.168.8.51:8087/static/image/20180820/0dc4006666524626aa4bbe35b611641e.jpg",
         * "size":0,"star":0,"suffix":"null","updateTime":1534748923000,"userId":"28d1b89d636c446a94964ae7b0e39936",
         * "version":"3.0"},{"appIcon":"","appName":"4399","appType":1,"classifyType":1,"createTime":1534219564000,
         * "cuserId":"","downNumber":0,
         * "downUrl":"http://192.168.8.51:8087/static/image/20180813/d041fa65f9cb4acc8b29d752b484268e.jpg",
         * "family":0,"id":"d288070da7704ac7b17927d3ac790484","introduce":"4399小游戏","ischeck":1,"packageName":"",
         * "projectId":"","screenshot":"","size":35209,"star":0,"suffix":"","updateTime":1534219564000,
         * "userId":"28d1b89d636c446a94964ae7b0e39936","version":"2.0"},{"appIcon":"","appName":"111","appType":2,
         * "classifyType":3,"createTime":1534410126000,"cuserId":"","downNumber":0,
         * "downUrl":"http://192.168.8.51:8087/static/image/20180814/db41aa9958784172bd0ae5bfb1604d77.jpg",
         * "family":0,"id":"d614a270d7be4d5cb89dc160a5f4ef27","introduce":"222","ischeck":1,"packageName":"",
         * "projectId":"","screenshot":"","size":33705,"star":0,"suffix":"","updateTime":1534410126000,
         * "userId":"28d1b89d636c446a94964ae7b0e39936","version":"10"}]
         * totalRecord : 8
         */

        private int totalPage;
        private int totalRecord;
        private List<ListBean> list;

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getTotalRecord() {
            return totalRecord;
        }

        public void setTotalRecord(int totalRecord) {
            this.totalRecord = totalRecord;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * appIcon : http://192.168.8.51:8087/static/image/20180820/50207a878480418e9994ef89bf17fe8a.jpg
             * appName : Sublime Text3
             * appType : 4
             * classifyType : 3
             * createTime : 1534748898000
             * cuserId : 0dfaf3da5a32439bafa9fc2c40e534b8
             * downNumber : 0
             * downUrl : http://192.168.8.51:8087/static/other/20180820/a0ea8e08552341c5a71e72f8cb0eaa9f.exe
             * family : 0
             * id : 2a6cc83bad7448c2b05a297963a8ae1e
             * introduce : 一个前端编辑器软件
             * ischeck : 1
             * packageName : Sublime Text3
             * projectId :
             * screenshot : http://192.168.8.51:8087/static/image/20180820/c48190e7361c41a7ad348d49b3ce26ae
             * .jpg::http://192.168.8.51:8087/static/image/20180820/e699740b1c4d4d938b448a4fd5b74ffc
             * .jpg::http://192.168.8.51:8087/static/image/20180820/0ba26b927695477dbf3fb8aef47f03fa
             * .jpg::http://192.168.8.51:8087/static/image/20180820/217baea4418940e38567f95a6972f9e3.jpg
             * size : 22491664
             * star : 0
             * suffix : .exe
             * updateTime : 1534748899000
             * userId : 28d1b89d636c446a94964ae7b0e39936
             * version : 11.0.1
             */

            private String appIcon;
            private String appName;
            private int appType;
            private int classifyType;
            private long createTime;
            private String cuserId;
            private int downNumber;
            private String downUrl;
            private int family;
            private String id;
            private String introduce;
            private int ischeck;
            private String packageName;
            private String projectId;
            private String screenshot;
            private int size;
            private int star;
            private String suffix;
            private long updateTime;
            private String userId;
            private String version;

            public String getAppIcon() {
                return appIcon;
            }

            public void setAppIcon(String appIcon) {
                this.appIcon = appIcon;
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

            public int getClassifyType() {
                return classifyType;
            }

            public void setClassifyType(int classifyType) {
                this.classifyType = classifyType;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public String getCuserId() {
                return cuserId;
            }

            public void setCuserId(String cuserId) {
                this.cuserId = cuserId;
            }

            public int getDownNumber() {
                return downNumber;
            }

            public void setDownNumber(int downNumber) {
                this.downNumber = downNumber;
            }

            public String getDownUrl() {
                return downUrl;
            }

            public void setDownUrl(String downUrl) {
                this.downUrl = downUrl;
            }

            public int getFamily() {
                return family;
            }

            public void setFamily(int family) {
                this.family = family;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getIntroduce() {
                return introduce;
            }

            public void setIntroduce(String introduce) {
                this.introduce = introduce;
            }

            public int getIscheck() {
                return ischeck;
            }

            public void setIscheck(int ischeck) {
                this.ischeck = ischeck;
            }

            public String getPackageName() {
                return packageName;
            }

            public void setPackageName(String packageName) {
                this.packageName = packageName;
            }

            public String getProjectId() {
                return projectId;
            }

            public void setProjectId(String projectId) {
                this.projectId = projectId;
            }

            public String getScreenshot() {
                return screenshot;
            }

            public void setScreenshot(String screenshot) {
                this.screenshot = screenshot;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getStar() {
                return star;
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

            public long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(long updateTime) {
                this.updateTime = updateTime;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }
        }
    }
}
