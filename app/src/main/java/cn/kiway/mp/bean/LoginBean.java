package cn.kiway.mp.bean;


public class LoginBean {

    /**
     * data :
     * {"token":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjMiLCJleHAiOjE1MzQ3NTQyMjZ9.eDv2oULJAytUWYHYer4mzDA7qnuf19NU
     * -nXsOoqWaN8","data":{"id":"28d1b89d636c446a94964ae7b0e39936","userName":"123","password":"123456",
     * "nickName":"张三","email":"1234567890@qq.com","phone":"12345678910","createTime":"Aug 15, 2018 10:04:12 AM",
     * "iscompany":0,"adress":"深圳南山",
     * "img":"http://192.168.8.51:8087/static/image/20180810/8c3b704ea22f42049b8f6950d7ff9c42.jpg",
     * "business":"420984199606080000","isadmin":0,"ischeck":1,
     * "userImg":"http://192.168.8.51:8087/static/image/20180810/0b8f4e78ad534ed8ab865879c332b315.jpg",
     * "companyPhone":"undefined","companyPerson":"undefined"}}
     * errorMsg :
     * statusCode : 200
     */

    private DataBeanX data;
    private String errorMsg;
    private int statusCode;

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
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

    public static class DataBeanX {
        /**
         * token : eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjMiLCJleHAiOjE1MzQ3NTQyMjZ9.eDv2oULJAytUWYHYer4mzDA7qnuf19NU
         * -nXsOoqWaN8
         * data : {"id":"28d1b89d636c446a94964ae7b0e39936","userName":"123","password":"123456","nickName":"张三",
         * "email":"1234567890@qq.com","phone":"12345678910","createTime":"Aug 15, 2018 10:04:12 AM","iscompany":0,
         * "adress":"深圳南山","img":"http://192.168.8.51:8087/static/image/20180810/8c3b704ea22f42049b8f6950d7ff9c42.jpg
         * ","business":"420984199606080000","isadmin":0,"ischeck":1,
         * "userImg":"http://192.168.8.51:8087/static/image/20180810/0b8f4e78ad534ed8ab865879c332b315.jpg",
         * "companyPhone":"undefined","companyPerson":"undefined"}
         */

        private String token;
        private DataBean data;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 28d1b89d636c446a94964ae7b0e39936
             * userName : 123
             * password : 123456
             * nickName : 张三
             * email : 1234567890@qq.com
             * phone : 12345678910
             * createTime : Aug 15, 2018 10:04:12 AM
             * iscompany : 0
             * adress : 深圳南山
             * img : http://192.168.8.51:8087/static/image/20180810/8c3b704ea22f42049b8f6950d7ff9c42.jpg
             * business : 420984199606080000
             * isadmin : 0
             * ischeck : 1
             * userImg : http://192.168.8.51:8087/static/image/20180810/0b8f4e78ad534ed8ab865879c332b315.jpg
             * companyPhone : undefined
             * companyPerson : undefined
             */

            private String id;
            private String userName;
            private String password;
            private String nickName;
            private String email;
            private String phone;
            private String createTime;
            private int iscompany;
            private String adress;
            private String img;
            private String business;
            private int isadmin;
            private int ischeck;
            private String userImg;
            private String companyPhone;
            private String companyPerson;

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

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
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
        }
    }
}
