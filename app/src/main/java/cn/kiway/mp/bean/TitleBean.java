package cn.kiway.mp.bean;

import java.util.List;



public class TitleBean {


    /**
     * statusCode : 200
     * data : {"totalPage":1,"list":[{"id":"bcc3183fba5d4e729a14924afa31491f","type":1,"name":"游戏",
     * "createTime":1533889445000},{"id":"dc0524620647462bae8cd714400e013d","type":2,"name":"教育",
     * "createTime":1533889446000},{"id":"0dc07914bd2e4194bb0b2c2e930cc462","type":3,"name":"新闻",
     * "createTime":1533889448000},{"id":"f25cd7fd1172429186ec1df19d15ad3b","type":4,"name":"体育",
     * "createTime":1533889451000},{"id":"65ece91a4a324a8290968e5ac5bac48b","type":5,"name":"学习",
     * "createTime":1534155180000}],"totalRecord":5}
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
         * totalPage : 1
         * list : [{"id":"bcc3183fba5d4e729a14924afa31491f","type":1,"name":"游戏","createTime":1533889445000},
         * {"id":"dc0524620647462bae8cd714400e013d","type":2,"name":"教育","createTime":1533889446000},
         * {"id":"0dc07914bd2e4194bb0b2c2e930cc462","type":3,"name":"新闻","createTime":1533889448000},
         * {"id":"f25cd7fd1172429186ec1df19d15ad3b","type":4,"name":"体育","createTime":1533889451000},
         * {"id":"65ece91a4a324a8290968e5ac5bac48b","type":5,"name":"学习","createTime":1534155180000}]
         * totalRecord : 5
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
             * id : bcc3183fba5d4e729a14924afa31491f
             * type : 1
             * name : 游戏
             * createTime : 1533889445000
             */

            private String id;
            private int type;
            private String name;
            private long createTime;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }
        }
    }
}
