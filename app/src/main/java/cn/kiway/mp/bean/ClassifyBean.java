package cn.kiway.mp.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/8/20.
 */

public class ClassifyBean {

    /**
     * statusCode : 200
     * data : {"totalPage":1,"list":[{"id":"f0c36c9d5be14c88949a245f1af8291a","name":"网站应用","type":1,
     * "createTime":1533888696000},{"id":"2453a7ec690e4b80939b7e02ed31b9ae","name":"移动应用","type":2,
     * "createTime":1533888727000},{"id":"a4cdeed4d5834b7184ffe916b6d852f1","name":"小程序","type":3,
     * "createTime":1534154388000}],"totalRecord":3}
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
         * list : [{"id":"f0c36c9d5be14c88949a245f1af8291a","name":"网站应用","type":1,"createTime":1533888696000},
         * {"id":"2453a7ec690e4b80939b7e02ed31b9ae","name":"移动应用","type":2,"createTime":1533888727000},
         * {"id":"a4cdeed4d5834b7184ffe916b6d852f1","name":"小程序","type":3,"createTime":1534154388000}]
         * totalRecord : 3
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
             * id : f0c36c9d5be14c88949a245f1af8291a
             * name : 网站应用
             * type : 1
             * createTime : 1533888696000
             */

            private String id;
            private String name;
            private int type;
            private long createTime;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
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
