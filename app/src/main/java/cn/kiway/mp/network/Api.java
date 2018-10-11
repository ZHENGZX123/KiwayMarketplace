package cn.kiway.mp.network;

import cn.kiway.mp.bean.AppDetailBean;
import cn.kiway.mp.bean.AppListItem;
import cn.kiway.mp.bean.ClassifyBean;
import cn.kiway.mp.bean.LoginBean;
import cn.kiway.mp.bean.ResigerBean;
import cn.kiway.mp.bean.TitleBean;
import cn.kiway.mp.bean.UserInfoBean;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;



public interface Api {

    /**
     * 获取app列表 携带类型
     */
    @GET("app/getApp")
    Call<AppListItem> listApps(@Query("appType") int appType, @Query("current") int current, @Query("classifyType")
            int classifyType);

    /**
     * 获取app列表 不携带类型
     */
    @GET("app/getApp")
    Call<AppListItem> listApps(@Query("appType") int appType, @Query("current") int current);

    /**
     * 获取App类型列表
     */
    @GET("apptype")
    Call<TitleBean> appTitle();

    /**
     * 登录
     */
    @FormUrlEncoded
    @POST("user/login")
    Call<LoginBean> login(@Field("userName") String userName, @Field("password") String password);

    /**
     * 注册
     */
    @FormUrlEncoded
    @POST("user/register")
    Call<ResigerBean> register(@Field("userName") String userName, @Field("password") String password);

    /**
     * 获取个人信息
     */
    @GET("user/userInfo")
    Call<UserInfoBean> getUserInfo(@Header("x-auth-token") String token);

    /**
     * 根据id获取app详细信息
     */
    @GET("app/appDetail/{id}")
    Call<AppDetailBean> appDetail(@Path("id") String id);

    /**
     * 获取app分类列表
     */
    @GET("classify")
    Call<ClassifyBean> classify();

    /**
     * 根据关键字查找应用
     */
    @GET("app/search")
    Call<AppListItem> likeApps(@Query("likes") String likes);
}
