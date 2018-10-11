package cn.kiway.mp.bean;



public class ResigerBean {

    /**
     * data : {"adress":"","business":"","company":"","companyPerson":"","companyPhone":"",
     * "createTime":1534750684709,"cuserId":"","email":"","id":"cd07dd114b45425394154180483c9cad","img":"",
     * "isadmin":0,"ischeck":0,"iscompany":0,"nickName":"蔚轱","password":"123124","phone":"","userImg":"",
     * "userName":"123214"}
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
         * adress :
         * business :
         * company :
         * companyPerson :
         * companyPhone :
         * createTime : 1534750684709
         * cuserId :
         * email :
         * id : cd07dd114b45425394154180483c9cad
         * img :
         * isadmin : 0
         * ischeck : 0
         * iscompany : 0
         * nickName : 蔚轱
         * password : 123124
         * phone :
         * userImg :
         * userName : 123214
         */

        private String adress;
        private String business;
        private String company;
        private String companyPerson;
        private String companyPhone;
        private long createTime;
        private String cuserId;
        private String email;
        private String id;
        private String img;
        private int isadmin;
        private int ischeck;
        private int iscompany;
        private String nickName;
        private String password;
        private String phone;
        private String userImg;
        private String userName;

        public String getAdress() {
            return adress;
        }

        public void setAdress(String adress) {
            this.adress = adress;
        }

        public String getBusiness() {
            return business;
        }

        public void setBusiness(String business) {
            this.business = business;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getCompanyPerson() {
            return companyPerson;
        }

        public void setCompanyPerson(String companyPerson) {
            this.companyPerson = companyPerson;
        }

        public String getCompanyPhone() {
            return companyPhone;
        }

        public void setCompanyPhone(String companyPhone) {
            this.companyPhone = companyPhone;
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
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

        public int getIscompany() {
            return iscompany;
        }

        public void setIscompany(int iscompany) {
            this.iscompany = iscompany;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getUserImg() {
            return userImg;
        }

        public void setUserImg(String userImg) {
            this.userImg = userImg;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
